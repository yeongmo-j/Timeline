import React, { Component } from 'react';
import { Layout, Row, Col } from 'antd';
import { Route, Switch } from "react-router-dom";

import Friend from './Friend';
import Timeline from './Timeline';
import Header from './Header';
import Home from './Home';

import './Main.css';

const { Footer, Content } = Layout;

class Main extends Component {

    render() {
        return (
            <div>
                <Layout>
                    <Header/>
                    <Content >
                        <div className='MarginTop'>
                        <Row>
                            <Col span={2}></Col>
                            <Col span={12}>
                                <Switch>
                                    <Route path='/main' exact component={Timeline} />
                                    <Route path='/home/:userID' exact component={Home} />
                                </Switch>
                            </Col>
                            <Col span={1}></Col>
                            <Col span={7}><Friend /></Col>
                            <Col span={2}></Col>
                        </Row>
                        </div>
                    </Content>
                    <Footer>Footer</Footer>
                </Layout>
            </div>
        );
    }
}

export default Main;