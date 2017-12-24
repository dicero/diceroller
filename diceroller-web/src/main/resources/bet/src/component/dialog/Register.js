import React, { Component } from 'react';
import {Modal , Input, Icon} from 'antd';
import './Register.less';
import {observer, inject} from "mobx-react";
import Login from './Login.js';
@inject((allStores) => ({
    registerVisible: allStores.dialogStore.registerVisible,
    isShowLogin: allStores.dialogStore.isShowLogin,
    register: allStores.dialogStore.register,
    setLoginShow: allStores.dialogStore.setLoginShow,
    words: allStores.appStore.wordsToJs
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
        const {words} = this.props;
        const { userName } = this.state;
        const suffix = userName ? <Icon type="close-circle" onClick={this.emitEmpty} /> : null;
        return(
            <Modal
            title={words.login.zc}
            visible={this.props.registerVisible}
            footer={null}
            wrapClassName="register"
            closable={false}
            maskClosable={false}
            >
            <div className="register">
                <h2>Diceroller</h2>
                <h3>{words.register.title}</h3>
                <div className="form">
                <Input
                    placeholder={words.register.placeholder}
                    prefix={<Icon type="user" />}
                    suffix={suffix}
                    value={userName}
                    onChange={this.onChangeUserName}
                    ref={node => this.userNameInput = node}
                />
                <button onClick={this.props.register.bind(this,userName)}>{words.register.jr}</button>
                </div>
                <p>{words.register.yyzh}<strong onClick={this.props.setLoginShow.bind(this, true)}>{words.register.zzldl}</strong></p>
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