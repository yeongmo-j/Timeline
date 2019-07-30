import React, { Component } from 'react';
import {Avatar} from 'antd';

import { getUser, getToken } from '../authentication';
import FriendArray from './FriendArray';

import './FriendUnit.css';

class FriendSuggest extends Component {

    state = {
        suggestList: []
    };

    constructor(props) {
        super(props);

        this.loadingFriendSuggests();
    }

    //친구추천 리스트를 불러옴
    loadingFriendSuggests = () => {
        const requesturl = 'http://localhost:8080/friend/suggest/' + getUser().userID
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
                    console.log('친구추천 불러오기 에러!')
                    return [];
                }
            }).then(response => {
                this.setState({ suggestList: response })
            })
    }

    //삭제한 글 state의 리스트에서 삭제해 주어 다시 렌더링
    deleteArray = (friend) => {
        let lists = this.state.suggestList
        lists.splice(lists.indexOf(friend),1);
        this.setState({suggestList : lists})
    }

    //친구 리스트가 있으면, 리스트를 분배해주는 array 컴포넌트를 리턴
    getArray = () => {
        if (this.state.suggestList== null || this.state.suggestList==[]){
            return (<div className='marginTopBottom grayColor'>친구 추천이 없습니다.</div>);
        } else {
            return (<FriendArray friends={this.state.suggestList} from="suggest" deleteArray={this.deleteArray}/>);
        }
    }

    render() {
        return (
            <div>
                친구 추천
                {this.getArray()}
            </div>
        );
    }
}

export default FriendSuggest;