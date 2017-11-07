import React, { Component } from 'react';
import {Modal , Button, Input , Spin , Collapse} from 'antd';
import './Equity.less';
import Pubsub from 'pubsub-js';
import './BetDetail.less';
import {
    Link
} from 'react-router-dom'
const Panel = Collapse.Panel;
class BetDetail extends Component {
    constructor(props){
        super(props)
        this.state = {
            betDetail: false,
            id: ''
        }
        this.setBetDetailVisible = this.setBetDetailVisible.bind(this);
        this.setBetDetailId = this.setBetDetailId.bind(this);
    }
    componentDidMount() {
        console.log('betDetail',this.state.betDetail)
        Pubsub.subscribe('BetDetail', function(msg, data){
            console.log('BetDetail', data)
            this.setBetDetailVisible(true)
            this.setBetDetailId(data)
        }.bind(this))
    }
    setBetDetailId (id) {
        this.setState({ id });
    }
    setBetDetailVisible(betDetail) {
        this.setState({ betDetail });
    }
    
    render() {
        const {betDetail, id} = this.state;
        return(
            <Modal
            title={`押注号#${id}`}
            wrapClassName="betDetail"
            visible={betDetail}
            footer={null}
            onOk={() => this.setBetDetailVisible(false)}
            onCancel={() => this.setBetDetailVisible(false)}
            >
                <p>由alexjza</p>
                <p>在23:57押注 November, 4th, 2017</p>
                <ul>
                    <li>
                        <h3>押注金额</h3>
                        <p>0.00008192 BTC</p>
                    </li>
                    <li>
                        <h3>押注派彩</h3>
                        <p>2.00x BTC</p>
                    </li>
                    <li>
                        <h3>押注盈利</h3>
                        <p>-0.00008192 BTC</p>
                    </li>
                </ul>
                <div className="chart">
                    <div>
                        <div className="line">
                            <div style={{transform: "translateX(-67%)"}}></div>
                        </div>
                        <div className="target" style={{left: "33%"}}>
                            <p>目标</p>
                            <span>49.50</span>
                        </div>
                        <div className="rool" style={{left: "54.55%"}}>
                            <p>投掷</p>
                            <span>64.54</span>
                        </div>
                    </div>
                </div>
                <Collapse>
                    <Panel header="验证信息" key="1">
                       <h3>服务器种子 (HASHED)</h3>
                       <p>b3725312aacab5f8c4f97490cf2f9dc36665f6f67b30086dc8271c82a944830a</p>
                       <h3>用户种子 (NONCED)</h3>
                       <p>caa7bc76edff644074add7e24250b2f3-5</p>
                       <p>
                       骰子数字是由HMAC SHA512功能生成的，该功能的关键是服务器种子和一次性随机客户种子使用以下信息: HMAC(serverSeed, clientSeed-nounce)。为了获得由HMAC运行结果生成的骰子数，系统将取前五位并将其作为一个整数。如果这个数字比10^6大，那么就跳过这一个，取接下来5位。把合适结果用10^4模除，获得一个在0-9999之间的数字，再将这个数字除以10^2，生成一个0-99.99之间的数字。想要了解关于可证公平性方面的详细信息，请参考<Link to="/verify"><span onClick={() => this.setBetDetailVisible(false)}>验证页面</span></Link>。
                       </p>
                    </Panel>
                </Collapse>
            </Modal>
        )
    }
}
export default BetDetail;