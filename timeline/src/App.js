import React, {Component} from 'react';
import {history} from './History';
import { Router, Route, Switch } from "react-router-dom";
import { PrivateRoute } from './PrivateRoute';

import Login from './components/Login';
import Register from './components/Register';
import Main from './components/Main';

import './App.css';

class App extends Component {
  
  render() {
    return (
      <div>
        <Router history={history}>
          <Switch>
            <Route path='/login' exact component={Login} /> 
            <Route path='/register' exact component={Register} />
            <PrivateRoute path='/main' exact component={Main} />
          </Switch>
        </Router>
      </div>
    );
  }
}

export default App;
