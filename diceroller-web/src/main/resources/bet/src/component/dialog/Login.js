import React, { Component } from 'react';
import {Modal , message, Button, Input, Icon} from 'antd';
import './Login.less';
import {observer, inject} from "mobx-react";

@inject((allStores) => ({
    loginVisible: allStores.dialogStore.loginVisible,
    isShowLogin: allStores.dialogStore.isShowLogin,
    register: allStores.dialogStore.register
}))@observer class Login extends Component {
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
            visible={this.props.loginVisible}
            footer={null}
            wrapClassName="login"
            closable={false}
            maskClosable={false}
            >
            <div className="login">
                <h2>Diceroller</h2>
                <h3>最受欢迎的和最值得信赖的比特币博彩网站</h3>
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
            </div>
          </Modal>
        )
    }
}
Login.defaultProps = {
    loginVisible: true
}
export default Login;