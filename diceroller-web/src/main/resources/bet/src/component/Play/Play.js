import React, { Component } from 'react';
import './Play.less';
import { Layout, Tabs} from 'antd';
import ManualBet from './ManualBet.js';
import AutoBet from './AutoBet.js';
import BetMessages from './BetMessages.js';
import RateSlider from './RateSlider.js';
import BetLists from './BetLists.js';
import {observer, inject} from "mobx-react";
const {Content, Sider } = Layout;
const TabPane = Tabs.TabPane;

@inject((allStores) => ({
    words: allStores.appStore.wordsToJs
}))@observer class Play extends Component {
    constructor(props) {
        super(props);
        this.state = {
            betNum: '0.00000000', //投掷金额
            rate: '49.50', // 胜率
            payout: '2.000', // 派彩
            profit: '0.00000000', // 盈利
            betCount: '70', // 点数
            loseScale: '0', // 压输
            winScale: '0', // 压赢
            loseSwitch: false, // 压输开关
            winSwith: false, // 压赢开关
            betTimes: 0 // 投掷次数
        }
        this.handleChangeBetValue = this.handleChangeBetValue.bind(this);
        this.formatNum = this.formatNum.bind(this);
        this.handleChangeRate = this.handleChangeRate.bind(this);
        this.handleChangePayout = this.handleChangePayout.bind(this);
        this.handleChangeBetCount = this.handleChangeBetCount.bind(this);
        this.handleLoseScale = this.handleLoseScale.bind(this);
        this.handleWinScale = this.handleWinScale.bind(this);
        this.handleLoseSwitch = this.handleLoseSwitch.bind(this);
        this.handleWinSwitch = this.handleWinSwitch.bind(this);
        this.handleChangeBetTimes = this.handleChangeBetTimes.bind(this);
    }
    formatNum(num) {
        return parseFloat(num).toFixed(8).toString();
    }
    handleChangeBetValue(e) {
        if (e.type === 'change') {
            let value = e.target.value;
            let betNum = null;
            if (value > window.totalMoney) {
                betNum = window.totalMoney;
            } else {
                betNum = value;
            }
            this.setState({
                betNum: this.formatNum(betNum),
                profit: this.formatNum(betNum)
            })
        } else if(e.type === 'click'){
            let operate = e.target.textContent;
            let betNum = null;
            if (operate === '1/2') {
                betNum = this.state.betNum / 2;
            } else if (operate === '2x') {
                betNum = this.state.betNum * 2;
            } else if (operate === '最 大') {
                betNum = window.totalMoney;
            } else {}
            this.setState({
                betNum: this.formatNum(betNum),
                profit: this.formatNum(betNum)
            })
        }
        
    }
    handleChangeRate(value) {
        this.setState({
            rate: value
        })
    }
    handleChangePayout(value) {
        this.setState({
            payout: value
        })
    }
    handleChangeBetCount() {
        this.setState({
            betCount: Math.random() * 100
        })
    }
    handleLoseSwitch(value) {
        this.setState({
            loseSwitch: value
        })
    }
    handleLoseScale(value) {
        this.setState({
            loseScale: value
        })
    }
    handleWinSwitch(value) {
        this.setState({
            winSwitch: value
        })
    }
    handleWinScale(value) {
        this.setState({
            winScale: value
        })
    }
    handleChangeBetTimes(value) {
        this.setState({
            betTimes: value
        })
    }    componentDidMount() {
        
    }
	render() {
        const {words} = this.props;
		return (
			<div className="play">
				<Layout style={{width:"910px",margin:"0 auto"}}>
                    <Content style={{marginRight: "10px"}}>
                    <Tabs type="card">
                        <TabPane tab={words.play.sdxz} key="1">
                            <ManualBet />
                        </TabPane>
                        <TabPane tab={words.play.zdxz} key="2">
                            <AutoBet
                                {...this.state} 
                                onChangeBetValue={this.handleChangeBetValue} 
                                onChangePayout={this.handleChangePayout} 
                                onChangeRate={this.handleChangeRate}
                                onChangeBetCount={this.handleChangeBetCount}
                                onChangeWinScale={this.handleWinScale}
                                onChangeLoseScale={this.handleLoseScale}
                                onChangeWinSwitch={this.handleWinSwitch}
                                onChangeLoseSwitch={this.handleLoseSwitch}
                                onChangeBetTimes = {this.handleChangeBetTimes}
                            />    
                        </TabPane>                        
                    </Tabs>
                    </Content>
                    <Sider width={230}>
                        <BetMessages/>
                    </Sider>
                </Layout>
                <RateSlider {...this.state} onChangeRate={this.handleChangeRate}/>
                <BetLists/>
			</div>
		);
	}
}

export default Play;
