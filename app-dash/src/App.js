import React from "react";
import { BrowserRouter as Router, Switch, Route } from "react-router-dom";
import PrivateRoute from "./Components/PrivateRoute";
import { AuthProvider } from "./Config/AuthContext";
import Dashboard from "./Screens/Dashboard";
import Login from "./Screens/Login";
import Register from "./Screens/Register";
import Home from "./Screens/Home";
import PageNotFound from "./Screens/PageNotFound";

const App = () => {
  return (
      <AuthProvider>
        <Router>
          <Switch>
            <Route exact path="/" component={Home} />
            <Route exact path="/login" component={Login} />
            <Route exact path="/register" component={Register} />
            <PrivateRoute exact path="/dashboard" component={Dashboard} />
            <Route component={PageNotFound} />
          </Switch>
        </Router>
      </AuthProvider>
  );
};

export default App;
