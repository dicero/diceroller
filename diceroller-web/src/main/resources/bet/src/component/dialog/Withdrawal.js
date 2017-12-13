import React, { Component } from 'react';
import {Modal} from 'antd';
import './Withdrawal.less';
import {observer, inject} from "mobx-react";

@inject((allStores) => ({
    withDrawal: allStores.dialogStore.withDrawal
}))@observer class Withdrawal extends Component {
    constructor(props) {
        super(props);
        this.state = {
            address: '',
            amt: ''
        };
    }
    handleOk = (e) => {
      console.log(e);
      this.props.setWithdrawalVisible(false)
    }
    handleCancel = (e) => {
      console.log(e);
      this.props.setWithdrawalVisible(false)
    }
    onChangeAddress = (e) => {
        this.setState({ address: e.target.value });
    }
    onChangeSum = (e) => {
        if(isNaN(e.target.value)) {
            return;
        }
        this.setState({ amt: e.target.value });
    }
    render() {
        const {address, amt} = this.state;
        return(
            <Modal
            title="取款"
            visible={this.props.withdrawalVisible}
            onOk={this.handleOk}
            onCancel={this.handleCancel}
            footer={null}
            wrapClassName="withdrawal"
            >
            <div className="withdrawal">
               <div className="withdrawaCoins">
                   <label>
                    <span>以太坊地址</span>
                    <input type="type" value={address} onChange={this.onChangeAddress} />
                   </label>
                   <label>
                    <span>金额 (最小 0.004)</span>
                    <input type="type" value={amt} onChange={this.onChangeSum} />
                   </label>
               </div>
               <button onClick={this.props.withDrawal.bind(this,address,amt)}>取款</button>
            </div>
          </Modal>
        )
    }
}

export default Withdrawal;