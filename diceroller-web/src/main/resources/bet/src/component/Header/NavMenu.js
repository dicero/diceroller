import React, { Component } from 'react';
import { Menu, Icon, Row, Col, Input ,Modal ,Button} from 'antd';
import PubSub from 'pubsub-js';
import {observer, inject} from "mobx-react";
import {
    Link
} from 'react-router-dom';
import axios from 'axios';
import Equity from '../dialog/Equity.js';
import BetDetail from '../dialog/BetDetail.js';
import Recharge from '../dialog/Recharge.js';
import Withdrawal from '../dialog/Withdrawal.js';
import Login from '../dialog/Login.js';
const SubMenu = Menu.SubMenu;
const MenuItemGroup = Menu.ItemGroup;

@inject((allStores) => ({
    loginVisible: allStores.appStore.loginVisible,
    balance: allStores.appStore.balanceToJs,
    queryBalance: allStores.appStore.queryBalance
}))@observer class NavMenu extends Component {
    constructor(props) {
        super(props)
        this.state = {
            current: 'play',
            totalMoney: '0.00000090',
            equityVisible: false,
            rechargeVisible: false,
            withdrawalVisible: false,
        }
        this.setEquityVisible = this.setEquityVisible.bind(this);
        this.setRechargeVisible = this.setRechargeVisible.bind(this);
        this.setWithdrawalVisible = this.setWithdrawalVisible.bind(this);
        console.log(this.props.name)
        console.log(PubSub)
    }
    componentDidMount() {
        // window.totalMoney = this.state.totalMoney;
        this.props.queryBalance();
    }
    componentWillUnmount() {}
    handleClick = (e) => {
        console.log('click ', e);
        this.setState({
            current: e.key,
        });
    }
    setEquityVisible(equityVisible) {
        this.setState({ equityVisible });
    }
    setRechargeVisible(rechargeVisible) {
        this.setState({ rechargeVisible });
    }
    setWithdrawalVisible(withdrawalVisible) {
        this.setState({ withdrawalVisible });
    }
    render() {
        const {balance} = this.props;
        return (
            <Row type="flex" justify="space-between">
                <Col span={12}>
                <Menu
                    onClick={this.handleClick}
                    selectedKeys={[this.state.current]}
                    mode="horizontal"
                >
                    <Menu.Item key="play">
                        <Link to='/play'>Diceroller</Link>
                    </Menu.Item>
                    <Menu.Item key="app">
                        <span onClick={() => this.setEquityVisible(true)}>公平性</span>
                        <Equity 
                            setEquityVisible={this.setEquityVisible} 
                            equityVisible={this.state.equityVisible}
                        />
                        <BetDetail/>
                    </Menu.Item>
                    <SubMenu title={<span>帮助</span>}>
                        <Menu.Item key="/faq">FAQ</Menu.Item>
                    </SubMenu>
                    <SubMenu title={<span>更多</span>}>
                        <Menu.Item key="/hall-of-fame">名人堂</Menu.Item>
                        <Menu.Item key="/verify">验证</Menu.Item>
                        <Menu.Item key="/account/affiliate">推荐用户</Menu.Item>
                    </SubMenu>

                </Menu>
                </Col>
                <Col span={12}>
                <span className="totalMoney">{balance}</span>
                <Menu
                    onClick={this.handleClick}
                    selectedKeys={[this.state.current]}
                    mode="horizontal"
                    style={{float: "right"}}
                >
                    {/* <Menu.Item key="alipay">
                    <a href="https://ant.design" target="_blank" rel="noopener noreferrer">Navigation Four - Link</a>
                </Menu.Item> */}
                    <Menu.Item key="充值">
                        <span onClick={() => this.setRechargeVisible(true)}>充值</span>
                        <Recharge
                            setRechargeVisible={this.setRechargeVisible} 
                            rechargeVisible={this.state.rechargeVisible}
                        />
                    </Menu.Item>
                    <Menu.Item key="取款">
                        <span onClick={() => this.setWithdrawalVisible(true)}>取款</span>
                        <Withdrawal
                            setWithdrawalVisible={this.setWithdrawalVisible} 
                            withdrawalVisible={this.state.withdrawalVisible}
                        />
                    </Menu.Item>
                    <Menu.Item key="水龙头">
                        水龙头
                    </Menu.Item>
                    <Menu.Item key="/account">
                        <Link to='/account/settings'><Icon type="user" />账户</Link>
                    </Menu.Item>
                </Menu>
                <Login/>
                </Col>
            </Row>
        );
    }
}
export default NavMenu;