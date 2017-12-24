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
    queryStakeById: allStores.dialogStore.queryStakeById,
    words: allStores.appStore.wordsToJs
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
            setUserSeend, queryBetId, setQueryBetId ,queryStakeById, words} = this.props;
        const {sendVisible} = this.state
        return(
            <Modal
                title={words.equity.gpx}
                wrapClassName="equityModal"
                visible={equityVisible}
                footer={null}
                onOk={() => setEquityVisible(false)}
                onCancel={() => setEquityVisible(false)}
                >
                <p style={{padding: '16px'}}>{words.equity.zs}<Link to="/verify"><span onClick={() => setEquityVisible(false)}>{words.equity.gdxx}...</span></Link></p>
                <button className="changeSeed" onClick={() => this.setSeedVisible(true)}>
                    <span>{words.equity.sjh}</span>
                    <small>{words.equity.ggyhzz}</small>
                </button>
                <div className="footer">
                    <h2>{words.equity.dqzzd}</h2>
                    <h3>{words.equity.yhzz}</h3>
                    <p className="text">{equity.cur.clientSeed}</p>
                    <h3>{words.equity.fwqzzs}</h3>
                    <p className="sha">{equity.cur.serverSeedHash}</p>
                    <h3>{words.equity.ypdjxdyz}</h3>
                    <p>{equity.cur.sumNonce}</p>
                    <h2>{words.equity.ywzzpd}</h2>
                    <h3>{words.equity.yhzz}</h3>
                    <p>{equity.pre.clientSeed}</p>
                    <h3>{words.equity.fwqzz}</h3>
                    <p>{equity.pre.serverSeed}</p>
                    <h3>{words.equity.fwqzzs}</h3>
                    <p>{equity.pre.serverSeedHash}</p>
                    <h2>{words.equity.cxyz}</h2>
                    <p>{words.equity.tg}</p>
                    <div style={{display: 'flex'}}>
                        <Input placeholder="Bet ID (without #)" value={queryBetId} onChange={(e) => setQueryBetId(e.target.value)}/>
                        <button onClick={queryStakeById.bind(this, queryBetId)} className="btn">{words.equity.ck}</button>
                    </div>
                </div>
                
                <Modal
                  title={words.equity.ggzz}
                  wrapClassName="seedModal"
                  visible={sendVisible}
                  onOk={() => this.handleChangeUserSeend(false)}
                  onCancel={() => this.setSeedVisible(false)}
                    >
                    <h3>{words.equity.xfwqzz}</h3>
                    <p>{equity.new.newServerSeedHash}</p>
                    <h3>{words.equity.xyhzz}</h3>
                    <Input placeholder="Basic usage" value={userSeed} onChange={(e) => setUserSeend(e.target.value)}/>
                </Modal>
            </Modal>
        )
    }
}
export default Equity;