import React, { Component } from 'react';
import {Modal , message, Button} from 'antd';
import './Recharge.less';
import {CopyToClipboard} from 'react-copy-to-clipboard';
const info = () => {
    message.info('复制成功');
  };
class Recharge extends Component {
    constructor(props) {
        super(props);
        this.state = {
            value: '16oQg8eRXKvVURGmqAg3ySLVxvBebsPveY',
            copied: false,
        };
    }
    handleOk = (e) => {
      console.log(e);
      this.props.setRechargeVisible(false)
    }
    handleCancel = (e) => {
      console.log(e);
      this.props.setRechargeVisible(false)
    }
    render() {
        return(
            <Modal
            title="充值"
            visible={this.props.rechargeVisible}
            onOk={this.handleOk}
            onCancel={this.handleCancel}
            footer={null}
            wrapClassName="recharge"
            >
            <p>您的个人地址是</p>
            <div className="address">
                <span>{this.state.value}</span>
                <CopyToClipboard text={this.state.value}
                onCopy={() => this.setState({copied: true})}>
                <button onClick={info}>复制到剪贴板</button>
                </CopyToClipboard>
            </div>
          </Modal>
        )
    }
}

export default Recharge;