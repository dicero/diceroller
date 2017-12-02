import React, { Component } from 'react';
import { Table , Tabs} from 'antd';
import {observer, inject} from "mobx-react";
const TabPane = Tabs.TabPane;
@inject((allStores) => ({
    myStakes: allStores.appStore.myStakesToJs,
    allStakes: allStores.appStore.allStakesToJs,
    highStakes: allStores.appStore.highStakesToJs,
}))@observer class BetLists extends Component {
    render() {
        const columns = [{
            title: '押注ID',
            dataIndex: 'stakeId',
            key: 'stakeId',
            render: text => <a href="#">{text}</a>,
          }, {
            title: ' 用户',
            dataIndex: 'username',
            key: 'username',
          }, {
            title: '时间',
            dataIndex: 'createTime',
            key: 'createTime',
          },
          {
            title: '押注',
            dataIndex: 'amt',
            key: 'amt',
          },
          {
            title: '派彩',
            dataIndex: 'payout',
            key: 'payout',
            render: text => {
                return <span>{text}x</span>
            }
          },
          {
            title: '游戏',
            dataIndex: 'targetTag',
            key: 'targetTag',
            render: text => {
                return <span>{text}</span>
            }
          },
          {
            title: '投掷',
            dataIndex: 'randomResult',
            key: 'randomResult',
          },
          {
            title: '盈利',
            dataIndex: 'changeAmtTag',
            key: 'changeAmtTag',
            render: text => {
                if (parseFloat(text) > 0) {
                    return <span className="green">{text.slice(1)}</span>
                } else {
                    return <span className="red">{text.slice(1)}</span>
                }
            },
          }];
        return(
            <div style={{background: "#ffffff", paddingTop: '30px'}}>
                <div className="betLists">
                    <Tabs defaultActiveKey="1">
                        <TabPane tab="我的押注" key="1">
                            <Table pagination={false} columns={columns} dataSource={this.props.myStakes} />
                        </TabPane>
                        <TabPane tab="所有押注" key="2">
                            <Table pagination={false} columns={columns} dataSource={this.props.allStakes} />
                        </TabPane>
                        <TabPane tab="大额赌注玩家" key="3">
                            <Table pagination={false} columns={columns} dataSource={this.props.highStakes} />
                        </TabPane>
                    </Tabs>
                </div>
            </div>
        )
    }
}
export default BetLists;