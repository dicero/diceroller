import React, { Component } from 'react';
import {observer, inject} from "mobx-react";

@inject((allStores) => ({
    stakeCollect: allStores.appStore.stakeCollectToJs,
    words: allStores.appStore.wordsToJs
}))@observer class BetMessages extends Component {
    constructor(props) {
        super(props)
        this.state = {
            tab: 1
        }
        this.handleTabChange = this.handleTabChange.bind(this);
    }
    handleTabChange(value) {
        this.setState({
            tab: value
        })
        
    }
    componentDidMount() {
        
    }
    render() {
        const {words} = this.props;
        const {tab} = this.state;
        const {historyCollect,todayCollect} = this.props.stakeCollect
        return(
            <div className="component-betmessage">
                <div className="tabs">
                    <div className={`tab ${tab===1 ? 'active':''}` } onClick={(e) => this.handleTabChange(1)}>
                        {words.betMessage.qb}
                    </div>
                    <div className={`tab ${tab===2 ? 'active':''}` } onClick={(e) => this.handleTabChange(2)}>
                        {words.betMessage.dq}
                    </div>
                </div>
                <div className={`message ${tab===1 ? '':'no'}`}>
                    {/* <img src="../../../images/reload.svg" alt=''/> */}
                    <div className="totalAmount amount">
                        <span className="label">
                            {words.betMessage.xzzje}
                        </span>
                        <span>
                        {historyCollect.allStakeAmt} ETH
                        </span>
                    </div>
                    <div className="totalProfit amount">
                        <span className="label">
                            {words.betMessage.qblr}
                        </span>
                        <span>
                        {historyCollect.allWinAmt} ETH
                        </span>
                    </div>
                    <div className="wrapper">
                        <div className="gameNum">
                            <span className="label">
                            {words.betMessage.zghsjs}
                        </span>
                            <span className="green">
                            {historyCollect.allWinGames}
                        </span>
                        </div>
                        <div className="gameNum">
                            <span className="label">
                            {words.betMessage.qbsdjs}
                        </span>
                            <span className="red">
                            {historyCollect.allLoseGames}
                        </span>
                        </div>
                    </div>
                    <div className="wrapper">
                        <div className="totalGame">
                            <span className="label">
                            {words.betMessage.xzzs}
                            </span>
                            <span>
                            {historyCollect.allLoseGames + historyCollect.allWinGames}
                            </span>
                        </div>
                        <div className="winRate">
                            <span className="label">
                            {words.betMessage.sl}
                            </span>
                            <span>
                                {historyCollect.winningPos}%
                            </span>
                        </div>
                    </div>
                </div>
                <div className={`message ${tab===2 ? '':'no'}`}>
                    {/* <img src="../../../images/reload.svg" alt=''/> */}
                    <div className="totalAmount amount">
                        <span className="label">
                        {words.betMessage.xzzje}
                        </span>
                        <span>
                            {todayCollect.allStakeAmt} ETH
                        </span>
                    </div>
                    <div className="totalProfit amount">
                        <span className="label">
                        {words.betMessage.qblr}
                        </span>
                        <span>
                        {todayCollect.allWinAmt} ETH
                        </span>
                    </div>
                    <div className="wrapper">
                        <div className="gameNum">
                            <span className="label">
                            {words.betMessage.zghsjs}
                        </span>
                            <span className="green">
                            {todayCollect.allWinGames}
                        </span>
                        </div>
                        <div className="gameNum">
                            <span className="label">
                            {words.betMessage.qbsdjs}
                        </span>
                            <span className="red">
                            {todayCollect.allLoseGames}
                        </span>
                        </div>
                    </div>
                    <div className="wrapper">
                        <div className="totalGame">
                            <span className="label">
                            {words.betMessage.xzzs}
                            </span>
                            <span>
                            {todayCollect.allLoseGames + todayCollect.allWinGames}
                            </span>
                        </div>
                        <div className="winRate">
                            <span className="label">
                            {words.betMessage.jl}
                            </span>
                            <span>
                                {todayCollect.winningPos}%
                            </span>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}
export default BetMessages;