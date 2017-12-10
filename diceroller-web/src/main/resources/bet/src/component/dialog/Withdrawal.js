import React, { Component } from 'react';
import {Modal} from 'antd';
import './Withdrawal.less';

class Withdrawal extends Component {
    handleOk = (e) => {
      console.log(e);
      this.props.setWithdrawalVisible(false)
    }
    handleCancel = (e) => {
      console.log(e);
      this.props.setWithdrawalVisible(false)
    }
    render() {
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
                    <span>比特币地址</span>
                    <input type="type"/>
                   </label>
                   <label>
                    <span>比特币地址</span>
                    <input type="type" />
                   </label>
               </div>
               <button>取款</button>
            </div>
          </Modal>
        )
    }
}

export default Withdrawal;