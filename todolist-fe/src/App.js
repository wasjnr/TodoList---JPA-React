import React from "react";
import { Router } from "react-router-dom";

import { ToastContainer } from "react-toastify";
import Routes from "./Routes/";
import history from "../src/services/history";

export default () => (
  <Router history={history} basename={process.env.REACT_APP_BASENAME || ""}>
    <>
      <Routes />
      <ToastContainer autoClose={3000} />
    </>
  </Router>
);
