import React, { Component } from 'react';
import ArticleArray from './ArticleArray';
import { getUser, getToken } from '../authentication';


class Home extends Component {
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
    
    loadingArticles = () => {
        const { userID } = this.props.match.params
        const requesturl = 'http://localhost:8080/article/home/' + userID
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

    //삭제한 글 state의 리스트에서 삭제해 주어 다시 렌더링
    deleteArticle = (article) => {
        let articles = this.state.articles
        articles.splice(articles.indexOf(article),1);
        this.setState({articles : articles})
    }

    render() {
        return (
            <div>
                <ArticleArray articles={this.state.articles} deleteArticle={this.deleteArticle} />
            </div>
        );
    }
}

export default Home;