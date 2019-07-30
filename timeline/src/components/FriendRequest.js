import React, { Component } from 'react';

import { getUser, getToken } from '../authentication';
import FriendArray from './FriendArray';
import { serverUrl } from '../setting'

import './FriendUnit.css';

class FriendRequest extends Component {

    state = {
        requestList: []
    };


    constructor(props) {
        super(props);
        this.loadingFriendRequests();
    }

    //친구 요청들 불러오기
    loadingFriendRequests = () => {
        const requesturl = serverUrl + '/friend/request/' + getUser().userID
        //http요청
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
                    console.log('친구신청 불러오기 에러!')
                    return [];
                }
            }).then(response => {
                this.setState({ requestList: response })
            })
    }

    //삭제한 글 state의 리스트에서 삭제해 주어 다시 렌더링
    deleteArray = (friend) => {
        let lists = this.state.requestList
        lists.splice(lists.indexOf(friend),1);
        this.setState({requestList : lists})
    }

    //친구 리스트가 있으면, 리스트를 분배해주는 array 컴포넌트를 리턴
    getArray = () => {
        if (this.state.requestList=== null || this.state.requestList===[]){
            return (<div className='marginTopBottom grayColor'>친구 요청이 없습니다.</div>);
        } else {
            return (<FriendArray friends={this.state.requestList} from="request" deleteArray={this.deleteArray}/>);
        }
    }

    render() {
        return (
            <div>
                친구 요청
                {this.getArray()}
            </div>
        );
    }
}

export default FriendRequest;