import React, { Component } from 'react';
import { Form, Icon, Popover, Button, Upload, Modal, notification } from 'antd';
import { getUser, getToken } from '../authentication';


function getBase64(file) {
    return new Promise((resolve, reject) => {
        const reader = new FileReader();
        reader.readAsDataURL(file);
        reader.onload = () => resolve(reader.result);
        reader.onerror = error => reject(error);
    });
}

class ChangeProfile extends Component {

    state = {
        previewVisible: false,
        previewImage: '',
        fileList: [

        ],
        visible: false,
    };

    userID = getUser().userID

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

    handleSubmit = e => {
        e.preventDefault();
        this.props.form.validateFields((err, values) => {
            if (!err) {
                console.log('Received values of form: ', values);
                console.log(this.state.fileList) //여기서 각 원소의 response.name이 파일이름이고, 이를 db에 저장시켜주면 됨
                console.log(this.state.fileList[0].response.name)

                let user = {
                    'id': this.userID,
                    'profile': this.state.fileList[0].response.name
                }

                fetch('http://localhost:8080/user/profile', {
                    method: 'PUT',
                    headers: {
                        'Content-Type': 'application/json',
                        'token': getToken()
                    },
                    body: JSON.stringify(user)
                }).then(response => {
                    if (response.status === 200) {
                        //글올리기 성공
                        console.log("성공")
                        this.props.form.resetFields()
                        this.hide()
                    } else {
                        console.log("글올리기 실패")
                    }
                });
            }
        });
    };

    hide = () => {
        this.setState({
            visible: false,
        });
    };

    handleVisibleChange = visible => {
        this.setState({ visible });
    };

    render() {
        const { previewVisible, previewImage, fileList } = this.state;
        const { getFieldDecorator } = this.props.form;

        const uploadButton = (
            <div>
                <Icon type="plus" />
                <div className="ant-upload-text">Upload</div>
            </div>
        );

        return (
            <Popover
                content={

                    <div className="articleform" id='box'>
                        <Form onSubmit={this.handleSubmit} className="article-form">
                            <Form.Item>
                                {getFieldDecorator('photo', {
                                    rules: [{ required: false }],
                                })(
                                    <div className="clearfix">
                                        <Upload
                                            name="file"
                                            action={"http://localhost:8080/photo/upload/" + this.userID}
                                            listType="picture-card"
                                            fileList={fileList}
                                            onPreview={this.handlePreview}
                                            onChange={this.handleChange}
                                        >
                                            {fileList.length >= 1 ? null : uploadButton}
                                        </Upload>
                                        <Modal visible={previewVisible} footer={null} onCancel={this.handleCancel}>
                                            <img alt="example" style={{ width: '100%' }} src={previewImage} />
                                        </Modal>
                                    </div>
                                )}
                            </Form.Item>
                            <Form.Item>
                                <center><Button type="primary" htmlType="submit" className="article-form-button" >
                                    Upload
                    </Button></center>
                            </Form.Item>
                        </Form>
                    </div>

                }
                title="Title"
                trigger="click"
                visible={this.state.visible}
                onVisibleChange={this.handleVisibleChange}
            >
                <Button type="primary">Click me</Button>
            </Popover>

        );
    }
}

export default Form.create()(ChangeProfile);