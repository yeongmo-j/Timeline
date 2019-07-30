import React, { Component } from 'react';
import { Button, Avatar } from 'antd';
import { history } from '../History';
import { logout, getUser, getToken } from '../authentication';
import { Link } from "react-router-dom";

import ChangeProfile from './ChangeProfile';
import { serverUrl } from '../setting'

import './Header.css';
import './Box.css';

class Header extends Component {

    state = {
        user: {}
    }

    constructor(props) {
        super(props);
        this.loadingUser();
    }

    //현재 로그인 된 유저의 정보
    loadingUser = () => {
        const userID = getUser().userID
        const requesturl = serverUrl + '/user/getinfo/' + userID
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

    //프로필 사진을 받아오기
    getOnePhoto = (fileName, username) => {
        if (fileName === "" || fileName == null)
            return <Avatar size='large'>{username}</Avatar>
        else
            return <Avatar size='large' src={serverUrl + '/photo/download?filename=' + fileName} />
    }

    //로그아웃
    logOut = () => {
        logout()
        history.push('/login')
    }

    //프로필 : 사진 + 이름으로 구성
    getProfile = () => {
        if (this.state.user === {}) {
            return null;
        } else {
            return (
            <span>
                <span id='margin'>{this.getOnePhoto(this.state.user.profile, this.state.user.username)}</span>
                <span id='margin'>{this.state.user.username}</span>
            </span>);
        }
    }

    render() {
        return (
            <div className='Header'>
                {/* 로고 텍스트 ( 클릭하면 타임라인으로 이동) */}
                <div className="left-box">
                    <b className='logo'><Link to='/main' id='color'>TIMELINE</Link></b>
                </div>

                {/* 로그인 정보 + 프로필 변경 + 로그아웃 버튼 */}
                <div className="right-box">
                    {/* 로그인 정보 */}
                    <b>{this.getProfile()}</b>
                    {/* 프로필 변경 */}
                    <span id='margin'><ChangeProfile /></span>
                    {/* 로그아웃 버튼 */}
                    <span id='margin'><Button type="danger" icon="poweroff" onClick={this.logOut} shape="circle" /></span>
                </div>
                
            </div>
        );
    }
}

export default Header;