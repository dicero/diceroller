import React, { Component } from 'react';
import {Row, Col, Input, Button } from 'antd';
import Pubsub from 'pubsub-js';
class ManualBet extends Component {
    constructor(props) {
        super(props);
        this.state = {
            payout: props.payout,
            rate: props.rate,
            payoutShow: false,
            rateShow: false

        }
        this.handleChangePayout = this.handleChangePayout.bind(this);
        this.handlePayoutShow = this.handlePayoutShow.bind(this);
        this.handleChangeRate = this.handleChangeRate.bind(this);
        this.handleRateShow = this.handleRateShow.bind(this);
    }
    componentWillMount() {
        
    }
    componentDidMount() {
        
    }
    componentWillReceiveProps(nextProps) {
        if(this.props.payout !== nextProps.payout) {
            this.setState({
                payout: nextProps.payout
            })
        }
    }
    handleChangePayout(e) {
        this.setState({
            payout: e.target.value
        })
        e.stopPropagation();
    }
    handlePayoutShow(isShow,e) {
        this.setState({
            payout: this.props.payout,
            payoutShow: isShow
        })
        e.stopPropagation();
    }
    handleChangeRate(e) {
        this.setState({
            rate: e.target.value
        })
        this.props.onChangeRate(e.target.value)
        e.stopPropagation();
    }
    handleRateShow(isShow,e) {
        this.setState({
            rate: this.props.rate,
            rateShow: isShow
        })
        e.stopPropagation();
    }
	render() {
        const {betNum = 0, rate, payout, profit} = this.props;
        const {onChangeBetValue, onChangePayout, onChangeRate, onChangeBetCount} = this.props;
        const {payoutShow ,rateShow} = this.state;
        const rollover = parseFloat(99.99 - rate).toFixed(2)
		return (
			<div className="manualBet">
                <div style={{height:"83px"}}>
                    <div className="fl mr20" style={{width: "340px"}}>
                        <p className="label">押注数额</p>
                        <Input type="number" size="large" className="betMnoey" value={betNum} onChange={(e) => onChangeBetValue(e)} />
                        <Button style={{width: "50px"}} type="primary" onClick={(e) => onChangeBetValue(e)}>1/2</Button>
                        <Button style={{width: "50px"}} type="primary" onClick={(e) => onChangeBetValue(e)}>2x</Button>
                        <Button style={{width: "50px"}} type="primary" onClick={(e) => onChangeBetValue(e)}>最大</Button>
                    </div>
                    <div className="fl profit" style={{width: "248px"}}>
                        <p className="label">盈利</p>
                        <span>{profit}</span>
                    </div>
                </div>
                <div className="winRate">
                    <div className="fl rollover">
                        <p>滚存</p>
                        <div>{rollover}</div>
                    </div>
                    <div className="fl has-break pr">
                        <p>派彩</p>
                        <div onClick={this.handlePayoutShow.bind(this, true)}>
                            {payout}
                            <div className={`changePayout ${payoutShow ? '' : 'no'}`} >
                                <Input type="number" size="large" value={this.state.payout} onChange={this.handleChangePayout} />
                                <Button type="primary" onClick={(e) => {onChangePayout(this.state.payout);this.handlePayoutShow(false,e)}}>确定</Button>
                                <Button type="primary" onClick={this.handlePayoutShow.bind(this, false)}>取消</Button>
                            </div>
                            
                        </div>
                    </div>
                    <div className="fl pr">
                        <p>胜率</p>
                        <div onClick={this.handleRateShow.bind(this, true)}>
                            {rate}
                            <div className={`changeRate ${rateShow ? '' : 'no'}`} >
                                <Input type="number" size="large" value={this.state.rate} onChange={this.handleChangeRate} />
                                <Button type="primary" onClick={(e) => {onChangeRate(this.state.rate);this.handleRateShow(false,e)}}>确定</Button>
                                <Button type="primary" onClick={this.handleRateShow.bind(this, false)}>取消</Button>
                            </div>
                        </div>
                    </div>
                </div>
                <button className="throw" onClick={onChangeBetCount}>投骰</button>
			</div>
		);
	}
}

export default ManualBet;