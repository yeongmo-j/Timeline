import React, { Component } from 'react';
import { getToken, getUser } from '../authentication';
import { Avatar, Icon, Row, Col, Button } from 'antd';
import FbImageLibrary from 'react-fb-image-grid'

import CommentModal from './CommentModal';


import './Article.css';

class Article extends Component {

    state = {

    };

    constructor(props) {
        super(props)

        //liked를 "true" or "false"로 받음
        this.state = {
            userID: this.props.article.userID,
            username: this.props.article.username,
            profile: this.props.article.profile,
            articleID: this.props.article.articleID,
            content: this.props.article.content,
            like: this.props.article.like,
            liked: this.props.article.liked,
            photo: this.props.article.photo,
            createdtime: this.props.article.createdtime
        };
    }

    likeClick = () => {
        fetch("http://localhost:8080/liked/"+this.state.articleID+"/"+getUser().userID, {
            method: 'GET',
            headers: {
                'token': getToken()
            }
        })
        if (this.state.liked == "true"){
            //좋아요 취소
            this.setState({
                like : this.state.like -1,
                liked : "false"
            })
        }  else {
            this.setState({
                like : this.state.like +1,
                liked : "true"
            })
        }
    }

    getPhoto = (photoArr) => {
        if (photoArr == null || photoArr == []) {
            return null;
        }
        let result = []
        photoArr.map(photo => result.push('http://localhost:8080/photo/download?filename=' + photo))
        return (<FbImageLibrary images={result} />);
    }

    getOnePhoto = (fileName, username) => {
        if (fileName === "" || fileName == null)
            return <Avatar size='large'>{username}</Avatar>
        else
            return <Avatar size='large' src={'http://localhost:8080/photo/download?filename=' + fileName} />
    }

    getDate = (date) => {
        return "" + date.date.year + "/" + date.date.month + "/" + date.date.day + " " + date.time.hour + ":" + date.time.minute
    }

    render() {
        return (
            <div className="article" id='box'>
                <div>
                    <span >
                        {this.getOnePhoto(this.state.profile, this.state.username)}
                    </span>
                    <div className='inline'>
                        <div className='titlAndDate' id='title'>
                            <b>{this.state.username}</b>
                        </div>
                        <div className='titlAndDate' id='date'>
                            {this.getDate(this.state.createdtime)}
                        </div>
                    </div>
                </div>
                <div className='margin'>
                    {this.state.content}
                </div>
                <div>
                    {this.getPhoto(this.state.photo)}
                </div>
                <div className='margin'>
                    <Icon type="like" theme="twoTone" twoToneColor="#eb2f96" width='200px' />
                    <span className='margin'>{this.state.like}</span>
                </div>
                <div className='margin'>
                    <Row>
                        <Col span={12}>
                            <center><Button type={this.state.liked=="true" ? "primary" : "default"} icon="like" onClick={this.likeClick}>좋아요</Button></center>
                        </Col>
                        <Col span={12}>
                            <center><CommentModal articleID={this.state.articleID}/></center>
                        </Col>
                    </Row>
                </div>
            </div>
        );
    }
}

export default Article;