import React, { Component } from 'react';
import { Menu, Icon, Row, Col, Select} from 'antd';
import {observer, inject} from "mobx-react";
import {
    Link
} from 'react-router-dom';
import Equity from '../dialog/Equity.js';
import BetDetail from '../dialog/BetDetail.js';
import Recharge from '../dialog/Recharge.js';
import Withdrawal from '../dialog/Withdrawal.js';
import Register from '../dialog/Register.js';
const SubMenu = Menu.SubMenu;
const Option = Select.Option;

@inject((allStores) => ({
    registerVisible: allStores.appStore.registerVisible,
    balance: allStores.appStore.balanceToJs,
    queryBalance: allStores.appStore.queryBalance,
    showAmt: allStores.appStore.showAmt,
    changeAmt: allStores.appStore.changeAmt,
    showAnim: allStores.appStore.showAnim,
    fundType: allStores.appStore.fundType,
    words: allStores.appStore.wordsToJs,
    setLanguageCf: allStores.appStore.setLanguageCf,
    equityVisible: allStores.dialogStore.equityVisible,
    setEquityVisible: allStores.dialogStore.setEquityVisible,
    ethGasLimit: allStores.appStore.ethGasLimit,
    ethGasPrice: allStores.appStore.ethGasPrice
}))@observer class NavMenu extends Component {
    constructor(props) {
        super(props)
        this.state = {
            current: 'play',
            totalMoney: '0.00000090',
            //equityVisible: false,
            rechargeVisible: false,
            withdrawalVisible: false,
        }
        //this.setEquityVisible = this.setEquityVisible.bind(this);
        this.setRechargeVisible = this.setRechargeVisible.bind(this);
        this.setWithdrawalVisible = this.setWithdrawalVisible.bind(this);
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
    // setEquityVisible(equityVisible) {
    //     this.setState({ equityVisible });
    // }
    setRechargeVisible(rechargeVisible) {
        this.setState({ rechargeVisible });
    }
    setWithdrawalVisible(withdrawalVisible) {
        this.setState({ withdrawalVisible });
    }
    render() {
        const {balance, showAnim, fundType, words, setLanguageCf, equityVisible, setEquityVisible, ethGasLimit, ethGasPrice} = this.props;
        let changeAmtSy;
        if(showAnim) {
            
            changeAmtSy = {
                top: '0px'
            }
        } else {
            changeAmtSy = {
                top: '-33px'
            }
        }
        if (fundType) {
            changeAmtSy.color= '#ddffa2';
        } else {
            changeAmtSy.color= '#ff7591';
        }
        return (
            <Row type="flex" justify="space-between">
                <Col span={7}>
                <Menu
                    onClick={this.handleClick}
                    selectedKeys={[this.state.current]}
                    mode="horizontal"
                >
                    <Menu.Item key="play">
                        <Link to='/play' style={{fontFamily: "serif",fontSize: "24px"}}>Diceroller</Link>
                    </Menu.Item>
                    <Menu.Item key="app">
                        <span onClick={() => setEquityVisible(true)}>{words.nav.gpx}</span>
                        { equityVisible && <Equity 
                            setEquityVisible={setEquityVisible} 
                            equityVisible={equityVisible}
                        /> }
                        <BetDetail/>
                    </Menu.Item>
                    {/* <SubMenu title={<span>{words.nav.bz}</span>}>
                        <Menu.Item key="/faq">FAQ</Menu.Item>
                    </SubMenu> */}
                    <SubMenu title={<span>{words.nav.gd}</span>}>
                        <Menu.Item key="/verify"><Link to='/verify'>{words.nav.gpxyz}</Link></Menu.Item>
                        <Menu.Item key="/contract"><Link to='/contract'>{words.nav.znhy}</Link></Menu.Item>
                        <Menu.Item key="/faq">FAQ</Menu.Item>
                    </SubMenu>

                </Menu>
                </Col>
                <Col span={17}>
                <span style={{position:'relative'}}>
                    <span className="totalMoney">{balance} ETH</span>
                    <span className={this.props.showAmt ? "changeAmt" : "changeAmt no"}
                    style={changeAmtSy}
                    >{this.props.changeAmt} ETH</span>
                </span>
                <span style={{position:'relative'}}>
                    <span className="totalMoney">GasLimit {ethGasLimit} W,GasPrice {ethGasPrice} W</span>
                </span>
                
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
                        <span onClick={() => this.setRechargeVisible(true)}>{words.nav.cz}</span>
                        <Recharge
                            setRechargeVisible={this.setRechargeVisible} 
                            rechargeVisible={this.state.rechargeVisible}
                        />
                    </Menu.Item>
                    <Menu.Item key="取款">
                        <span onClick={() => this.setWithdrawalVisible(true)}>{words.nav.qk}</span>
                        <Withdrawal
                            setWithdrawalVisible={this.setWithdrawalVisible} 
                            withdrawalVisible={this.state.withdrawalVisible}
                        />
                    </Menu.Item>
                    <Menu.Item key="语言">
                        <Select defaultValue="ZH"onChange={setLanguageCf}>
                            <Option value="ZH">ZH</Option>
                            <Option value="EN">EN</Option>
                            <Option value="RU">RU</Option>
                            <Option value="JP">JP</Option>
                        </Select>
                    </Menu.Item>
                    <Menu.Item key="/account">
                        <Link to='/account/settings'><Icon type="user" />{words.nav.zh}</Link>
                    </Menu.Item>
                </Menu>
                <Register/>
                </Col>
            </Row>
        );
    }
}
export default NavMenu;