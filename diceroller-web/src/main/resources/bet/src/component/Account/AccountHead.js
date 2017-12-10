import React, { Component } from 'react';
import {observer, inject} from "mobx-react";
import {Menu} from 'antd';
import './Head.less';
import {
    Link
} from 'react-router-dom'

@inject((allStores) => ({
    userName: allStores.dialogStore.userNameToJs
}))@observer class Head extends Component {
    state = {
        current: 'settings',
    }
    handleClick = (e) => {
        this.setState({
          current: e.key,
        });
    }
    render() {
        const {userName} = this.props;
        return(
            <div className="head">
                <div>
                    <h2>{userName}<Link to="/play"><span className="close"><svg className="account__close" width="16" height="16" viewBox="0 0 16 16" xmlns="http://www.w3.org/2000/svg"><g fill="none" fillRule="evenodd"><path d="m585 5.611l-1.611-1.611-6.389 6.389-6.389-6.389-1.611 1.611 6.389 6.389-6.389 6.389 1.611 1.611 6.389-6.389 6.389 6.389 1.611-1.611-6.389-6.389 6.389-6.389" transform="translate(-569-4)" fill="#fff"></path></g></svg></span></Link></h2>
                    <Menu
                        onClick={this.handleClick}
                        selectedKeys={[this.state.current]}
                        mode="horizontal"
                    >
                        <Menu.Item key="settings"><Link to="/account/settings">设置</Link></Menu.Item>
                        <Menu.Item key="mail">安全</Menu.Item>
                    </Menu>
                </div>    
            </div>
        )   
    }
}
export default Head;