import React, { Component } from 'react';
import {Modal , Collapse} from 'antd';
import './BetDetail.less';
import {
    Link
} from 'react-router-dom'
import {observer, inject} from "mobx-react";
const Panel = Collapse.Panel;
@inject((allStores) => ({
    betDetailVisible: allStores.dialogStore.betDetailVisible,
    setBetDetailVisible: allStores.dialogStore.setBetDetailVisible,
    stakeDetail: allStores.dialogStore.stakeDetail,
    words: allStores.appStore.wordsToJs
}))@observer
class BetDetail extends Component {

    render() {
        const {betDetailVisible, setBetDetailVisible, stakeDetail, words} = this.props;
        let translateX = 100 - stakeDetail.target;
        if (!stakeDetail.targetCondition) {
            translateX = -translateX;
        }
        
        return(
            <Modal
            title={`${words.betDetail.yzh}#${stakeDetail.stakeId}`}
            wrapClassName="betDetail"
            visible={betDetailVisible}
            footer={null}
            onOk={() => setBetDetailVisible(false)}
            onCancel={() => setBetDetailVisible(false)}
            >
                <p>{words.betDetail.y}{stakeDetail.username}</p>
                <p>{words.betDetail.z}{stakeDetail.createTime}{words.betDetail.yz}</p>
                <ul>
                    <li>
                        <h3>{words.betDetail.yzje}</h3>
                        <p>{stakeDetail.amt} ETH</p>
                    </li>
                    <li>
                        <h3>{words.betDetail.yzpc}</h3>
                        <p>{stakeDetail.payout}x ETH</p>
                    </li>
                    <li>
                        <h3>{words.betDetail.yzyl}</h3>
                        <p>{stakeDetail.changeAmtTag} ETH</p>
                    </li>
                </ul>
                <div className="chart">
                    <div>
                        <div className="line">
                            <div style={{transform: `translateX(${translateX}%)`}}></div>
                        </div>
                        <div className="target" style={{left: `${stakeDetail.target}%`}}>
                            <p>{words.betDetail.mb}</p>
                            <span>{stakeDetail.target}</span>
                        </div>
                        <div className="rool" style={{left: `${stakeDetail.randomResult}%`}}>
                            <p>{words.betDetail.tz}</p>
                            <span>{stakeDetail.randomResult}</span>
                        </div>
                    </div>
                </div>
                <Collapse>
                    <Panel header={words.betDetail.yzxx} key="1">
                       <h3>{words.betDetail.fwqzz}</h3>
                       <p>{stakeDetail.serverSeedHashEd}</p>
                       <h3>{words.betDetail.yhzz}</h3>
                       <p>{stakeDetail.clientSeedEd}</p>
                       <p>
                       {words.betDetail.zs}<Link to="/verify"><span onClick={() => setBetDetailVisible(false)}>{words.betDetail.yzym}</span></Link>。
                       </p>
                    </Panel>
                </Collapse>
            </Modal>
        )
    }
}
export default BetDetail;