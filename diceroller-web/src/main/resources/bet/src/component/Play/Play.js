import React, { Component } from 'react';
import { Layout, Tabs} from 'antd';
import ManualBet from './ManualBet.js';
import RateSlider from './RateSlider.js';
const {Content, Sider } = Layout;
const TabPane = Tabs.TabPane;

class Play extends Component {
    constructor(props) {
        super(props);
        this.state = {
            betNum: '0.00000000',
            rate: '49.50',
            payout: '2.000'
        }
        this.handleChangeBetValue = this.handleChangeBetValue.bind(this);
        this.formatNum = this.formatNum.bind(this);
        this.handleChangeRate = this.handleChangeRate.bind(this);
    }
    handleTabChange = (key) => {
        console.log(key)
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
                betNum: this.formatNum(betNum)
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
                betNum: this.formatNum(betNum)
            })
        }
        
    }
    handleChangeRate(value) {
        this.setState({
            rate: value
        })
    }
    
	render() {
		return (
			<div className="play">
				<Layout style={{width:"910px",margin:"0 auto"}}>
                    <Content style={{marginRight: "10px"}}>
                    <Tabs onChange={this.handleTabChange} type="card">
                        <TabPane tab="手动下注" key="1">
                            <ManualBet {...this.state} onChangeBetValue={this.handleChangeBetValue}/>
                        </TabPane>
                        <TabPane tab="自动下注" key="2">Content of Tab Pane 2</TabPane>                        
                    </Tabs>
                    </Content>
                    <Sider width={230}>right sidebar</Sider>
                </Layout>
                <RateSlider {...this.state} onChangeRate={this.handleChangeRate}/>
			</div>
		);
	}
}

export default Play;
