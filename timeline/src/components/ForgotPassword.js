import React, { Component } from 'react';
import { Form, Icon, Input, Button, message } from 'antd';
import { Link } from "react-router-dom";

import { history } from '../History';
import { serverUrl } from '../setting'

class ForgotPassword extends Component {

    //visibleEmail : 이메일 입력 폼
    //visibieQuestion : 이메일이 성공적으로 확인되었을 때, 질문에 대한 답을 입력하는 폼
    //visibleReset : 비밀번호 리셋 질문이 성공하였을 때 리셋하기 위한 폼
    state = {
        visibleEmail: true,
        visibleQuestion: false,
        visibleReset : false,
        question :"",
        email:""
    }

    //이메일 입력 하고 버튼을 눌렀을 때 : 비밀번호 초기화 질문을 불러와서 물어본다
    emailSubmit = e => {
        e.preventDefault();
        //이메일 주소 입력해서 이메일을 가진 회원이 존재하는지 확인. 확인 되면, 비밀번호 질문을 불러온다
        this.props.form.validateFields((err, values) => {
            if (!err) {
                //http요청
                fetch(serverUrl + '/login/forgot/question', {
                    method: 'POST',
                    headers: { 'Content-Type': 'application/json' },
                    body: JSON.stringify(values)
                })
                    .then(response => {
                        const result = response.status;
                        if (result === 200) {
                            //이메일이 존재 할 경우 성공하였을 경우
                            //질문을 받아오고, 대답을 입력하는 폼을 보여준다. 
                            response.json().then(response => {
                                console.log("@@@@@@");
                                console.log(response)
                                this.setState({
                                    question : response.question,
                                    visibleEmail : false,
                                    visibleQuestion : true,
                                    email : values.email
                                })
                            })
                        } else if (result === 403) {
                            //이메일이 존재하지 않음
                            message.error("이메일이 존재하지 않습니다!")
                        } else {
                            //내부 오류
                        }
                    })
            }
        });
    };

    //이메일 주소 입력하는 폼
    emailForm = () => {
        const { getFieldDecorator } = this.props.form;
        return (
            <span>
                <Form onSubmit={this.emailSubmit} className="form">
                    <Form.Item>
                        이메일 주소를 입력 해 주세요
                        {getFieldDecorator('email', {
                            rules: [{ required: true, message: '이메일 주소를 입력 해 주세요!' }],
                        })(
                            <Input
                                prefix={<Icon type="mail" style={{ color: 'rgba(0,0,0,.25)' }} />}
                                placeholder="Email"
                            />,
                        )}
                    </Form.Item>
                    <Form.Item>
                        <Button type="primary" htmlType="submit" className="button">
                            Submit Email Address
                        </Button>
                        Or <Link to="/login">login now!</Link>
                    </Form.Item>
                </Form >
            </span>
        );
    }

    //질문에 대한 답 입력 하고 버튼을 눌렀을 때 : 맞다면 비밀번호 초기화 폼을 불러온다
    questionSubmit = e => {
        e.preventDefault();
        this.props.form.validateFields((err, values) => {
            if (!err) {
                //http요청
                fetch(serverUrl + '/login/forgot/answer', {
                    method: 'POST',
                    headers: { 'Content-Type': 'application/json' },
                    body: JSON.stringify({
                        answer : values.answer,
                        email : this.state.email
                    })
                })
                    .then(response => {
                        const result = response.status;
                        if (result === 200) {
                            //성공하였을 경우 : 비밀번호 초기화 폼을 보여준다
                            this.setState({
                                visibleQuestion : false,
                                visibleReset : true
                            })
                        } else if (result === 403) {
                            //답이 틀림
                            message.error("정답이 일치하지 않습니다!")
                        } else {
                            //내부 오류
                        }
                    })
            }
        });
    };

    //질문에 대한 답을 입력하는 폼
    questionForm = () => {
        const { getFieldDecorator } = this.props.form;
        return (
            <span>
                <Form onSubmit={this.questionSubmit} className="form">
                    <Form.Item>
                        {this.state.question}
                        {getFieldDecorator('answer', {
                            rules: [{ required: true, message: '대답을 입력 해 주세요!' }],
                        })(
                            <Input
                                prefix={<Icon type="question" style={{ color: 'rgba(0,0,0,.25)' }} />}
                                placeholder="Answer"
                            />,
                        )}
                    </Form.Item>

                    <Form.Item>
                        <Button type="primary" htmlType="submit" className="button">
                            Submit Answer
                        </Button>
                        Or <Link to="/login">login now!</Link>
                    </Form.Item>
                </Form >
            </span>
        );
    }

    //비밀번호 두개 일치하는지 확인
    compareToFirstPassword = (rule, value, callback) => {
        const { form } = this.props;
        if (value && value !== form.getFieldValue('password')) {
            callback('두 비밀번호가 일치하지 않습니다!');
        } else {
            callback();
        }
    };

    //비밀번호 검증 과정인데 따로 규칙 지정 안했으므로 항상 true
    validateToNextPassword = (rule, value, callback) => {
        const { form } = this.props;
        form.validateFields(['confirm'], { force: true });
        callback();
    };

    //비밀번호 초기화
    resetSubmit = e => {
        e.preventDefault();
        this.props.form.validateFields((err, values) => {
            if (!err) {
                console.log('Received values of form: ', values);
                fetch(serverUrl + '/login/forgot/reset', {
                    method: 'PUT',
                    headers: { 'Content-Type': 'application/json' },
                    body: JSON.stringify({
                        email : this.state.email,
                        password : values.password
                    })
                })
                    .then(response => {
                        const result = response.status;
                        if (result === 200) {
                            //리셋이 성공하였을 경우
                            message.success("비밀번호 변경에 성공하였습니다. 로그인 페이지로 돌아갑니다!")
                            history.push('/login')
                        } else {
                            //내부 오류
                            console.log(result)
                        }
                    })
            }
        });
    };

    //비밀번호 초기화 폼
    resetForm = () => {
        const { getFieldDecorator } = this.props.form;
        return (
            <span>
                <Form onSubmit={this.resetSubmit} className="form">
                새로운 비밀번호를 입력해 주세요
                <Form.Item hasFeedback>
                    {getFieldDecorator('password', {
                        rules: [
                            {
                                required: true,
                                message: '비밀번호를 입력 해 주세요!',
                            },
                            {
                                validator: this.validateToNextPassword,
                            },
                        ],
                    })(<Input.Password
                        prefix={<Icon type="lock" style={{ color: 'rgba(0,0,0,.25)' }} />}
                        placeholder="Password" />)}
                </Form.Item>
                <Form.Item hasFeedback>
                    {getFieldDecorator('confirm', {
                        rules: [
                            {
                                required: true,
                                message: '비밀번호를 다시 한번 입력 해 주세요!',
                            },
                            {
                                validator: this.compareToFirstPassword,
                            },
                        ],
                    })(<Input.Password
                        prefix={<Icon type="lock" style={{ color: 'rgba(0,0,0,.25)' }} />}
                        placeholder="Confirm password"
                        onBlur={this.handleConfirmBlur} />)}
                </Form.Item>
                    <Form.Item>
                        <Button type="primary" htmlType="submit" className="button">
                            Reset Password
                        </Button>
                        Or <Link to="/login">login now!</Link>
                    </Form.Item>
                </Form >
            </span>
        );
    }

    render() {
        return (
            <div>
                {this.state.visibleEmail && this.emailForm()}
                {this.state.visibleQuestion && this.questionForm()}
                {this.state.visibleReset && this.resetForm()}
            </div>
        );
    }
}

export default Form.create()(ForgotPassword);
