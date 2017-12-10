import React, { Component } from 'react';
import {Modal , Input} from 'antd';
import './Equity.less';
import {observer, inject} from "mobx-react";
import {
    Link
} from 'react-router-dom'
@inject((allStores) => ({
    queryPosessSeed: allStores.dialogStore.queryPosessSeed,
    equity: allStores.dialogStore.equityToJs,
    setUserSeend: allStores.dialogStore.setUserSeend,
    userSeed: allStores.dialogStore.userSeed,
    setQueryBetId: allStores.dialogStore.setQueryBetId,
    queryBetId: allStores.dialogStore.queryBetId,
    changeSeed: allStores.dialogStore.changeSeed,
    queryStakeById: allStores.dialogStore.queryStakeById
}))@observer class Equity extends Component {
    constructor(props) {
        super(props)
        this.state = {
            sendVisible: false
        }
        this.setSeedVisible = this.setSeedVisible.bind(this);
        this.handleChangeUserSeend = this.handleChangeUserSeend.bind(this);
        this.handleChangeBetId = this.handleChangeBetId.bind(this);
    }
    setSeedVisible(sendVisible) {
        this.setState({ sendVisible });
    }
    
    handleChangeUserSeend(sendVisible) {
        this.setState({ sendVisible });
        this.props.changeSeed();
    }
    handleChangeBetId(betId) {
        this.setState({betId})
    }
    componentDidMount() {
        this.props.queryPosessSeed()
    }
    render() {
        const {equityVisible, setEquityVisible, equity, userSeed, 
            setUserSeend, queryBetId, setQueryBetId ,queryStakeById} = this.props;
        const {sendVisible} = this.state
        return(
            <Modal
                title="公平性"
                wrapClassName="equityModal"
                visible={equityVisible}
                footer={null}
                onOk={() => setEquityVisible(false)}
                onCancel={() => setEquityVisible(false)}
                >
                <p style={{padding: '16px'}}>Diceroller使用了十分简便的投注认证系统。在投注之前服务器种子会被散列和展示出来，用户可以选择任何一个种子。服务器种子在浏览器中显示时会以颜色进行标注，这样一来您就能方便地分辨出看到的种子是否是一样的了。<Link to="/verify"><span onClick={() => setEquityVisible(false)}>更多信息...</span></Link></p>
                <button className="changeSeed" onClick={() => this.setSeedVisible(true)}>
                    <span>随机化</span>
                    <small>更改用户种子</small>
                </button>
                <div className="footer">
                    <h2>当前种子对</h2>
                    <h3>用户种子</h3>
                    <p className="text">{equity.cur.clientSeed}</p>
                    <h3>服务器种子sha-256散列</h3>
                    <p className="sha">{equity.cur.serverSeedHash}</p>
                    <h3>由配对进行的押注</h3>
                    <p>{equity.cur.sumNonce}</p>
                    <h2>以往种子配对</h2>
                    <h3>用户种子</h3>
                    <p>{equity.pre.clientSeed}</p>
                    <h3>服务器种子</h3>
                    <p>{equity.pre.serverSeed}</p>
                    <h3>服务器种子sha-256散列</h3>
                    <p>{equity.pre.serverSeedHash}</p>
                    <h2>查询押注</h2>
                    <p>您可以通过查询押注来确认以往投掷的公正性。</p>
                    <div style={{display: 'flex'}}>
                        <Input placeholder="Bet ID (without #)" value={queryBetId} onChange={(e) => setQueryBetId(e.target.value)}/>
                        <button onClick={queryStakeById.bind(this, queryBetId)} className="btn">查看</button>
                    </div>
                </div>
                
                <Modal
                  title="更改种子"
                  wrapClassName="seedModal"
                  visible={sendVisible}
                  onOk={() => this.handleChangeUserSeend(false)}
                  onCancel={() => this.setSeedVisible(false)}
                    >
                    <h3>新服务器种子(散列)</h3>
                    <p>{equity.new.newServerSeedHash}</p>
                    <h3>新用户种子</h3>
                    <Input placeholder="Basic usage" value={userSeed} onChange={(e) => setUserSeend(e.target.value)}/>
                </Modal>
            </Modal>
        )
    }
}
export default Equity;