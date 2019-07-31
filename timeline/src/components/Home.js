import React, { Component } from 'react';
import { Avatar, Button, message, Popconfirm } from 'antd';

import ArticleArray from './ArticleArray';
import { getUser, getToken } from '../authentication';
import { serverUrl } from '../setting'

import './Box.css';

class Home extends Component {
    state = {
        articles: [],
        user: {},
        relationship: 1
    }

    constructor(props) {
        super(props)

        //누구의 소식 모아보긴지 파라미터를 통해 얻음ㅁ
        const { userID } = this.props.match.params
        this.loadingUser(userID);
        this.loadingArticles(userID)
        this.loadingRelationship(userID);
    }

    shouldComponentUpdate(props) {
        return true
    }

    //현재 페이지 내에서 파라미터만 변경되었을 경우 (소식 모아보기 -> 다른사람 소식 모아보기)
    componentWillReceiveProps(newProps){
        if (this.props.match.params !== newProps.match.params){
            const { userID } = newProps.match.params;
            this.loadingUser(userID);
            this.loadingArticles(userID)
            this.loadingRelationship(userID);    
        }
    }

    //나와의 관계가 무엇인지?
    loadingRelationship = (others) => {
        const requesturl = serverUrl + '/friend/request/check/' + getUser().userID + '/' + others
        fetch(requesturl, {
            method: 'GET',
            headers: {
                'token': getToken()
            }
        })
            .then(response => {
                if (response.status === 200) {
                    return response.json();
                } else {
                    console.log('관계 불러오기 에러!')
                    return [];
                }
            }).then(response => this.setState({ relationship: response }))

    }

    //해당 사람의 프로필 얻어오기
    loadingUser = ( others) => {
        const requesturl = serverUrl + '/user/getinfo/' + others
        fetch(requesturl, {
            method: 'GET',
            headers: {
                'token': getToken()
            }
        })
            .then(response => {
                if (response.status === 200) {
                    return response.json();
                } else {
                    console.log('유저 정보 불러오기 에러!')
                    return [];
                }
            }).then(response => this.setState({ user: response }))
    }

    //해당 사람의 소식 모아보기
    loadingArticles = (others) => {
        const requesturl = serverUrl + '/article/home/' + others + '/' + getUser().userID
        fetch(requesturl, {
            method: 'GET',
            headers: {
                'token': getToken()
            }
        })
            .then(response => {
                if (response.status === 200) {
                    return response.json();
                } else {
                    console.log('소식 불러오기 에러!')
                    return [];
                }
            }).then(response => this.setState({ articles: response }))
    }

    //삭제한 글 state의 리스트에서 삭제해 주어 다시 렌더링
    deleteArticle = (article) => {
        let articles = this.state.articles
        articles.splice(articles.indexOf(article), 1);
        this.setState({ articles: articles })
    }

    //프로필 사진을 받아오기
    getOnePhoto = (fileName, username) => {
        if (fileName === "" || fileName == null)
            return <Avatar size='large'>{username}</Avatar>
        else
            return <Avatar size='large' src={serverUrl + '/photo/download?filename=' + fileName} />
    }

    //그사람과의 관계에 따라 버튼이 달라짐
    getButton = () => {
        const { userID } = this.props.match.params
        if (getUser().userID == userID) {
            return null;
        } else if (this.state.relationship === 1) {
            //이미 친구인 상태
            return (
                <Popconfirm
                    title="정말 친구 관계를 끊으시겠습니까?"
                    onConfirm={this.confirm}
                    onCancel={this.cancel}
                    okText="Yes"
                    cancelText="No"
                >

                    <Button type="danger" size="small" ghost>친구끊기</Button>
                </Popconfirm>
            )
        } else if (this.state.relationship === 2) {
            //이미 친구요청 보낸  상태
            return (
                <Button size="small" disabled>이미신청했음</Button>
            )
        } else if (this.state.relationship === 3) {
            //이미 친구요청 받은 상태
            return (
                <Button size="small" disabled>친구요청받음</Button>
            )
        } else {
            return (
                <Button type="primary" size="small" onClick={this.sendRequest} ghost>친구신청</Button>
            )
        }
    }

    //친구 요청을 보낼 떄
    sendRequest = () => {
        const { userID } = this.props.match.params
        fetch(serverUrl + "/friend/request/"+getUser().userID+"/"+userID, {
            method: 'POST',
            headers: {
                'token': getToken()
            }
        })
            .then(response => {
                if (response.status === 200) {
                    message.success("친구 요청을 보냈습니다!")
                    this.setState({relationship : 2})
                } else {
                    //오류 처리
                    console.log("error!")
                }
            })
    }

    //친구 취소할 때
    confirm = (e) => {
        const { userID } = this.props.match.params;
        const requesturl = serverUrl + '/friends/' + userID + '/' + getUser().userID;
        fetch(requesturl, {
            method: 'DELETE',
            headers: {
                'token': getToken()
            }
        })
            .then(response => {
                if (response.status === 200) {
                    message.success('더이상 친구관계가 아닙니다');
                    this.setState({relationship : 4});
                } else {
                    console.log('친구 삭제')
                    return [];
                }
            })

    }

    cancel = (e) => {

    }

    render() {
        return (
            <div>
                <div id='box'>
                    <span id='margin'>{this.getOnePhoto(this.state.user.profile, this.state.user.username)}</span>
                    <span id='margin'><b>{this.state.user.username}</b> 의 소식 모아보기</span>
                    <span id='margin'>{this.getButton()}</span>
                </div>
                <ArticleArray articles={this.state.articles} deleteArticle={this.deleteArticle} />
            </div>
        );
    }
}

export default Home;