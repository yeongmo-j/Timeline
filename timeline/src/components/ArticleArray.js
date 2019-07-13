import React, { Component } from 'react';
import Article from './Article';

class ArticleArray extends Component {

    constructor(props){
        super(props)
    }

    shouldComponentUpdate(){
        return true;
    }

    deleteArticle = (article) => {
        this.props.deleteArticle(article);
    }

    render() {
        return (
            <div>
                {this.props.articles.map(
                    article => (<Article key={article.articleID} article={article} deleteArticle={this.deleteArticle} />)
                )}
            </div>
        );
    }
}

export default ArticleArray