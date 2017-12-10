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
    stakeDetail: allStores.dialogStore.stakeDetail
}))@observer
class BetDetail extends Component {

    render() {
        const {betDetailVisible, setBetDetailVisible, stakeDetail} = this.props;
        let translateX = 100 - stakeDetail.target;
        if (!stakeDetail.targetCondition) {
            translateX = -translateX;
        }
        
        return(
            <Modal
            title={`押注号#${stakeDetail.stakeId}`}
            wrapClassName="betDetail"
            visible={betDetailVisible}
            footer={null}
            onOk={() => setBetDetailVisible(false)}
            onCancel={() => setBetDetailVisible(false)}
            >
                <p>由{stakeDetail.username}</p>
                <p>在{stakeDetail.createTime}押注</p>
                <ul>
                    <li>
                        <h3>押注金额</h3>
                        <p>{stakeDetail.amt} ETH</p>
                    </li>
                    <li>
                        <h3>押注派彩</h3>
                        <p>{stakeDetail.payout}x ETH</p>
                    </li>
                    <li>
                        <h3>押注盈利</h3>
                        <p>{stakeDetail.changeAmtTag} ETH</p>
                    </li>
                </ul>
                <div className="chart">
                    <div>
                        <div className="line">
                            <div style={{transform: `translateX(${translateX}%)`}}></div>
                        </div>
                        <div className="target" style={{left: `${stakeDetail.target}%`}}>
                            <p>目标</p>
                            <span>{stakeDetail.target}</span>
                        </div>
                        <div className="rool" style={{left: `${stakeDetail.randomResult}%`}}>
                            <p>投掷</p>
                            <span>{stakeDetail.randomResult}</span>
                        </div>
                    </div>
                </div>
                <Collapse>
                    <Panel header="验证信息" key="1">
                       <h3>服务器种子 (HASHED)</h3>
                       <p>{stakeDetail.serverSeedHashEd}</p>
                       <h3>用户种子 (NONCED)</h3>
                       <p>{stakeDetail.clientSeedEd}</p>
                       <p>
                       骰子数字是由HMAC SHA512功能生成的，该功能的关键是服务器种子和一次性随机客户种子使用以下信息: HMAC(serverSeed, clientSeed-nounce)。为了获得由HMAC运行结果生成的骰子数，系统将取前五位并将其作为一个整数。如果这个数字比10^6大，那么就跳过这一个，取接下来5位。把合适结果用10^4模除，获得一个在0-9999之间的数字，再将这个数字除以10^2，生成一个0-99.99之间的数字。想要了解关于可证公平性方面的详细信息，请参考<Link to="/verify"><span onClick={() => setBetDetailVisible(false)}>验证页面</span></Link>。
                       </p>
                    </Panel>
                </Collapse>
            </Modal>
        )
    }
}
export default BetDetail;