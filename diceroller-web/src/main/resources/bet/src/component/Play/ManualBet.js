import React, { Component } from 'react';
import {Row, Col, Input, Button } from 'antd';
import Pubsub from 'pubsub-js';
class ManualBet extends Component {
    constructor(props) {
        super(props);
    }
    componentWillMount() {
        
    }
    componentDidMount() {
        
    }
    
	render() {
        const {betNum = 0, rate, payout} = this.props;
        const {onChangeBetValue} = this.props;
        const rollover = 99.99 - rate;
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
                        <span >0.0000000</span>
                    </div>
                </div>
                <div className="winRate">
                    <div className="fl rollover">
                        <p>滚存</p>
                        <div>{rollover}</div>
                    </div>
                    <div className="fl has-break">
                        <p>派彩</p>
                        <div>{payout}</div>
                    </div>
                    <div className="fl">
                        <p>胜率</p>
                        <div>{rate}</div>
                    </div>
                </div>
                <button className="throw">投骰</button>
			</div>
		);
	}
}

export default ManualBet;