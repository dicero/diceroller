import React, { Component } from 'react';
import {Modal , Input, Icon} from 'antd';
import './Register.less';
import {observer, inject} from "mobx-react";
import Login from './Login.js';
@inject((allStores) => ({
    registerVisible: allStores.dialogStore.registerVisible,
    isShowLogin: allStores.dialogStore.isShowLogin,
    register: allStores.dialogStore.register,
    setLoginShow: allStores.dialogStore.setLoginShow
}))@observer class Register extends Component {
    constructor(props) {
        super(props);
        this.state = {
            userName: '',
        };
    }
    emitEmpty = () => {
        this.userNameInput.focus();
        this.setState({ userName: '' });
    }
    onChangeUserName = (e) => {
        this.setState({ userName: e.target.value });
    }
    componentDidMount() {
        this.props.isShowLogin();
    }
    render() {
        const { userName } = this.state;
        const suffix = userName ? <Icon type="close-circle" onClick={this.emitEmpty} /> : null;
        return(
            <Modal
            title="登录"
            visible={this.props.registerVisible}
            footer={null}
            wrapClassName="register"
            closable={false}
            maskClosable={false}
            >
            <div className="register">
                <h2>Diceroller</h2>
                <h3>最受欢迎的和最值得信赖的以太坊博彩网站</h3>
                <div className="form">
                <Input
                    placeholder="Enter your userName"
                    prefix={<Icon type="user" />}
                    suffix={suffix}
                    value={userName}
                    onChange={this.onChangeUserName}
                    ref={node => this.userNameInput = node}
                />
                <button onClick={this.props.register.bind(this,userName)}>加入</button>
                </div>
                <p>已经有一个账户了？<strong onClick={this.props.setLoginShow.bind(this, true)}>在这里登录</strong></p>
            </div>
            <Login/>
          </Modal>
        )
    }
}
Register.defaultProps = {
    registerVisible: true
}
export default Register;