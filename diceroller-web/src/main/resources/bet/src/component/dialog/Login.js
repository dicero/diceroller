import React, { Component } from 'react';
import {Modal , Input, Icon} from 'antd';
import './Login.less';
import {observer, inject} from "mobx-react";

@inject((allStores) => ({
    loginVisible: allStores.dialogStore.loginVisible,
    login: allStores.dialogStore.login,
    setLoginShow: allStores.dialogStore.setLoginShow,
    words: allStores.appStore.wordsToJs
}))@observer class Login extends Component {
    constructor(props) {
        super(props);
        this.state = {
            userName: '',
            passWord: ''
        };
    }
    emitEmpty1 = () => {
        this.userNameInput.focus();
        this.setState({ userName: '' });
    }
    onChangeUserName = (e) => {
        this.setState({ userName: e.target.value });
    }
    emitEmpty2 = () => {
        this.passWordInput.focus();
        this.setState({ passWord: '' });
    }
    onChangePassWord = (e) => {
        this.setState({ passWord: e.target.value });
    }
    render() {
        const {words} = this.props;
        const { userName, passWord } = this.state;
        const suffix1 = userName ? <Icon type="close-circle" onClick={this.emitEmpty1} /> : null;
        const suffix2 = passWord ? <Icon type="close-circle" onClick={this.emitEmpty2} /> : null;
        return(
            <Modal
            title={words.login.dl}
            visible={this.props.loginVisible}
            footer={null}
            wrapClassName="login"
            closable={false}
            maskClosable={true}
            onCancel={this.props.setLoginShow.bind(this, false)}
            >
            <div className="login">
                <h2>Diceroller</h2>
                <h3>{words.login.title}</h3>
                <div className="form">
                <Input
                    placeholder={words.login.placeholderName}
                    prefix={<Icon type="user" />}
                    suffix={suffix1}
                    value={userName}
                    onChange={this.onChangeUserName}
                    ref={node => this.userNameInput = node}
                />
                <Input
                    placeholder={words.login.placeholderPassword}
                    prefix={<Icon type="lock" />}
                    suffix={suffix2}
                    value={passWord}
                    onChange={this.onChangePassWord}
                    ref={node => this.passWordInput = node}
                    type={"password"}
                />
                <button onClick={this.props.login.bind(this,userName,passWord)}>{words.login.dl}</button>
                </div>
                <p>{words.login.wjmm}<strong onClick={this.props.setLoginShow.bind(this, false)}>{words.login.hd}</strong></p>
            </div>
          </Modal>
        )
    }
}
Login.defaultProps = {
    loginVisible: false
}
export default Login;