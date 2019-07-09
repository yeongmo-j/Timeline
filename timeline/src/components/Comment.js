import React, { Component } from 'react';
import { getUser, getToken } from '../authentication';
import { List, Avatar } from 'antd'

import './Comment.css'
class Comment extends Component {

    articleID = this.props.articleID;

    scrollToBottom() {
        const scrollHeight = this.messageList.scrollHeight;
        const height = this.messageList.clientHeight;
        const maxScrollTop = scrollHeight - height;
        this.messageList.scrollTop = maxScrollTop > 0 ? maxScrollTop : 0;
    }

    componentDidUpdate() {
        this.scrollToBottom();
    }

    componentDidMount() {
        this.scrollToBottom();
    }

    getDate = (date) => {
        return "" + date.date.year + "/" + date.date.month + "/" + date.date.day + " " + date.time.hour + ":" + date.time.minute
    }

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
                <List
                    itemLayout="horizontal"
                    dataSource={this.props.comments}
                    renderItem={item => (
                        <List.Item>
                            <List.Item.Meta
                                avatar={this.getOnePhoto(item.profile, item.username)}
                                title={<span><b>{item.username}</b><span id="date">{this.getDate(item.createdtime)}</span></span>}
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