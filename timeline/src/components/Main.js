import React, { Component } from 'react';
import { Layout, Button } from 'antd';
import Timeline from './Timeline';
import ArticleForm from './ArticleForm';
import { logout, getUser } from '../authentication';
import { history } from '../History';

import './Main.css';

const { Header, Footer, Content } = Layout;

class Main extends Component {

    logOut = () => {
        logout()
        history.push('/login')
    }

    render() {
        return (
        <div>
            <Layout>
                <Header className='Header'>Timeline
                </Header>
                <Content>
                    <Button type="danger" onClick={this.logOut} >Danger</Button>
                    <ArticleForm/>
                    <Timeline/>
                </Content>
                <Footer>Footer</Footer>
            </Layout>
        </div>
        );
    }
}

export default Main;