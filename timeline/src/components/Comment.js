import React, { Component } from 'react';
import { List, Avatar} from 'antd'

import CommentDeleteButton from './CommentDeleteButton';

import './Comment.css'

class Comment extends Component {

    //스크롤을 댓글 제일 아래로 유지하기 위해 (최신 댓글이 제일 아래 위치하므로)
    scrollToBottom() {
        const scrollHeight = this.messageList.scrollHeight;
        const height = this.messageList.clientHeight;
        const maxScrollTop = scrollHeight - height;
        this.messageList.scrollTop = maxScrollTop > 0 ? maxScrollTop : 0;
    }

    //스크롤 제일 아래로
    componentDidUpdate() {
        this.scrollToBottom();
    }
    componentDidMount() {
        this.scrollToBottom();
    }

    //날짜를 형식에 맞춰서 문자열로 리턴
    getDate = (timestamp) => {
        var date = new Date(timestamp);
        return date.getFullYear() + '/' + (date.getMonth()+1) + '/' + date.getDate() + ' ' + date.getHours() + ':' + date.getMinutes();
    }

    //프로필 사진을 얻기 위해
    getOnePhoto = (fileName, username) => {
        if (fileName === "" || fileName == null)
            return <Avatar size='large'>{username}</Avatar>
        else
            return <Avatar size='large' src={'http://localhost:8080/photo/download?filename=' + fileName} />
    }

    render() {
        return (
            <div className='list'
                ref={(div) => {
                    this.messageList = div;
                }}
            >

                {/* 리스트의 개별 원소들을 출력 */}
                <List
                    itemLayout="horizontal"
                    dataSource={this.props.comments}
                    renderItem={item => (
                        <List.Item>
                            <List.Item.Meta
                                avatar={this.getOnePhoto(item.profile, item.username)}
                                title={
                                    <span>
                                        <b>{item.username}</b>
                                        <span id="date">
                                            {this.getDate(item.createdtime)}
                                        </span>
                                        <span className='rightAlign'>
                                            <CommentDeleteButton 
                                                deleteComment={this.props.deleteComment}
                                                commentUserID={item.userID}
                                                commentID={item.commentID}
                                                comment={item}
                                                />
                                        </span>
                                    </span>
                                }
                                description={item.content}
                            />
                        </List.Item>
                    )}
                />
            </div>
        );
    }
}

export default Comment;