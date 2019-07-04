import React, { Component } from 'react';

class Article extends Component {

    componentDidMount(props){
    }

    getPhoto = (photoArr) => {
        let result = ""
        photoArr.map((photo, i) => {
            result += photo+" "; 
        } )
        return result;
    }

    render() {
        return (
        <div>
            유저ID : {this.props.article.userID} <br/>
            유저 : {this.props.article.userID} <br/>
            유저프로필사진 : {this.props.article.userProfile} <br/>
            글ID : {this.props.article.articleID} <br/>
            내용 : {this.props.article.content} <br/>
            사진 :  {this.getPhoto(this.props.article.photo)} <br/>
            좋아요 : {this.props.article.like} <br/>
            좋아요했음 : {this.props.article.liked} <br/>
            <br/>
            <br/>
        </div>
        );
    }
}

export default Article;