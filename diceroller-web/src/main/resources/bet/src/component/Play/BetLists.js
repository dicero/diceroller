import React, { Component } from 'react';
import { Table , Tabs} from 'antd';
const TabPane = Tabs.TabPane;
class BetLists extends Component {
    render() {
        const columns = [{
            title: '押注ID',
            dataIndex: 'id',
            key: 'id',
            render: text => <a href="#">{text}</a>,
          }, {
            title: ' 用户',
            dataIndex: 'user',
            key: 'user',
          }, {
            title: '时间',
            dataIndex: 'time',
            key: 'time',
          },
          {
            title: '押注',
            dataIndex: 'bet',
            key: 'bet',
          },
          {
            title: '派彩',
            dataIndex: 'payout',
            key: 'payout',
          },
          {
            title: '游戏',
            dataIndex: 'game',
            key: 'game',
          },
          {
            title: '投掷',
            dataIndex: 'count',
            key: 'count',
          },
          {
            title: '盈利',
            dataIndex: 'profit',
            key: 'profit',
            render: text => {
                if (parseFloat(text) > 0) {
                    return <span className="green">{text}</span>
                } else {
                    return <span className="red">{text}</span>
                }
            },
          }];
          const data = [{
            id: '20,169,927,283',
            user: 'John Brown',
            time: '23:57',
            bet: '0.00000001',
            payout: '3.00x',
            game: '< 33.00',
            count: '5.23',
            profit: '0.00000002'
          }, {
            id: '20,169,927,283',
            user: 'John Brown',
            time: '23:57',
            bet: '0.00000001',
            payout: '3.00x',
            game: '< 33.00',
            count: '5.23',
            profit: '0.00000002'
          }, {
            id: '20,169,927,283',
            user: 'John Brown',
            time: '23:57',
            bet: '0.00000001',
            payout: '3.00x',
            game: '< 33.00',
            count: '5.23',
            profit: '-0.00000002'
          }];
        return(
            <div style={{background: "#ffffff"}}>
                <div className="betLists">
                    <Tabs defaultActiveKey="1">
                        <TabPane tab="我的押注" key="1">
                            <Table pagination={false} columns={columns} dataSource={data} />
                        </TabPane>
                        <TabPane tab="所有押注" key="2">
                            <Table pagination={false} columns={columns} dataSource={data} />
                        </TabPane>
                        <TabPane tab="大额赌注玩家" key="3">
                            <Table pagination={false} columns={columns} dataSource={data} />
                        </TabPane>
                    </Tabs>
                </div>
            </div>
            
            
            
        )
    }
}
export default BetLists;