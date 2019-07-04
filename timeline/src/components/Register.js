import React, { Component } from 'react';
import { Form, Icon, Input, Button, Checkbox } from 'antd';
import { Link } from "react-router-dom";
import { history } from '../History';

import './Login.css';

class Register extends Component {

    handleSubmit = e => {
        e.preventDefault();
        this.props.form.validateFields((err, values) => {
            if (!err) {
                console.log('Received values of form: ', values);
                fetch('http://localhost:8080/regist', {
                    method : 'POST',
                    headers: { 'Content-Type': 'application/json' },
                    body : JSON.stringify(values)
                }).then(response => response.json())
                .then(rsp => {
                    const result = rsp.status.result;
                    if (result === 'positive'){
                        console.log("success")
                        history.push("/login")
                    } else {
                        console.log("fail!")
                    }
                })
            }
        });
    };

    render() {
        const { getFieldDecorator } = this.props.form;
        return (
            <Form onSubmit={this.handleSubmit} className="login-form">
                <Form.Item>
                    {getFieldDecorator('username', {
                        rules: [{ required: true, message: 'Please input your username!' }],
                    })(
                        <Input
                            prefix={<Icon type="user" style={{ color: 'rgba(0,0,0,.25)' }} />}
                            placeholder="Username"
                        />,
                    )}
                </Form.Item>
                <Form.Item>
                    {getFieldDecorator('password', {
                        rules: [{ required: true, message: 'Please input your Password!' }],
                    })(
                        <Input
                            prefix={<Icon type="lock" style={{ color: 'rgba(0,0,0,.25)' }} />}
                            type="password"
                            placeholder="Password"
                        />,
                    )}
                </Form.Item>
                <Form.Item>
                    <Button type="primary" htmlType="submit" className="login-form-button">
                        Register Now!
              </Button>
                    Or <Link to="/login">login now!</Link>
                </Form.Item>
            </Form>
        );
    }

}

export default Form.create()(Register);
