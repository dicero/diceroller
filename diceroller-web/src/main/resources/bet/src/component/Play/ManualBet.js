import React, { Component } from 'react';
import {Input, Button } from 'antd';
import {observer, inject} from "mobx-react";

@inject((allStores) => ({
    bet: allStores.appStore.bet,
    profit: allStores.appStore.profit,
    diceRoll: allStores.appStore.diceRoll,
    payout: allStores.appStore.payout,
    chance: allStores.appStore.chance,
    rollOver: allStores.appStore.rollOver,
    changeBetNumber: allStores.appStore.changeBetNumber,
    changeBetBt: allStores.appStore.changeBetBt,
    changeRollOver: allStores.appStore.changeRollOver,
    changePayout: allStores.appStore.changePayout,
    changeChance: allStores.appStore.changeChance,
    throwBet: allStores.appStore.throwBet,
    words: allStores.appStore.wordsToJs
}))@observer class ManualBet extends Component {
    constructor(props) {
        super(props);
        this.state = {
            payout: props.payout,
            chance: props.chance,
            payoutShow: false,
            rateShow: false
        }
        this.onChangePayout = this.onChangePayout.bind(this);
        this.onChangeChance = this.onChangeChance.bind(this);
        this.resetPayout = this.resetPayout.bind(this);
        this.handlePayoutShow = this.handlePayoutShow.bind(this);
        this.handleChanceShow = this.handleChanceShow.bind(this);
    }
    componentWillMount() {
        
    }
    componentDidMount() {
        
    }

    
    handlePayoutShow(isShow,e) {
        const payout = this.props.payout
        const input = this.refs.payoutInput.refs.input;
        if (!this.state.payoutShow) {
            if (isShow) {
                this.setState({
                    payoutShow: isShow,
                    payout: payout
                },() => {
                    if (isShow) {
                        input.focus();
                        input.select();
                    }
                })
            }
        } else {
            this.setState({
                payoutShow: isShow
            })
        }
        if (Number(payout) <= 9900 && Number(payout) >= 1.01202) {

        } else {
            this.resetPayout();
        }
        e.stopPropagation();
    }
    resetPayout() {
        this.props.changePayout(this.state.payout);
    }
    resetChance() {
        this.props.changeChance(this.state.chance);
    }
    onChangePayout(e) {
        const value = e.target.value;
        if(isNaN(value)) {
            return;
        } else {
            this.props.changePayout(e.target.value);
        }
        e.stopPropagation();
    }
    onChangeChance(e) {
        const value = e.target.value;
        if(isNaN(value)) {
            return;
        } else {
            this.props.changeChance(e.target.value);
        }
        e.stopPropagation();
    }
    handleChanceShow(isShow,e) {
        const chance = this.props.chance
        const input = this.refs.chanceInput.refs.input;
        if (!this.state.chanceShow) {
            if (isShow) {
                this.setState({
                    rateShow: isShow,
                    chance: chance
                },() => {
                    if (isShow) {
                        input.focus();
                        input.select();
                    }
                })
            }
        } else {
            this.setState({
                rateShow: isShow
            })
        }
        if (Number(chance) <= 98 && Number(chance) >= 0.01) {

        } else {
            this.resetPayout();
        }
        e.stopPropagation();
        this.setState({
            rate: this.props.rate,
            rateShow: isShow
        })
        e.stopPropagation();
    }
	render() {
        let {bet, profit, diceRoll, payout, chance, rollOver, words} = this.props;
        const {changeBetNumber,changeBetBt, changeRollOver, throwBet} = this.props;
        const {payoutShow ,rateShow} = this.state;
		return (
			<div className="manualBet">
                <div style={{height:"83px"}}>
                    <div className="fl mr20" style={{width: "340px"}}>
                        <p className="label">{words.play.yzse}</p>
                        <Input size="large" className="betMnoey" value={bet} 
                            onFocus={e => e.target.select()} 
                            onChange={(e) => changeBetNumber(e.target.value)}/>
                        <Button style={{width: "50px"}} type="primary" 
                            onClick={changeBetBt.bind(this,0.5)}
                        >1/2</Button>
                        <Button style={{width: "50px"}} type="primary" 
                            onClick={changeBetBt.bind(this,2)}
                        >2x</Button>
                        <Button style={{width: "50px"}} type="primary" 
                            onClick={changeBetBt.bind(this, 'max')}
                        >{words.play.zd}</Button>
                    </div>
                    <div className="fl profit" style={{width: "248px"}}>
                        <p className="label">{words.play.yl}</p>
                        <span>{profit}</span>
                    </div>
                </div>
                <div className="winRate">
                    <div className="fl rollover" onClick={changeRollOver}>
                        <p>{rollOver? words.play.gc : words.play.fgc}</p>
                        <div>{diceRoll}</div>
                    </div>
                    <div className="fl has-break pr">
                        <p>{words.play.pc}</p>
                        <div onClick={this.handlePayoutShow.bind(this, true)}>
                            {payout}
                            <div className={`changePayout ${payoutShow ? '' : 'no'}`} >
                                <Input type="text" size="large" 
                                value={payout} 
                                onChange={this.onChangePayout} 
                                onBlur={this.handlePayoutShow.bind(this,false)}
                                ref="payoutInput"
                                />
                                <Button type="primary">{words.play.qd}</Button>
                                <Button type="primary" onMouseDown={this.resetPayout.bind(this)}>{words.play.qx}</Button>
                            </div>
                            
                        </div>
                    </div>
                    <div className="fl pr">
                        <p>{words.play.sl}</p>
                        <div onClick={this.handleChanceShow.bind(this, true)}>
                            {chance}
                            <div className={`changeRate ${rateShow ? '' : 'no'}`} >
                                <Input type="text" size="large" 
                                value={chance} 
                                onChange={this.onChangeChance} 
                                onBlur={this.handleChanceShow.bind(this,false)}
                                ref="chanceInput"
                                />
                                <Button type="primary">{words.play.qd}</Button>
                                <Button type="primary" onClick={this.resetChance.bind(this)}>{words.play.qx}</Button>
                            </div>
                        </div>
                    </div>
                </div>
                <button className="throw" onClick={throwBet}>{words.play.ts}</button>
			</div>
		);
	}
}

export default ManualBet;