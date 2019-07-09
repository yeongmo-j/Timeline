import React, { Component } from 'react';
import Article from './Article';

class ArticleArray extends Component {

    constructor(props){
        super(props)
    }

    shouldComponentUpdate(){
        return true;
    }

    render() {
        return (
            <div>
                {this.props.articles.map((article, i) => {
                    return (
                        <div>
                            <Article article={article} key={i} />
                        </div>
                    );
                })}
            </div>
        );
    }
}

export default ArticleArray