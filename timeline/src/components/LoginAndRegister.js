import React, { Component } from 'react';
import { Route, Switch } from "react-router-dom";

import Login from './Login';
import Register from './Register';
import './LoginAndRegister.css';
import ForgotPassword from './ForgotPassword';

class LoginAndRegister extends Component {

    render() {
        return (
            <div>
                <div className='login' >
                    <h1 id='loginHeadline'>TimeLine</h1>
                    <div style={{ margin: '10px 0' }}>
                        <Switch >
                            <Route path='/login' exact component={Login} />
                            <Route path='/register' excat component={Register} />
                            <Route path='/login/forgot' exact component={ForgotPassword} />
                        </Switch>
                    </div>
                </div>
            </div>
        );
    }
}

export default LoginAndRegister;