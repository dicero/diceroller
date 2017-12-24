import React, { Component } from 'react';
import { Modal, Input, Icon, Button , message} from 'antd';
import { observer, inject } from "mobx-react";
import './Advise.less';
const { TextArea } = Input;

@inject((allStores) => ({
    words: allStores.appStore.wordsToJs,
    adviseVisible: allStores.dialogStore.adviseVisible,
    setAdviseShow: allStores.dialogStore.setAdviseShow,
    sendAdvise: allStores.dialogStore.sendAdvise
})) @observer class Advise extends Component {
    constructor(props) {
        super(props);
        this.state = {
            mail: '',
            message: '',
            verify: true
        };
    }
    emitEmpty1 = () => {
        this.mailInput.focus();
        this.setState({ mail: '' });
    }
    onChangeMail = (e) => {
        this.setState({ mail: e.target.value });
    }
    onChangeMessage = (e) => {
        this.setState({ message: e.target.value });
    }
    onHandleBlur = (e) => {
        const {words} = this.props;
        var reg = new RegExp("^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$");
        if (e.target.value === "") { 
            this.setState({ verify: true });
        } else if (!reg.test(e.target.value)) { //正则验证不通过，格式不对
            this.setState({ verify: false });
            message.info(words.advise.yxgs);
        } else {
            this.setState({ verify: true });
        }
    }
    onHandleOk = () => {
        const {mail, message, verify} = this.state;
        const {words} = this.props;
        if (verify) {
            this.props.sendAdvise(mail, message);
            this.setState({ 
                message: '',
                mail: ''
            });
        } else {
            message.info(words.advise.yxgs);
        }
    }
    render() {
        const { mail, message } = this.state;
        const {words} = this.props;
        const suffix1 = mail ? <Icon type="close-circle" onClick={this.emitEmpty1} /> : null;
        return (
            <div className="advise">
                <div className="adviseBtn" onClick={this.props.setAdviseShow.bind(this, true)} title={words.advise.fk}>
                    {words.advise.fk}
                </div>
                <Modal
                    title={words.advise.jy}
                    visible={this.props.adviseVisible}
                    wrapClassName="advise"
                    closable={false}
                    onCancel={this.props.setAdviseShow.bind(this, false)}
                    onOk={this.onHandleOk}
                    okText={words.advise.qd}
                    cancelText={words.advise.qx}
                >
                    <div className="form">
                        <p>{words.advise.yx}</p>
                        <Input
                            type="email"
                            prefix={<Icon type="mail" />}
                            suffix={suffix1}
                            value={mail}
                            onChange={this.onChangeMail}
                            ref={node => this.mailInput = node}
                            onBlur={this.onHandleBlur}
                        />
                        <p>{words.advise.jy}</p>
                        <TextArea
                            rows={4}
                            value={message}
                            onChange={this.onChangeMessage}
                        />
                    </div>
                </Modal>
            </div>
        )
    }
}

export default Advise;