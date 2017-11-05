import React, { Component } from 'react';
import {Modal , Button, Input ,Spin} from 'antd';
import './Equity.less';
class Equity extends Component {
    constructor(props) {
        super(props)
        this.state = {
            sendVisible: false,
            newUserSeed: '39012fsfsf',
            newServerSeed: 'e53840cbbdf86f738acc18cdf47cc77981e824744d5fd11992358ebccb55adcb',
            userSeend: '13228570930612',
            newSha256: 'e53840cbbdf86f738acc18cdf47cc77981e824744d5fd11992358ebccb55adcb',
            serverSeed: 'a013a7f32b407e545f81d85223b76417be849670580c9be23c91862ae5e40950',
            sha256: '1f9f437673ef82aadaeb6c81e9af192b5642581982869fb222dff0a8cfe1cf6d'
        }
        this.setSeedVisible = this.setSeedVisible.bind(this);
    }
    setSeedVisible(sendVisible) {
        this.setState({ sendVisible });
    }
    render() {
        const {equityVisible, setEquityVisible} = this.props;
        const {sendVisible, newUserSeed, newServerSeed, newSha256, userSeend, serverSeed, sha256} = this.state
        return(
            <Modal
                title="公平性"
                wrapClassName="equityModal"
                visible={equityVisible}
                onOk={() => setEquityVisible(false)}
                onCancel={() => setEquityVisible(false)}
                >
                <p>Primedice使用了十分简便的投注认证系统。在投注之前服务器种子会被散列和展示出来，用户可以选择任何一个种子。服务器种子在浏览器中显示时会以颜色进行标注，这样一来您就能方便地分辨出看到的种子是否是一样的了。</p>
                <div style={{textAlign:"center",margin: "10px"}}>
                <Button type="primary" onClick={() => this.setSeedVisible(true)}>更改用户种子</Button>
                </div>
                <h2>当前种子对</h2>
                <h3>用户种子</h3>
                <p>{newUserSeed}</p>
                <h3>服务器种子sha-256散列</h3>
                <p>{newSha256}</p>
                <h3>由配对进行的押注</h3>
                <p>0</p>
                <h2>以往种子配对</h2>
                <h3>用户种子</h3>
                <p>{userSeend}</p>
                <h3>服务器种子</h3>
                <p>{serverSeed}</p>
                <h3>服务器种子sha-256散列</h3>
                <p>{sha256}</p>
                <h2>押注查询</h2>
                <p>您可以通过查询押注来确认以往投掷的公正性。</p>
                <div style={{textAlign:"center",margin: "10px"}}>
                <Input placeholder="Bet ID (without #)" value=""/><Button type="primary">查看</Button>
                </div>
                
                <Modal
                  title="更改种子"
                  wrapClassName="seedModal"
                  visible={sendVisible}
                  onOk={() => this.setSeedVisible(false)}
                  onCancel={() => this.setSeedVisible(false)}
                >
                    <h3>新服务器种子(散列)</h3>
                    <p>e53840cbbdf86f738acc18cdf47cc77981e824744d5fd11992358ebccb55adcb</p>
                    <h3>新用户种子</h3>
                    <Input placeholder="Basic usage" value={newUserSeed}/>
                </Modal>
                
            </Modal>
        )
    }
}
export default Equity;