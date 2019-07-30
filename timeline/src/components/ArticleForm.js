import React, { Component } from 'react';
import { Form, Icon, Input, Button, Upload, Modal, message } from 'antd';

import { getUser, getToken } from '../authentication';
import { serverUrl } from '../setting'

import './ArticleForm.css';

function getBase64(file) {
    return new Promise((resolve, reject) => {
        const reader = new FileReader();
        reader.readAsDataURL(file);
        reader.onload = () => resolve(reader.result);
        reader.onerror = error => reject(error);
    });
}

const { TextArea } = Input;

class ArticleForm extends Component {

    state = {
        previewVisible: false,
        previewImage: '',
        fileList: [
        ],
    };

    //유저아이디
    userID = getUser().userID

    //사진 업로드용
    handleCancel = () => this.setState({ previewVisible: false });

    handlePreview = async file => {
        if (!file.url && !file.preview) {
            file.preview = await getBase64(file.originFileObj);
        }

        this.setState({
            previewImage: file.url || file.preview,
            previewVisible: true,
        });
    };

    handleChange = ({ fileList }) => this.setState({ fileList });


    //글쓰기 버튼 눌렀을 떄
    handleSubmit = e => {
        e.preventDefault();
        this.props.form.validateFields((err, values) => {
            if (!err) {
                if (values.content.length > 250) {
                    message.error("말이 너무 깁니다!")
                } else {
                    //파일명을 /로 묶어주기
                    //db에는 파일명이 저장됨. 파일명의 리스트를 만들어서 그들 사이를 /로 조인해줌. 나중에 split해서 쓸 것임
                    let fileList = []
                    this.state.fileList.map(file => fileList.push(file.response.name))
                    let fileNames = fileList.join('/')

                    //폼 묶어주기
                    let article = {
                        'userID': this.userID,
                        'content': values.content.replace(/\n/gi, '<br>'), //줄바꿈 표시를 <br/>로 바꿔줌
                        'photo': fileNames
                    }

                    //요청
                    fetch(serverUrl + '/article', {
                        method: 'POST',
                        headers: {
                            'Content-Type': 'application/json',
                            'token': getToken()
                        },
                        body: JSON.stringify(article)
                    }).then(response => {
                        if (response.status === 200) {
                            //글올리기 성공
                            response.json().then(rsp => {
                                message.success("소식이 성공적으로 공유 되었습니다.")
                                this.props.form.resetFields()
                                this.props.addArticle(rsp)
                                this.handleCancel();
                            })
                        } else {
                            console.log("글올리기 실패")
                        }
                    });
                }
            }
        });
    };

    render() {

        //사진 업로드용
        const { previewVisible, previewImage, fileList } = this.state;
        const uploadButton = (
            <div>
                <Icon type="plus" />
                <div className="ant-upload-text">Upload</div>
            </div>
        );

        const { getFieldDecorator } = this.props.form;

        return (
            <div className="articleform" id='box'>

                {/* 타이틀 */}
                <center>당신의 소식을 친구들에게 알려주세요!</center> <br />

                {/* 폼 */}
                <Form onSubmit={this.handleSubmit} className="article-form">

                    {/* 글 작성 폼*/}
                    <Form.Item>
                        {getFieldDecorator('content', {
                            rules: [{ required: true, message: '한마디를 작성 해 주세요!' }],
                        })(
                            <TextArea
                                placeholder="오늘 무슨 일이 일어났나요?"
                                autosize={{ minRows: 5, maxRows: 6 }}
                            />,
                        )}
                    </Form.Item>

                    {/* 사진 업로드 폼 */}
                    <Form.Item>
                        {getFieldDecorator('photo', {
                            rules: [{ required: false }],
                        })(
                            <div className="clearfix">
                                <Upload
                                    name="file"
                                    action={serverUrl + "/photo/upload/" + this.userID}
                                    listType="picture-card"
                                    fileList={fileList}
                                    onPreview={this.handlePreview}
                                    onChange={this.handleChange}
                                >
                                    {fileList.length >= 5 ? null : uploadButton}
                                </Upload>
                                <Modal visible={previewVisible} footer={null} onCancel={this.handleCancel}>
                                    <img alt="example" style={{ width: '100%' }} src={previewImage} />
                                </Modal>
                            </div>
                        )}
                    </Form.Item>

                    {/* 업로드 버튼 */}
                    <Form.Item>
                        <center>
                            <Button type="primary" htmlType="submit" className="article-form-button" >
                                Upload
                            </Button>
                        </center>
                    </Form.Item>

                </Form>

            </div>
        );
    }
}

export default Form.create()(ArticleForm);
