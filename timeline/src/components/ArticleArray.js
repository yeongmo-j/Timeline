import React, { Component } from 'react';
import Article from './Article';

class ArticleArray extends Component {

    shouldComponentUpdate(){
        return true;
    }

    //글 삭제 되었을 때 배열에서 삭제 해 줌
    deleteArticle = (article) => {
        this.props.deleteArticle(article);
    }

    render() {

        //배열을 받아 각자 뿌려줌
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