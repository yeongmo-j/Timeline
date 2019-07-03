import React, { Component } from 'react';
import { Layout } from 'antd';

import './Timeline.css';

const { Header, Footer, Content } = Layout;

class Timeline extends Component {

    render() {
        return (
        <div>
            <Layout>
                <Header className='Header'>Timeline</Header>
                <Content>Content</Content>
                <Footer>Footer</Footer>
            </Layout>
        </div>
        );
    }
}

export default Timeline;