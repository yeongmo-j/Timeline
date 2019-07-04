import React, { Component } from 'react';
import { Layout } from 'antd';
import Timeline from './Timeline';
import ArticleForm from './ArticleForm';

import './Main.css';

const { Header, Footer, Content } = Layout;

class Main extends Component {

    render() {
        return (
        <div>
            <Layout>
                <Header className='Header'>Timeline</Header>
                <Content>
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