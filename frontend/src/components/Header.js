import React from "react";
import { NavLink, withRouter } from "react-router-dom";
// import { FirebaseContext } from "../firebase";

function Header() {
  // const { user, firebase } = React.useContext(FirebaseContext);
  return (
    <div className="header">
      <div className="flex">
        <img src="/logo.png" alt="Hooks News Logo" className="logo" />
        <NavLink to="/" className="header-title">
          Popular links
        </NavLink>
        <NavLink to="/" className="header-link">
          show links
        </NavLink>
        {/* <div className="divider">|</div>
        <NavLink to="/top" className="header-link">
          top
        </NavLink> */}
        <div className="divider">|</div>
        <NavLink to="/search" className="header-link">
          search
        </NavLink>
        <>
          <div className="divider">|</div>
          <NavLink to="/create" className="header-link">
            add link
          </NavLink>
        </>
      </div>
      <div className="flex">
        {/* {user ? (
          <>
            <div className="header-name">{user.displayName}</div>
            <div className="divider"></div>
            <div className="header-button" onClick={() => firebase.logout()}>
              logout
            </div>
          </>
        ) : (
          <NavLink to="/login" className="header-link">
            login
          </NavLink>
        )} */}
      </div>
    </div>
  );
}

export default Header;
