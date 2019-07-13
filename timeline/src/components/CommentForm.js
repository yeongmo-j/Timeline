import React, { Component } from 'react';
import { Form, Button, Icon, Input, message } from 'antd'

import { getToken, getUser } from '../authentication';

import './CommentForm.css';

class CommentForm extends Component {

    //댓글 입력 버튼 눌렀을 때
    handleSubmit = e => {
        e.preventDefault();
        this.props.form.validateFields((err, values) => {
            if (!err) {
                console.log('Received values of form: ', values);
                //원하는 폼으로 가공
                const content = {
                    articleID : this.props.articleID,
                    userID : getUser().userID,
                    content : values.comment
                }
                //http요청 보내기
                fetch('http://localhost:8080/comment', {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json',
                        'token': getToken()
                    },
                    body: JSON.stringify(content)
                }).then(response => {
                    if (response.status === 200) {
                        //글올리기 성공
                        message.success('댓글이 업로드 되었습니다.');
                        //댓글 창 리셋
                        this.props.form.resetFields()      
                        return response.json()
                    } else {
                        //오류 처리
                        return null;
                    }
                })
                .then(response => {
                    //다시 렌더링 하기 위해
                    this.props.addComment(response);
                })
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