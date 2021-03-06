import React from "react";
import useFormValidation from "./useFormValidation";
import validateLogin from "./validateLogin";
// import firebase from "../../firebase";
import { Link } from "react-router-dom";

const INITIAL_STATE = {
  name: "",
  email: "",
  password: "",
};

function Login(props) {
  const {
    handleSubmit,
    handleBlur,
    handleChange,
    values,
    errors,
    isSubmitting,
  } = useFormValidation(INITIAL_STATE, validateLogin, authenticateUser);
  const [login, setLogin] = React.useState(true);
  const [firebaseError, setFirebaseError] = React.useState(null);

  async function authenticateUser() {
    const { name, email, password } = values;
    try {
      // const response = login
      //   ? await firebase.login(email, password)
      //   : await firebase.register(name, email, password);
      // props.history.push("/");
      // console.log(response);
    } catch (err) {
      console.error("authentication Error", err);
      // setFirebaseError(err.message);
    }
  }

  return (
    <div>
      <h2 className="mv3">{login ? "Login" : "Create account"}</h2>
      <form onSubmit={handleSubmit} className="flex flex-column">
        {
          // instrukcja logiczna warunkuje wyswietlenie pola
          !login && (
            <input
              onChange={handleChange}
              value={values.name}
              name="name" //name odnosi się do nazwy pola w obiekcie INITIAL_STATE
              type="text"
              placeholder="Your name"
              autoComplete="off"
            />
          )
        }
        <input
          onChange={handleChange}
          onBlur={handleBlur}
          value={values.email}
          name="email"
          type="email"
          placeholder="Your email"
          autoComplete="off"
        />
        {errors.email && <p className="error-text">{errors.email}</p>}
        <input
          onChange={handleChange}
          onBlur={handleBlur}
          value={values.password}
          name="password"
          type="password"
          placeholder="Choose a secure password"
        />
        {errors.password && <p className="error-text">{errors.password}</p>}
        {firebaseError && <p className="error-text">{firebaseError}</p>}
        <div className="flex mt3">
          <button
            type="submit"
            className="button pointer mr2"
            disabled={isSubmitting}
            style={{ background: isSubmitting ? "grey" : "orange" }}
          >
            Submit
          </button>
          <button
            type="button"
            className="pointer button"
            onClick={() => setLogin((prevLogin) => !prevLogin)}
            // prevLogin => !prevLogin } to update pattern do zmiany stanu bazującego na poprzednim stanie
          >
            {login ? "need to create an account?" : "Already have an account?"}
          </button>
        </div>
      </form>
      <div class="forgot-password">
        <Link to="/forgot">Forgot Password?</Link>
      </div>
    </div>
  );
}

export default Login;
