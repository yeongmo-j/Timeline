import React, {Component} from 'react';

import './Box.css';



class Friend extends Component {

    render() {
        return (
            <div id='box' >
                <div><h1>친구추천 컴포넌트</h1></div>
                <div><h1>친구검색 컴포넌트</h1></div>
            </div>
        );
    }
}

export default Friend;