import React, { Component } from 'react';
import { Input } from 'antd';

import { getUser, getToken } from '../authentication';
import FriendArray from './FriendArray';

import './FriendUnit.css';

const { Search } = Input;

class FriendSearch extends Component {

    state = {
        searchList: []
    };

    constructor(props) {
        super(props);

    }

    //삭제한 글 state의 리스트에서 삭제해 주어 다시 렌더링
    deleteArray = (friend) => {
        let lists = this.state.searchList
        lists.splice(lists.indexOf(friend),1);
        this.setState({searchList : lists})
    }

    //검색 폼
    searchForm = () => {
        return (
            <Search placeholder="찾고 싶은 친구 이름" onSearch={value => {
                //검색 버튼을 눌렀을 경우 결과를 찾아옴
                if (value!=""){
                    const requesturl = 'http://localhost:8080/friend/search/' + value
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
                                console.log('친구검색 에러!')
                                return [];
                            }
                        }).then(response => {
                            this.setState({ searchList: response })
                        })    
                }
            }
            } enterButton />
        )
    }

    //친구 리스트가 있으면, 리스트를 분배해주는 array 컴포넌트를 리턴
    getArray = () => {
        if (this.state.searchList== null || this.state.searchList==[]){
            return (<div className='marginTopBottom grayColor'>검색 결과가 없습니다</div>);
        } else {
            return (<FriendArray friends={this.state.searchList} from="search" deleteArray={this.deleteArray}/>);
        }
    }

    render() {
        return (
            <div>
                친구 검색
                <div className='marginTopBottom'>
                    {this.searchForm()}
                </div>
                {this.getArray()}
            </div>
        );
    }
}

export default FriendSearch;