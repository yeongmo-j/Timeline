import React, { Component } from 'react';
import { getToken, getUser } from '../authentication';
import { Avatar, Icon, Row, Col, Button, Popconfirm, notification } from 'antd';
import FbImageLibrary from 'react-fb-image-grid'
import CommentModal from './CommentModal';
import {history} from '../History';

import { Link } from "react-router-dom";


import './Article.css';

//소식 삭제 알림
const openNotificationWithIcon = type => {
    notification[type]({
      message: '소식 삭제 성공!',
      description:
        '당신의 소식이 더이상 친구들에게 공유되지 않습니다!',
    });
  };  

class Article extends Component {

    state = {
    };

    constructor(props) {
        super(props)

        //liked를 "true" or "false"로 받음
        this.state = {
            articleUserID: this.props.article.userID,
            articleUsername: this.props.article.username,
            articleUserprofile: this.props.article.profile,
            articleID: this.props.article.articleID,
            content: this.props.article.content.split('<br>').map((line,i) => {
                return (<span key={i}>{line}<br /></span>);
            }), //줄바꾸기 변환 : 글 입력할 때 db에는 \n을 <br>로 바꾸어 저장 한 다음에 이걸 다시 줄바꿈 해서 출력해줘야 하므로
            like: this.props.article.like,
            liked: this.props.article.liked, // "true" 혹은 "false"의 문자열로 받아옴
            photo: this.props.article.photo,
            createdtime: this.props.article.createdtime
        };
    }

    //좋아요 클릭했을 경우
    likeClick = () => {
        fetch("http://localhost:8080/liked/" + this.state.articleID + "/" + getUser().userID, {
            method: 'PUT',
            headers: {
                'token': getToken()
            }
        })
        if (this.state.liked == "true") {
            //좋아요 취소
            this.setState({
                like: this.state.like - 1,
                liked: "false"
            })
        } else {
            this.setState({
                like: this.state.like + 1,
                liked: "true"
            })
        }
    }

    //소식에 등록되어 있는 여러개의 사진 받아와서 FbImageLibrary로 출력
    getPhoto = (photoArr) => {
        if (photoArr == null || photoArr == [] || photoArr =="") {
            return null;
        }
        let result = []
        photoArr.map(photo => result.push('http://localhost:8080/photo/download?filename='+photo))
        return (<FbImageLibrary images={result} />);
    }

    //프로필 사진을 받아오기
    getOnePhoto = (fileName, username) => {
        if (fileName === "" || fileName == null)
            return <Avatar size='large'>{username}</Avatar>
        else
            return <Avatar size='large' src={'http://localhost:8080/photo/download?filename=' + fileName} />
    }

    //날짜를 형식에 맞춰서 문자열로 리턴
    getDate = (date) => {
        return date
    }

    //글 삭제
    confirm = (e) => { 
        fetch("http://localhost:8080/article/"+this.state.articleID+"/"+getUser().userID, {
            method: 'DELETE',
            headers: {
                'token': getToken()
            }
        })
            .then(response => {
                if (response.status == 200) {
                    openNotificationWithIcon('success')
                    this.props.deleteArticle(this.props.article)
                } else {
                    //오류 처리
                }
            })
    }

    cancel = (e) => {
        console.log(e);
    }

    //소식 삭제 버튼
    deleteButton = (userID, articleUserID) => {
        if (userID == articleUserID) {
            return (
                <Popconfirm
                    title="이 소식을 삭제하시겠습니까?"
                    onConfirm={this.confirm}
                    onCancel={this.cancel}
                    okText="Yes"
                    cancelText="No"
                >
                    <a href="#">X</a>
                </Popconfirm>
            )
        } else {
            return null
        }
    }

    //이름클릭했을 때
    clickName = () => {
        history.push('/home/'+this.state.articleUserID)
    }

    render() {

        return (
            <div className="article" id='box'>
                <div>
                    <div className='inline' >
                        {this.getOnePhoto(this.state.articleUserprofile, this.state.articleUsername)}
                    </div>
                    <div className='inline'>
                        <div className='titlAndDate' id='title'>
                            <Link onClick={this.clickName} ><b>{this.state.articleUserID}</b></Link>
                            <div className='inline rightAlign'>
                                {this.deleteButton(getUser().userID, this.state.articleUserID)}
                            </div>
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
                            <center><Button type={this.state.liked == "true" ? "primary" : "default"} icon="like" onClick={this.likeClick}>좋아요</Button></center>
                        </Col>
                        <Col span={12}>
                            <center><CommentModal articleID={this.state.articleID} /></center>
                        </Col>
                    </Row>
                </div>
            </div>
        );
    }
}

export default Article;