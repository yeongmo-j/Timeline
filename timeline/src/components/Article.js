import React, { Component } from 'react';
import { getToken } from '../authentication';

class Article extends Component {

    state = {
        photo : []
    }



    componentDidMount(props){
        /*
        let photos = []
        this.props.article.photo.map( photo =>{
            fetch('http://localhost:8080/photo/download?filename='+photo, {
                method: 'GET',
                headers: {
                    'token': getToken()
                }
            })
            .then(response => {
                console.log(response)
                photos.push(response)
            })
        })
        */
    }

    getPhoto = (photoArr) => {
        let result =[]
        photoArr.map(photo => {
            let imgSrc = 'http://localhost:8080/photo/download?filename='+photo
            result.push(<img src={imgSrc} width="300px"/>)
        })
        return result
    }

    render() {
        return (
        <div>
            유저ID : {this.props.article.userID} <br/>
            유저 : {this.props.article.username} <br/>
            유저프로필사진 : {this.props.article.profile} <br/>
            글ID : {this.props.article.articleID} <br/>
            내용 : {this.props.article.content} <br/>
            사진 :  {this.getPhoto(this.props.article.photo)} <br/>
            좋아요 : {this.props.article.like} <br/>
            좋아요했음 : {this.props.article.liked} <br/>
            업로드시간 :  this.props.article.createdtime 시간처리 해줄 것
            <br/>
            <br/>
        </div>
        );
    }
}

export default Article;