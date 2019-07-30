import React, { Component } from 'react';
import { Link } from "react-router-dom";
import { Avatar, Icon, Row, Col, Button, Popconfirm, message } from 'antd';
import FbImageLibrary from 'react-fb-image-grid'

import CommentModal from './CommentModal';
import { history } from '../History';
import { getToken, getUser } from '../authentication';
import { serverUrl } from '../setting'

import './Article.css';

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
            content: this.props.article.content.split('<br>').map((line, i) => {
                return (<span key={i}>{line}<br /></span>);
            }), //줄바꾸기 변환 : 글 입력할 때 db에는 \n을 <br>로 바꾸어 저장 한 다음에 이걸 다시 줄바꿈 해서 출력해줘야 하므로
            like: this.props.article.like,
            liked: this.props.article.liked, // "true" 혹은 "false"의 문자열로 받아옴
            photo: this.props.article.photo,
            createdtime: this.props.article.createdtime
        };
    }

    //좋아요 클릭했을 때 : 취소 혹은 좋아요
    likeClick = () => {
        fetch( serverUrl + "/liked/" + this.state.articleID + "/" + getUser().userID, {
            method: 'PUT',
            headers: {
                'token': getToken()
            }
        })
        if (this.state.liked === "true") {
            //좋아요 취소
            this.setState({
                like: this.state.like - 1,
                liked: "false"
            })
        } else {
            //좋아요
            this.setState({
                like: this.state.like + 1,
                liked: "true"
            })
        }
    }

    //소식에 등록되어 있는 여러개의 사진 받아와서 FbImageLibrary로 출력
    getPhoto = (photoArr) => {
        if (photoArr === null || photoArr === [] || photoArr == "") {
            return null;
        }
        let result = []
        photoArr.map(photo => result.push(serverUrl + '/photo/download?filename=' + photo))
        return (<FbImageLibrary images={result} />);
    }

    //프로필 사진을 받아오기
    getOnePhoto = (fileName, username) => {
        if (fileName === "" || fileName === null)
            return <Avatar size='large'>{username}</Avatar>
        else
            return <Avatar size='large' src={serverUrl + '/photo/download?filename=' + fileName} />
    }

    //날짜를 형식에 맞춰서 문자열로 리턴
    getDate = (timestamp) => {
        var date = new Date(timestamp);
        return date.getFullYear() + '/' + (date.getMonth()+1) + '/' + date.getDate() + ' ' + date.getHours() + ':' + date.getMinutes();
    }

    //글 삭제
    confirm = (e) => {
        fetch(serverUrl + "/article/" + this.state.articleID + "/" + getUser().userID, {
            method: 'DELETE',
            headers: {
                'token': getToken()
            }
        })
            .then(response => {
                if (response.status === 200) {
                    message.success("소식이 삭제 되었습니다.")
                    this.props.deleteArticle(this.props.article)
                } else {
                    //오류 처리
                }
            })
    }
    
    //글 삭제 안함
    cancel = (e) => {
        console.log(e);
    }

    //소식 삭제 버튼
    deleteButton = (userID, articleUserID) => {
        if (userID === articleUserID) {
            return (
                <Popconfirm
                    title="이 소식을 삭제하시겠습니까?"
                    onConfirm={this.confirm}
                    onCancel={this.cancel}
                    okText="Yes"
                    cancelText="No"
                >
                    <Button type='default' shape='circle' size='small'>X</Button>
                </Popconfirm>
            )
        } else {
            return null
        }
    }

    //이름클릭했을 때 : 소식 모아보기로 이동
    clickName = () => {
        history.push('/home/' + this.state.articleUserID)
    }

    render() {

        return (
            <div id='box'>
                {/* 타이틀 */}
                <div>
                    {/* 사진 */}
                    <div className='inline' >
                        {this.getOnePhoto(this.state.articleUserprofile, this.state.articleUsername)}
                    </div>
                    {/* 제목 */}
                    <div className='inline title marginLeftRight'>
                        <Link to='#' onClick={this.clickName} ><b>{this.state.articleUsername}</b></Link>
                    </div>
                    {/* 삭제표시 */}
                    <div className='inline rightAlign'>
                        {this.deleteButton(getUser().userID, this.state.articleUserID)}
                    </div>
                </div>

                {/* 날짜 */}
                <div className='marginTopBottom date'>
                    {this.getDate(this.state.createdtime)}
                </div>

                {/* 본문 */}
                <div className='marginTopBottom'>
                    <b>{this.state.content}</b>
                </div>

                {/* 사진 */}
                <div>
                    {this.getPhoto(this.state.photo)}
                </div>

                {/* 좋아요 카운트*/}
                <div className='marginTopBottom'>
                    <Icon type="like" theme="twoTone" twoToneColor="#eb2f96" width='200px' />
                    <span className='marginLeftRight'>{this.state.like}</span>
                </div>

                {/* 좋아요 버튼 및 댓글 버튼 */}
                <div className='marginTopBottom'>
                    <Row>
                        <Col span={12}>
                            <center><Button type={this.state.liked === "true" ? "primary" : "default"} icon="like" onClick={this.likeClick}>좋아요</Button></center>
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