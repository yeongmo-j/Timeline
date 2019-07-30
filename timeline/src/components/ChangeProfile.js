import React, { Component } from 'react';
import { Form, Icon, Popover, Button, Upload, Modal, message } from 'antd';

import { getUser, getToken } from '../authentication';

//사진 업로드
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

    //유저아이디
    userID = getUser().userID

    //사진 취소 
    handleCancel = () => this.setState({ previewVisible: false });

    //프리뷰
    handlePreview = async file => {
        if (!file.url && !file.preview) {
            file.preview = await getBase64(file.originFileObj);
        }

        this.setState({
            previewImage: file.url || file.preview,
            previewVisible: true,
        });
    };

    //파일 추가되었을 때
    handleChange = ({ fileList }) => this.setState({ fileList });

    //업로드 버튼 눌렀을 때
    handleSubmit = e => {
        e.preventDefault();
        this.props.form.validateFields((err, values) => {
            if (!err) {
                let user = {
                    'id': this.userID,
                    'profile': this.state.fileList[0].response.name
                }
                //http요청
                fetch('http://localhost:8080/user/profile', {
                    method: 'PUT',
                    headers: {
                        'Content-Type': 'application/json',
                        'token': getToken()
                    },
                    body: JSON.stringify(user)
                }).then(response => {
                    if (response.status === 200) {
                        //사진 업로드 성공
                        message.success('프로필 사진 업로드에 성공하였습니다.')
                        this.props.form.resetFields()
                        this.hide()
                    } else {
                        console.log("글올리기 실패")
                    }
                });
            }
        });
    };

    //폼 없애기
    hide = () => {
        this.setState({
            visible: false,
        });
    };

    //폼 보이기
    handleVisibleChange = visible => {
        this.setState({ visible });
    };

    render() {
        const { previewVisible, previewImage, fileList } = this.state;
        const { getFieldDecorator } = this.props.form;

        //업로드 버튼
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

                        {/* 폼 */}
                        <Form onSubmit={this.handleSubmit} className="article-form">

                            {/* 사진 업로드 폼 */}
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

                            {/* 버튼 */}
                            <Form.Item>
                                <center>
                                    <Button type="primary" htmlType="submit" className="article-form-button" >
                                        Upload
                                    </Button>
                                </center>
                            </Form.Item>

                        </Form>
                    </div>

                }
                title="프로필 사진 변경"
                trigger="click"
                visible={this.state.visible}
                onVisibleChange={this.handleVisibleChange}
            >
                {/* 이 폼을 열기 위한 버튼 */}
                <Button type="default" icon="smile" shape="circle" />
            </Popover>

        );
    }
}

export default Form.create()(ChangeProfile);