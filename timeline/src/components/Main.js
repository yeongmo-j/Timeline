import React, { Component } from 'react';
import { Layout, Button, Row, Col } from 'antd';
import Timeline from './Timeline';
import { logout, getUser } from '../authentication';
import { history } from '../History';
import PrimarySearchAppBar from './Appbar';
import Home from './Home';
import { Route, Switch } from "react-router-dom";
import ChangeProfile from './ChangeProfile';
import Friend from './Friend';


import './Main.css';

const { Header, Footer, Content } = Layout;

class Main extends Component {

    logOut = () => {
        logout()
        history.push('/login')
    }

    goMain = () => {
        history.push('/main')
    }

    render() {
        return (
            <div>
                <Layout>
                    <PrimarySearchAppBar/>
                    <Content className='MarginTop'>
                        <Button type="danger" onClick={this.logOut} >로그아웃</Button>
                        <Button type="primary" onClick={this.goMain} >Main</Button>
                        <ChangeProfile />
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
                    </Content>
                    <Footer>Footer</Footer>
                </Layout>
            </div>
        );
    }
}

export default Main;