import React, { Component } from 'react';
import { Modal, Button } from 'antd';

import { getToken } from '../authentication';
import CommentForm from './CommentForm';
import Comment from './Comment';
import { serverUrl } from '../setting'

class CommentModal extends Component {
  state = {
    visible: false,
    articleID: this.props.articleID,
    comments: []
  };

  //버튼 눌렀을 때, visible state를 바꿔 주어 렌더링 한다음, 댓글을 불러와서 state에 저장
  showModal = () => {
    this.setState({
      visible: true,
    });
    this.loadComments()
  };

  //댓글 창 없애주기
  handleOk = e => {
    this.setState({
      visible: false,
    });
  };
  handleCancel = e => {
    this.setState({
      visible: false,
    });
  };

  //댓글 불러오기
  loadComments = () => {
    //http요청
    const requesturl = serverUrl + '/comment/' + this.props.articleID;
    fetch(requesturl, {
      method: 'GET',
      headers: {
        'token': getToken()
      }
    })
      .then(response => {
        if (response.status === 200) {
          //성공 시
          return response.json()
        } else {
          //실패
          return null;
        }
      }).then(response => {
        this.setState({ comments: response })
      })
  }

  //새로 입력한 댓글을 리스트의 맨뒤에 넣어주어 렌더링
  addComment = (comment) => {
    let comments = this.state.comments
    comments.push(comment)
    this.setState({ comments: comments })
  }

  //삭제한 소식을 state의 리스트에서 삭제해 주어 다시 렌더링
  deleteComment = (comment) => {
    let comments = this.state.comments
    comments.splice(comments.indexOf(comment), 1);
    this.setState({ comments: comments })
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
          footer={null}
        >
          <Comment articleID={this.state.articleID} comments={this.state.comments} deleteComment={this.deleteComment} />
          <CommentForm loadComments={this.loadComments} articleID={this.state.articleID} addComment={this.addComment} />
        </Modal>
      </div>
    );
  }
}

export default CommentModal;