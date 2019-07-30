import React, { Component } from 'react';
import ArticleArray from './ArticleArray';
import { getUser, getToken } from '../authentication';
import ArticleForm from './ArticleForm';

import { serverUrl } from '../setting'

class Timeline extends Component {
    state = {
        articles: []
    }

    constructor(props) {
        super(props)
        
        this.loadingArticles()
    }

    shouldComponentUpdate(props) {
        return true
      }
    
    //소식 목록 로딩
    //ArticleArray 컴포넌트에서 하지 않고 timeline에서 하는 이유는 ?
    //form에서 입력받은 소식을 업데이트 해줘야 하므로, 여기서 state를 바꿔주어야 한다. 
    loadingArticles = () => {
        const requesturl = serverUrl + '/article/timeline/' + getUser().userID
        fetch(requesturl, {
            method: 'GET',
            headers: {
                'token': getToken()
            }
        })
            .then(response => {
                if (response.status ===200){
                    return response.json();
                } else {
                    console.log('소식 불러오기 에러!')
                    return [];
                }
            }).then(response => this.setState({articles : response}))
    }

    //새로 입력한 글 소식 리스트의 맨앞에 넣어주어 렌더링
    addArticle = (article) => {
        let articles = this.state.articles
        articles.unshift(article)
        this.setState({articles : articles})
    }

    //삭제한 글 state의 리스트에서 삭제해 주어 다시 렌더링
    deleteArticle = (article) => {
        let articles = this.state.articles
        articles.splice(articles.indexOf(article),1);
        this.setState({articles : articles})
    }

    render() {
        return (
            <div>
                <ArticleForm addArticle={this.addArticle} />
                <ArticleArray articles={this.state.articles} deleteArticle={this.deleteArticle} />
            </div>
        );
    }
}

export default Timeline;