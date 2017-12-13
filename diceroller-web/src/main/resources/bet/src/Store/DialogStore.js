import mobx from "mobx";
import {observable, action, computed} from "mobx";
import axios from 'axios';
import { message } from 'antd';
export default class DialogStore {
    constructor(rootStore) {
        this.rootStore = rootStore;
    }
    @observable userName = '';

    @observable registerVisible = true;
    
    @observable loginVisible = false;

    @observable equity = {
        cur: {
            serverSeed: '暂无',
            clientSeed: '暂无',
            serverSeedHash: '暂无',
            sumNonce: '暂无',
        },
        pre: {
            serverSeed: '暂无',
            clientSeed: '暂无',
            serverSeedHash: '暂无',
            sumNonce: '暂无',
        },
        new: {
            newClientSeed: '暂无',
            newServerSeedHash: '暂无',
            newSeedId: '暂无'
        }
    }

    @observable userSeed = ''; //用户种子id

    @observable queryBetId = ''; //  查询id

    @observable stakeDetail = {} // 押注数据
     
    @observable betDetailVisible = false;
    @computed
    get userNameToJs() {
        return mobx.toJS(this.userName)
    }
    @computed
    get equityToJs() {
        return mobx.toJS(this.equity)
    }
    @action.bound
    setUserSeend(id) {
        this.userSeed = id;
    }
    @action.bound
    setQueryBetId(id) {
        this.queryBetId = id;
    }
    @action.bound
    setLoginShow(value) {
        this.loginVisible = value;
    }
    @action.bound
    isShowLogin() {
        axios.post('/rest/query/state')
        .then((response) => {
            if (response.data.code === 100) {
                this.userName = response.data.data.username;
                this.registerVisible = false;
                this.rootStore.appStore.init();
            } else {
                this.registerVisible = true;
            } 
        })
    }
    @action.bound
    register(name) {
        axios({
            method: 'post',
            url: '/rest/auth/register',
            params: {
                username: name
            }
          })
            .then((response) => {
                switch(response.data.code) {
                    case 100:
                        message.info('登陆成功');
                        this.registerVisible = false;
                        this.userName = name;
                        this.rootStore.appStore.init();
                    break;
                    case 101:
                        message.info('用户名已存在');
                    break;
                    case 102:
                        message.info('用户未登陆');
                    break;
                    case 102:
                        message.info('请求重复');
                    break;
                    default:
                        message.info('请求失败');
                    break;
                }
            })
    }
    @action.bound
    login(name, password) {
        axios({
            method: 'post',
            url: '/rest/auth/login',
            params: {
                username: name,
                password: password
            }
          })
            .then((response) => {
                if (response.data.code === 100) {
                    message.info('登录成功');
                    this.loginVisible = false;
                    this.registerVisible = false;
                    this.userName = name;
                    this.rootStore.appStore.init();
                } else {
                    message.info('用户名或密码错误！');
                }
            })
    }
    //  查询拥有的种子
    @action.bound
    queryPosessSeed() {
        let copyEquity = this.equityToJs;
        axios({
            method: 'post',
            url: '/rest/query/possessSeed'
          })
          .then((response) =>{
                if (response.data.code === 100) {
                    let data = response.data.data;
                    copyEquity.cur = data.list[0];
                    copyEquity.pre = data.list[1] ? data.list[1] : copyEquity.pre;
                    copyEquity.new.newClientSeed =  data.newClientSeed;
                    copyEquity.new.newSeedId =  data.newSeedId;
                    copyEquity.new.newServerSeedHash =  data.newServerSeedHash;
                    this.equity = copyEquity;
                    this.setUserSeend(data.newClientSeed);
                }
          })
    }
    //  更改种子
    @action.bound
    changeSeed() {
        axios({
            method: 'post',
            url: '/rest/member/seed',
            params: {
                newClientSeed: this.userSeed,
                newSeedId: this.equity.new.newSeedId
            }
          })
          .then((response) =>{
              if(response.data.code === 100) {
                  this.queryPosessSeed()
              }
          })
    }
    //  根据押注id，查询押注数据
    @action.bound
    queryStakeById(queryBetId) {
        axios({
            method: 'post',
            url: '/rest/query/stakeById',
            params: {
                stakeId: queryBetId
            }
        })
            .then((response) => {
                if (response.data.code === 100) {
                    let data = response.data.data;
                    this.stakeDetail = data;
                    this.setBetDetailVisible(true);
                }
            })
    }
    //  设置押注详情显示展示
    @action.bound
    setBetDetailVisible(flag) {
        this.betDetailVisible = flag
    }
    // 取款
    @action.bound
    withDrawal(address, amt) {
        if(this.rootStore.appStore.balance < amt) {
            message.info('提现金额大于账户余额');
            return 
        }
        axios({
            method: 'post',
            url: '/rest/member/withdraw',
            params: {
                address: address,
                amt: amt
            }
        })
            .then((response) => {
                if (response.data.code === 100) {
                    message.info('提现申请成功');
                } else {
                    message.info('提现申请失败');
                }
            })
    }
}