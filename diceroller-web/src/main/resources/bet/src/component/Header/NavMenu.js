import React, { Component } from 'react';
import { Menu, Icon, Row, Col, Input ,Modal ,Button} from 'antd';
import Pubsub from 'pubsub-js';
import {
    Link
} from 'react-router-dom'
import Equity from '../dialog/Equity.js';
const SubMenu = Menu.SubMenu;
const MenuItemGroup = Menu.ItemGroup;

class NavMenu extends Component {
    constructor(props) {
        super(props)
        this.state = {
            current: 'play',
            totalMoney: '0.00000090',
            equityVisible: false
        }
        this.setEquityVisible = this.setEquityVisible.bind(this);
    }
    componentDidMount() {
        window.totalMoney = this.state.totalMoney;
        Pubsub.subscribe('ChangeMoney', function(msg,data){
            
        })
    }
    handleClick = (e) => {
        console.log('click ', e);
        this.setState({
            current: e.key,
        });
    }
    setEquityVisible(equityVisible) {
        this.setState({ equityVisible });
    }
    render() {
        return (
            <Row type="flex" justify="space-between">
                <Col span={12}>
                <Menu
                    onClick={this.handleClick}
                    selectedKeys={[this.state.current]}
                    mode="horizontal"
                >
                    <Menu.Item key="play">
                        <Link to='/play'>Primedice</Link>
                    </Menu.Item>
                    <Menu.Item key="app">
                        <span onClick={() => this.setEquityVisible(true)}>公平性</span>
                        <Equity 
                            setEquityVisible={this.setEquityVisible} 
                            equityVisible={this.state.equityVisible}
                        />
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
                <span className="totalMoney">{this.state.totalMoney}</span>
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
                        充值
                    </Menu.Item>
                    <Menu.Item key="取款">
                        取款
                    </Menu.Item>
                    <Menu.Item key="水龙头">
                        水龙头
                    </Menu.Item>
                    <Menu.Item key="/account">
                        <Icon type="user" />账户
                    </Menu.Item>
                </Menu>
                </Col>
            </Row>
        );
    }
}
export default NavMenu;