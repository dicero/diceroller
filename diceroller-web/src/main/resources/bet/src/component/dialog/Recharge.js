import React, { Component } from 'react';
import {Modal , message} from 'antd';
import './Recharge.less';
import {CopyToClipboard} from 'react-copy-to-clipboard';
import {observer, inject} from "mobx-react";
const info = () => {
    message.info('复制成功');
  };
  
@inject((allStores) => ({
    words: allStores.appStore.wordsToJs
}))@observer class Recharge extends Component {
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
        const {words} = this.props;
        return(
            <Modal
            title={words.nav.cz}
            visible={this.props.rechargeVisible}
            onOk={this.handleOk}
            onCancel={this.handleCancel}
            footer={null}
            wrapClassName="recharge"
            >
            <p>{words.recharge.dz}</p>
            <div className="address">
                <span>{this.state.value}</span>
                <CopyToClipboard text={this.state.value}
                onCopy={() => this.setState({copied: true})}>
                <button onClick={info}>{words.recharge.fz}</button>
                </CopyToClipboard>
            </div>
          </Modal>
        )
    }
}

export default Recharge;