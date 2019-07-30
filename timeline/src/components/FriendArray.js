import React, { Component } from 'react';

import FriendUnit from './FriendUnit';

class FriendArray extends Component {

    constructor(props){
        super(props)
    }

    shouldComponentUpdate(){
        return true;
    }

    //친구 리스트 중 하나의 원소를 삭제하고 싶을 때, 부모 컴포넌트의 삭제하는 함수를 호출
    deleteArray = (friend) => {
        this.props.deleteArray(friend);
    }

    //props로 받은 리스트를 각각의 원소로 나눠서 분배해줌
    render() {
        return (
            <div>
                {this.props.friends.map(
                    friend => (<FriendUnit key={friend.id} friend={friend} deleteArray={this.deleteArray} from={this.props.from} />)
                )}
            </div>
        );
    }
}

export default FriendArray