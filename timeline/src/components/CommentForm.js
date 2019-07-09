import React, { Component } from 'react';
import { Form, Button, Icon, Input } from 'antd'

import { getToken, getUser } from '../authentication';

import './CommentForm.css';

class CommentForm extends Component {


    articleID = this.props.articleID;

    userID = getUser().userID;

    handleSubmit = e => {
        e.preventDefault();
        this.props.form.validateFields((err, values) => {
            if (!err) {
                console.log('Received values of form: ', values);
                const content = {
                    articleID : this.articleID,
                    userID : this.userID,
                    content : values.comment
                }
                fetch('http://localhost:8080/comment/insert', {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json',
                        'token': getToken()
                    },
                    body: JSON.stringify(content)
                }).then(response => {
                    if (response.status === 200) {
                        //글올리기 성공
                        console.log("성공")
                        this.props.form.resetFields()                
                        this.props.callBack()
                    } else {
                        console.log("댓글올리기 실패")
                    }
                });

            }
        });
    };

    render() {
        const { getFieldDecorator } = this.props.form;

        return (
            <div>
                <Form layout="inline" onSubmit={this.handleSubmit}>
                    <Form.Item >
                        {getFieldDecorator('comment', {
                            rules: [{ required: true, message: 'Please input comment!' }],
                        })(
                            <Input
                                prefix={<Icon type="message" style={{ color: 'rgba(0,0,0,.25)' }} />}
                                placeholder="Comment"
                                onPressEnter={this.handleSubmit}
                            />,
                        )}
                    </Form.Item>
                    <Form.Item>
                        <Button type="default" htmlType="submit">
                            Submit
                        </Button>
                    </Form.Item>

                </Form>
            </div>
        );
    }
}

export default Form.create()(CommentForm);