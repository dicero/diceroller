import React, { Component } from 'react';
class BetMessages extends Component {
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
    render() {
        const {tab} = this.state;
        return(
            <div className="component-betmessage">
                <div className="tabs">
                    <div className={`tab ${tab===1 ? 'active':''}` } onClick={(e) => this.handleTabChange(1)}>
                        全部
                    </div>
                    <div className={`tab ${tab===2 ? 'active':''}` } onClick={(e) => this.handleTabChange(2)}>
                        当前
                    </div>
                </div>
                <div className={`message ${tab===1 ? '':'no'}`}>
                    <img src="../../../images/reload.svg" />
                    <div className="totalAmount amount">
                        <span className="label">
                            下注总金额
                        </span>
                        <span>
                            0.000023822 BTC
                        </span>
                    </div>
                    <div className="totalProfit amount">
                        <span className="label">
                            全部利润
                        </span>
                        <span>
                            0.00000000 BTC
                        </span>
                    </div>
                    <div className="wrapper">
                        <div className="gameNum">
                            <span className="label">
                                总共获胜局数
                        </span>
                            <span className="green">
                                287
                        </span>
                        </div>
                        <div className="gameNum">
                            <span className="label">
                                全部输掉局数
                        </span>
                            <span className="red">
                                239
                        </span>
                        </div>
                    </div>
                    <div className="wrapper">
                        <div className="totalGame">
                            <span className="label">
                                下注总数
                            </span>
                            <span>
                                526
                            </span>
                        </div>
                        <div className="winRate">
                            <span className="label">
                                胜率
                            </span>
                            <span>
                                124.00%
                            </span>
                        </div>
                    </div>
                </div>
                <div className={`message ${tab===2 ? '':'no'}`}>
                    <img src="../../../images/reload.svg" />
                    <div className="totalAmount amount">
                        <span className="label">
                            下注总金额
                        </span>
                        <span>
                            0.000023822 BTC
                        </span>
                    </div>
                    <div className="totalProfit amount">
                        <span className="label">
                            全部利润
                        </span>
                        <span>
                            0.00000000 BTC
                        </span>
                    </div>
                    <div className="wrapper">
                        <div className="gameNum">
                            <span className="label">
                                总共获胜局数
                        </span>
                            <span className="green">
                                287
                        </span>
                        </div>
                        <div className="gameNum">
                            <span className="label">
                                全部输掉局数
                        </span>
                            <span className="red">
                                239
                        </span>
                        </div>
                    </div>
                    <div className="wrapper">
                        <div className="totalGame">
                            <span className="label">
                                下注总数
                            </span>
                            <span>
                                526
                            </span>
                        </div>
                        <div className="winRate">
                            <span className="label">
                                 机率
                            </span>
                            <span>
                                124.00%
                            </span>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}
export default BetMessages;