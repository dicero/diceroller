import React, { Component } from 'react';
import {Input, Button } from 'antd';
class AutoBet extends Component {
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
        const {betNum = 0, rate, payout, loseScale, winScale, loseSwitch, winSwitch, betTimes} = this.props;
        const {onChangeBetValue, onChangePayout, onChangeRate, onChangeBetCount, onChangeWinSwitch, onChangeLoseSwitch, onChangeLoseScale, onChangeWinScale, onChangeBetTimes} = this.props;
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
                    <div className="fl betTime pr" style={{width: "248px"}}>
                        <p className="label">投掷次数</p>
                        <Input type="number" size="large" className="betMnoey" value={betTimes} onChange={(e) => onChangeBetTimes(e.target.value)} />
                        {parseInt(betTimes) ? null : <span>（没有限制）</span>}
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
                <div className="changeBet">
                    <div className="fl" style={{width: "50%"}}>
                        <p className="label">压输</p>
                        <Button className={`${loseSwitch ? 'off' : ''}`} type="primary" onClick={(e) => onChangeLoseSwitch(false)}>重置清零</Button>
                        <Button className={`${loseSwitch ? '' : 'off'}`} type="primary" onClick={(e) => onChangeLoseSwitch(true)}>增加</Button>
                        <Input disabled={loseSwitch ? false : true} type="number" size="large"value={loseScale} onChange={(e) => onChangeLoseScale(e.target.value)} />
                    </div>
                    <div className="fl" style={{width: "50%"}}>
                        <p className="label">压赢</p>
                        <Button className={`${winSwitch ? 'off' : ''}`} onClick={(e) => onChangeWinSwitch(false)} type="primary">重置清零</Button>
                        <Button className={`${winSwitch ? '' : 'off'}`} onClick={(e) => onChangeWinSwitch(true)} type="primary">增加</Button>
                        <Input disabled={winSwitch ? false : true} type="number" size="large"value={winScale} onChange={(e) => onChangeWinScale(e.target.value)}/>
                    </div>
                </div>
                <button className="throw" onClick={onChangeBetCount}>自动投骰</button>
			</div>
		);
	}
}

export default AutoBet;