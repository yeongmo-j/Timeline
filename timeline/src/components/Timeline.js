import React, { Component } from 'react';
import Article from './Article';
import { getUser }from '../authentication';

import './Timeline.css';


class Timeline extends Component {

    state = {
        articles : []
    }

    // 유저아이디
    userID = getUser().userID


    componentWillMount(){
        const requesturl = 'http://localhost:8080/article/getarticles?userID='+this.userID
        fetch(requesturl)
        .then(response => response.json())
        .then(response => {
            console.log(response)
            this.setState({articles : response})
        })
        /*
        this.setState({articles : [{
                "userID" : 2,
                "username" : "user 2",
                "userProfile" : "profile2",
                "articleID" : 2,
                "content" : "temporaryContent 1",
                "photo" : [
                    "photo1", "photo2", "photo3"
                ],
                "like" : 4,
                "liked" : "true"
            }, {
                "userID" : 3,
                "username" : "user 3",
                "userProfile" : "profile3",
                "articleID" : 3,
                "content" : "temporaryContent 2",
                "photo" : [
                    "photo1"
                ],
                "like" : 4,
                "liked" : "false"
            }, {
                "userID" : 4,
                "username" : "user 4",
                "userProfile" : "profile4",
                "articleID" : 4,
                "content" : "temporaryContent 3",
                "photo" : [
                    "photo1"
                ],
                "like" : 3,
                "liked" : "false"
            }
        ]
        })*/
    }

    render() {
        const articles = this.state.articles.map( (article,i)=> {
            return (
            <div>
                <Article article={article} key={i}/>
            </div>
            );
        })

        return (
        <div>
            {articles}
        </div>
        );
    }
}

export default Timeline;