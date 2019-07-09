import React, { Component } from 'react';
import { getUser, getToken } from '../authentication';
import { Modal, Button } from 'antd';

import CommentForm from './CommentForm';
import Comment from './Comment';

class CommentModal extends Component {
  state = {
    visible: false,
    articleID: this.props.articleID,
    commnts: []
  };

  constructor(props) {
    super(props)
    this.loadComments()
  }

  showModal = () => {
    this.setState({
      visible: true,
    });
    this.loadComments()
  };

  handleOk = e => {
    this.setState({
      visible: false,
    });
  };

  handleCancel = e => {
    console.log(e);
    this.setState({
      visible: false,
    });
  };

  loadComments = () => {
    const requesturl = 'http://localhost:8080/comment/get/' + this.props.articleID;
    fetch(requesturl, {
      method: 'GET',
      headers: {
        'token': getToken()
      }
    })
      .then(response => response.json())
      .then(response => {
        this.setState({ comments: response })
        console.log(response)
      })
  }

  render() {
    return (
      <div>
        <Button type="default" icon="message" onClick={this.showModal}>댓글</Button>
        <Modal
          title="댓글"
          visible={this.state.visible}
          onOk={this.handleOk}
          onCancel={this.handleCancel}
          width="750px"
        >
          <Comment articleID={this.state.articleID} comments={this.state.comments} />
          <CommentForm callBack={this.loadComments} articleID={this.state.articleID} />
        </Modal>
      </div>
    );
  }
}

export default CommentModal;