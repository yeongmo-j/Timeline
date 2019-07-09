import React, { Component } from 'react';
import ArticleArray from './ArticleArray';
import { getUser, getToken } from '../authentication';
import ArticleForm from './ArticleForm';

import './Timeline.css';


class Timeline extends Component {

    state = {
        articles: []
    }

    // 유저아이디
    userID = getUser().userID

    constructor(props) {
        super(props)
        this.loadingArticles()
    }

    shouldComponentUpdate(props) {
        return true
      }
    

    loadingArticles = () => {
        const requesturl = 'http://localhost:8080/article/getarticles?userID=' + this.userID
        fetch(requesturl, {
            method: 'GET',
            headers: {
                'token': getToken()
            }
        })
            .then(response => response.json())
            .then(response => {
                console.log(response)
                this.setState({ articles: response })
            })
    }

    comp

    render() {
        return (
            <div>
                <ArticleForm callBack={this.loadingArticles} />
                <ArticleArray articles={this.state.articles} />
            </div>
        );
    }
}

export default Timeline;