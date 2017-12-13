import React, { Component } from 'react';
import {observer, inject} from "mobx-react";
import { Layout, Icon, Input} from 'antd';
import './Settings.less';
import Head from '../Account/AccountHead.js';
const {Content } = Layout;

@inject((allStores) => ({
    userName: allStores.dialogStore.userNameToJs,
    hasPassword: allStores.appStore.hasPasswordToJs,
    verifyHasPassword: allStores.appStore.verifyHasPassword,
    setPassword: allStores.appStore.setPassword,
    updatePassword: allStores.appStore.updatePassword
}))@observer class Settings extends Component {
    constructor(props) {
        super(props);
        this.state = {
            oldPassword: '',
            password: '',
            newPassword: ''
        };
    }
    emitEmpty1 = () => {
        this.passwordInput.focus();
        this.setState({ password: '' });
    }
    emitEmpty2 = () => {
        this.newPasswordInput.focus();
        this.setState({ newPassword: '' });
    }
    emitEmpty3 = () => {
        this.oldPasswordInput.focus();
        this.setState({ oldPassword: '' });
    }
    emitEmpty = () => {
        this.setState({ password: '' });
        this.setState({ newPassword: '' });
        this.setState({ oldPassword: '' });
    }
    onChangePassword= (e) => {
        this.setState({ password: e.target.value });
    }
    onChangeNewPassword= (e) => {
        this.setState({ newPassword: e.target.value });
    }
    onChangeOldPassword= (e) => {
        this.setState({ oldPassword: e.target.value });
    } 
    componentDidMount() {
        this.props.verifyHasPassword();
    }
    render() {
        const {hasPassword, setPassword, updatePassword} = this.props;
        const { oldPassword, password , newPassword} = this.state;
        const suffix1 = password ? <Icon type="close-circle" onClick={this.emitEmpty1} /> : null;
        const suffix2 = newPassword ? <Icon type="close-circle" onClick={this.emitEmpty2} /> : null;
        const suffix3 = oldPassword ? <Icon type="close-circle" onClick={this.emitEmpty3} /> : null;
        return(
            <div className="settings">
                <Head/>
                <Layout className="settings">
                    <h5>设置新密码</h5>
                    <Content style={{width:"300px",margin:"0 auto"}}>
                    {hasPassword&&(<Input
                        placeholder="旧密码"
                        prefix={<Icon type="lock" />}
                        suffix={suffix3}
                        value={oldPassword}
                        onChange={this.onChangeOldPassword}
                        ref={node => this.oldPasswordInput = node}
                        type={"password"}
                    />)}
                    <Input
                        placeholder="新密码"
                        prefix={<Icon type="lock" />}
                        suffix={suffix1}
                        value={password}
                        onChange={this.onChangePassword}
                        ref={node => this.passwordInput = node}
                        type={"password"}
                    />
                    <Input
                        placeholder="确定新密码"
                        prefix={<Icon type="lock" />}
                        suffix={suffix2}
                        value={newPassword}
                        onChange={this.onChangeNewPassword}
                        ref={node => this.newPasswordInput = node}
                        type={"password"}
                    />
                    {!hasPassword&&<button onClick={ ()=> {
                        this.emitEmpty()
                        setPassword(password, newPassword)
                    }}>设置</button>}
                    {hasPassword&&<button onClick={ () => {
                        this.emitEmpty()
                        updatePassword(password, newPassword, oldPassword)
                    }}>更改</button>}
                    </Content>
                </Layout>
            </div>
        )
    }
}
Settings.defaultProps = {
    hasPassword: false
}
export default Settings;