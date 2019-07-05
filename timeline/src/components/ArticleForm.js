import React, { Component } from 'react';
import { Form, Icon, Input, Button, Upload, Modal } from 'antd';

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

    //여기위까지가 사진 폼 

    handleSubmit = e => {
        e.preventDefault();
        this.props.form.validateFields((err, values) => {
            if (!err) {
                console.log('Received values of form: ', values);
                console.log(this.state.fileList) //여기서 각 원소의 response.name이 파일이름이고, 이를 db에 저장시켜주면 됨
                let fileList = []
                this.state.fileList.map(file => {
                    fileList.push(file.response.name)
                })
                let fileNames = fileList.join('/')
                //db에는 파일명이 저장됨. 파일명의 리스트를 만들어서 그들 사이를 /로 조인해줌. 나중에 split해서 쓸 것임

                //userID 임시 설정
                let article = {
                    'userID' : 1,
                    'content' : values.content,
                    'photo' : fileNames
                }

                fetch('http://localhost:8080/article/insert', {
                    method:'POST',
                    headers: { 'Content-Type': 'application/json' },
                    body : JSON.stringify(article)
                }).then(response => response.json())
                .then(rsp => {
                    console.log(rsp)
                })

            }
        });
    };

    render() {

        //여기부터 사진폼

        const { previewVisible, previewImage, fileList } = this.state;
        const uploadButton = (
          <div>
            <Icon type="plus" />
            <div className="ant-upload-text">Upload</div>
          </div>
        );
        
        //여기까지가 사진 폼 

        const { getFieldDecorator } = this.props.form;

        return (
            <Form onSubmit={this.handleSubmit} className="article-form">
                <Form.Item>
                    {getFieldDecorator('content', {
                        rules: [{ required: true, message: 'Please input your story!' }],
                    })(
                        <TextArea
                            placeholder="오늘 무슨 일이 일어났나요?"
                            autosize={{ minRows: 5, maxRows: 6 }}
                        />,
                    )}
                </Form.Item>
                <Form.Item>
                    {getFieldDecorator('photo', {
                        rules: [{ required: false }],
                    })(
                        <div className="clearfix">
                            <Upload
                                name="file"
                                action="http://localhost:8080/photo/upload/1" //유저아이디 1로 설정
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
                <Form.Item>
                    <Button type="primary" htmlType="submit" className="article-form-button">
                        Upload
                    </Button>
                </Form.Item>
            </Form>
        );
    }
}

export default Form.create()(ArticleForm);
