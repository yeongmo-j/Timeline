import React, { Component } from 'react';
import { getToken } from '../authentication';
import { Avatar } from 'antd';
import FbImageLibrary from 'react-fb-image-grid'


import './Article.css';

class Article extends Component {

    state = {
        photo : []
    }

    imageSourceUrl = 'http://localhost:8080/photo/download?filename=';

    getPhoto = (photoArr) => {
        if (photoArr == null ||photoArr == []){
            return null;
        }
        let result =[]
        photoArr.map(photo => result.push('http://localhost:8080/photo/download?filename='+photo))
        return (<FbImageLibrary images={result}/>);
    }

    getOnePhoto = (fileName, username) => {
        if (fileName==="" || fileName == null)
            return <Avatar size='large'>{username}</Avatar>
        else
            return <Avatar size='large' src={this.imageSourceUrl+fileName} />
    }

    render() {
        const userID = this.props.article.userID;
        const username = this.props.article.username;
        const profile = this.props.article.profile;
        const articleID = this.props.article.articleID
        const content = this.props.article.content
        const like = this.props.article.like
        const liked = this.props.article.liked
        const createdtime = 'this.props.article.createdtime 시간처리 해줄 것'


        return (
        <div className="article" id='box'>
            <div>
                <span >
                    {this.getOnePhoto(profile,username)}
                </span>
                <div className='inline'>
                    <div className='titlAndDate' id='title'>
                        <b>{username}</b>
                    </div>
                    <div className='titlAndDate' id='date'>
                        업로드시간 : 시간처리 해줄 것
                    </div>
                </div>
            </div>
            <div className='margin'>
                {content}
            </div>
            <div>
                {this.getPhoto(this.props.article.photo)}
            </div>
            <div>
                좋아요 : {this.props.article.like} <br/>
                좋아요했음 : {this.props.article.liked}
            </div>
            <br/>
        </div>
        );
    }
}

export default Article;