import React, {Component} from 'react';
import {history} from './History';
import { Router, Route, Switch } from "react-router-dom";
import { PrivateRoute } from './PrivateRoute';

import LoginAndRegister from './components/LoginAndRegister';
import Main from './components/Main';

//material ui font
import 'typeface-roboto';

import './App.css';

class App extends Component {
  
  render() {
    return (
      <div>
        <Router history={history}>
          <Switch>
            <Route path='/login' exact component={LoginAndRegister} /> 
            <Route path='/register' exact component={LoginAndRegister} />
            <Route path='/login/forgot' exact component={LoginAndRegister} />
            <PrivateRoute path='/main' exact component={Main} />
          </Switch>
        </Router>
      </div>
    );
  }
}

export default App;
