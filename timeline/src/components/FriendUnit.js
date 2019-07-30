import React, { Component } from 'react';
import { Avatar, Button, message, Popconfirm } from 'antd';
import { Link } from "react-router-dom";

import { getUser, getToken } from '../authentication';
import { serverUrl } from '../setting'

import './FriendUnit.css';

class FriendUnit extends Component {

    //어디서 왔는지 : this.props.from
    state = {
        relationship: 4
    }

    constructor(props) {
        super(props)

        //현재 받은 친구 원소와 나와의 관계가 무엇인지 확인 
        //친구면 1, 친구요청 이미 보낸상태면 2, 친구요청 받은 상태면 3, 아무것도 아니면 4
        const requesturl = serverUrl + '/friend/request/check/' + getUser().userID + '/' + this.props.friend.id
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

    //프로필 사진을 받아오기
    getOnePhoto = (fileName, username) => {
        if (fileName === "" || fileName == null)
            return <Avatar size='large'>{username}</Avatar>
        else
            return <Avatar size='large' src={serverUrl + '/photo/download?filename=' + fileName} />
    }

    //친구 관계에 따라 노출되는 버튼이 다름
    getButton = () => {
        const from = this.props.from;

        if (from === "request") {
            //친구요청 리스트업일 경우
            return (
                <span>
                    <Button type="primary" shape="circle" size="small" onClick={this.acceptRequest}>O</Button>
                    <Button type="danger" shape="circle" size="small" onClick={this.denyRequest}>X</Button>
                </span>
            )
        } else {
            //자기자신일 경우 아무 버튼 노출 안함
            if (getUser().userID === this.props.friend.id) {
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
                //둘이 아무 사이도 아니므로 친구 신청 버튼
                return (
                    <Button type="primary" size="small" onClick={this.sendRequest} ghost>친구신청</Button>
                )
            }
        }
    }

    //친구 관계 끊을 때
    confirm = (e) => {
        console.log(e);
        const requesturl = serverUrl + '/friends/' + this.props.friend.id + '/' + getUser().userID;
        fetch(requesturl, {
            method: 'DELETE',
            headers: {
                'token': getToken()
            }
        })
            .then(response => {
                if (response.status === 200) {
                    message.success('더이상 친구관계가 아닙니다');
                    this.setState({ relationship: 4 });
                } else {
                    console.log('친구 삭제 실패')
                }
            })

    }

    cancel = (e) => {
        console.log(e);
    }

    //친구 요청
    sendRequest = () => {
        fetch(serverUrl + "/friend/request/" + getUser().userID + "/" + this.props.friend.id, {
            method: 'POST',
            headers: {
                'token': getToken()
            }
        })
            .then(response => {
                if (response.status === 200) {
                    message.success("친구 요청을 보냈습니다!")
                    this.setState({ relationship: 2 })
                } else {
                    //오류 처리
                    console.log("error!")
                }
            })

    }

    //친구 신청 받을 때
    acceptRequest = () => {
        fetch(serverUrl + "/friend/request/response/" + 1 + "/" + this.props.friend.id + "/" + getUser().userID, {
            method: 'GET',
            headers: {
                'token': getToken()
            }
        })
            .then(response => {
                if (response.status === 200) {
                    message.success("지금부터 두분은 친구사입니다!")
                    this.deleteUnit();
                } else {
                    //오류 처리
                    console.log("error!")
                }
            })
    }

    //친구 요청 거부
    denyRequest = () => {
        fetch(serverUrl + "/friend/request/response/" + 2 + "/" + this.props.friend.id + "/" + getUser().userID, {
            method: 'GET',
            headers: {
                'token': getToken()
            }
        })
            .then(response => {
                if (response.status === 200) {
                    message.success("친구 신청을 거절 하였습니다.")
                    this.deleteUnit();
                } else {
                    //오류 처리
                    console.log("error!")
                }
            })
    }

    //친구 신청 받거나 거절 후에는 리스트에서 삭제
    deleteUnit = () => {
        this.props.deleteArray(this.props.friend)
    }

    render() {
        const profile = this.props.friend.profile;
        //const email = this.props.friend.email;
        const userID = this.props.friend.id;
        const username = this.props.friend.username;
        const goToHome = '/home/' + userID;

        return (
            <div className="marginTopBottom">
                <span>
                    {this.getOnePhoto(profile, username)}
                    <span className='marginLeftRight'><Link to={goToHome}>{username}</Link></span>
                </span>
                <span className='rightAlign'>
                    {this.getButton()}
                </span>
            </div>
        );
    }
}

export default FriendUnit;