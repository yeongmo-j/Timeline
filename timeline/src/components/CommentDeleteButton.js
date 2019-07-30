import React, { Component } from 'react';
import { message, Popconfirm} from 'antd'

import { getUser, getToken } from '../authentication';

class CommentDeleteButton extends Component {

    //댓글 삭제
    confirm = (item) => {    
        //http요청
        fetch("http://localhost:8080/comment/" + this.props.commentID, {
            method: 'DELETE',
            headers: {
                'token': getToken()
            }
        })
            .then(response => {
                if (response.status == 200) {
                    //댓글 삭제 처리
                    this.props.deleteComment(this.props.comment);
                    message.success('댓글 삭제가 완료 되었습니다!');
                } else {
                    //오류 처리
                }
            })
    }

    //취소
    cancel = (e) => {
        console.log(e);
    }

    //댓글 삭제 버튼
    deleteButton = () => {

        //댓글쓴이와 현재 유저가 같은사람이면 삭제 버튼을 노출
        if (getUser().userID === this.props.commentUserID) {
            return (
                <Popconfirm
                    title="이 댓글을 삭제하시겠습니까?"
                    onConfirm={this.confirm}
                    onCancel={this.cancel}
                    okText="Yes"
                    cancelText="No"
                >
                    <a href="#">X</a>
                </Popconfirm>
            );
        } else {
            return null;
        }
    }

    render() {
        return (
            <span>
                {this.deleteButton()}
            </span>
        );
    }
}

export default CommentDeleteButton;