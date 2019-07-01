import React, {Component} from 'react';
import history from './History';
import { Router, Route, Switch } from "react-router-dom";

import './App.css';

class App extends Component {
  
  render() {
    return (
      <div>
        <Router history={history}>
          <Switch>
            <Route path='/temp' exact component={} /> 
          </Switch>
        </Router>
      </div>
    );
  }
}

export default App;
