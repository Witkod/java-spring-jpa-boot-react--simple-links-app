import React from "react";

function useFormValidation(initialState, validate, authenticate) {
  const [values, setValues] = React.useState(initialState);
  const [errors, setErrors] = React.useState({});
  const [isSubmitting, setSubmitting] = React.useState(false);

  React.useEffect(() => {
    if (isSubmitting) {
      const isNoErrors = Object.keys(errors).length === 0;
      if (isNoErrors) {
        //console.log("authenticated", values);
        authenticate();
        setSubmitting(false);
      } else {
        setSubmitting(false);
      }
    }
  }, [errors]);

  function handleChange(event) {
    event.persist(); //without this we loose info about event too early
    setValues((previousValues) => ({
      ...previousValues,
      [event.target.name]: event.target.value, // aktualizuje wartość pola tylko zgodnego z name
      //dzieki tego aktualizuje tylko konkretne pole a nie wszystkie
    }));
  }

  function handleBlur() {
    const validationErrors = validate(values);
    setErrors(validationErrors);
  }

  function handleSubmit(event) {
    event.preventDefault();
    const validationErrors = validate(values);
    setErrors(validationErrors);
    setSubmitting(true);
    // console.log(values);
  }
  return {
    handleSubmit,
    handleBlur,
    handleChange,
    values,
    errors,
    isSubmitting,
  };
}

export default useFormValidation;
