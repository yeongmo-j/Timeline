import React, {Component} from 'react';

import FriendRequest from './FriendRequest';
import FriendSuggest from './FriendSuggest';
import FriendSearch from './FriendSerch';

import './Box.css';

//친구요청, 친구추천, 친구검색
class Friend extends Component {

    render() {
        return (
            <div>
                <div id='box' >
                    <FriendRequest />
                </div>
                <div id='box' >
                    <FriendSuggest />
                </div>
                <div id='box' >
                    <FriendSearch />
                </div>
            </div>
        );
    }
}

export default Friend;