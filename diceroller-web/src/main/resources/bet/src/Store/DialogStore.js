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

    @observable loading = false; 

    @observable adviseVisible = false;

    @observable equity = {
        cur: {
            serverSeed: '--',
            clientSeed: '--',
            serverSeedHash: '--',
            sumNonce: '--',
        },
        pre: {
            serverSeed: '--',
            clientSeed: '--',
            serverSeedHash: '--',
            sumNonce: '--',
        },
        new: {
            newClientSeed: '--',
            newServerSeedHash: '--',
            newSeedId: '--'
        }
    }

    @observable userSeed = ''; //用户种子id

    @observable queryBetId = ''; //  查询id

    @observable stakeDetail = {} // 押注数据
     
    @observable betDetailVisible = false;

    @observable equityVisible = false;

    @observable  words = this.rootStore.appStore.words; 

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
                this.createWebSocket(response.data.data.accessToken);
                if (response.data.data.playAccess === '1') {
                    this.setLoading(false);
                } else {
                    this.setLoading(true);
                }
                
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
                        message.info(this.words.message.drcg);
                        this.registerVisible = false;
                        this.userName = name;
                        this.createWebSocket(response.data.data.accessToken);
                        this.rootStore.appStore.init();
                    break;
                    case 101:
                        message.info(this.words.message.yhmycz);
                    break;
                    case 102:
                        message.info(this.words.message.yhwdl);
                    break;
                    case 102:
                        message.info(this.words.message.qqcf);
                    break;
                    default:
                        message.info(this.words.message.qqsb);
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
                    message.info(this.words.message.drcg);
                    this.loginVisible = false;
                    this.registerVisible = false;
                    this.userName = name;
                    this.createWebSocket(response.data.data.accessToken);
                    this.rootStore.appStore.init();
                } else {
                    message.info(this.words.message.zhhmmcw);
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
            message.info(this.words.message.txjedyzhye);
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
                    message.info(this.words.message.txsqcg);
                } else {
                    message.info(this.words.message.txsqsb);
                }
            })
    }
    @action.bound
    setEquityVisible(value) {
        this.equityVisible = value;
    }
    // websocekt
    @action.bound
    createWebSocket(access_token) {
        console.log('createWebSocket')
        let socket = new WebSocket('ws:47.100.107.97/games?access_token=' + access_token);
        socket.onopen = (event) => { 
            console.log('socket-onopen')
            // 发送一个初始化消息
            socket.send('I am the client and I\'m listening!'); 
        
            // 监听消息
            socket.onmessage = (event) => { 
                console.log('Client received a message',event);
                const serverData = JSON.parse(event.data);
                let appStore = this.rootStore.appStore;
                if (serverData.event === 'PUSH') {
                    this.setLoading(false);
                    let data = serverData.data;
                    // 输
                    let balance, changeAmt;
                    if (data.fundType === 'FO') {
                        balance = Number(appStore.balance) - Number(data.changeAmt)
                        changeAmt = '-' + Number(data.changeAmt).toFixed(8);
                        appStore.fundType = false;
                    } else {
                        balance = Number(appStore.balance) + Number(data.changeAmt)
                        changeAmt = '+' + Number(data.changeAmt).toFixed(8);
                        appStore.fundType = true;
                    }
                    appStore.balance = balance.toFixed(8);
                    appStore.setMarks(data.randomResult);
                    appStore.setAmt(changeAmt)
                    appStore.getSakeCollect();
                    appStore.getAllStakes();
                    
                    //this.balance = data.balance;
                }
            }; 
        
            // 监听Socket的关闭
            socket.onclose = function(event) { 
                console.log('Client notified socket has closed',event); 
                socket.close() 
            }; 
        
            // 关闭Socket.... 
            //socket.close() 
        };
    }
    @action.bound
    setLoading(value) {
        this.loading = value;
    }
    @action.bound
    setAdviseShow(value) {
        this.adviseVisible = value;
    }
    @action.bound
    sendAdvise(mail, message) {
        axios({
            method: 'post',
            url: '/rest/member/advise',
            params: {
                email: mail,
                content: message
            }
        })
            .then((response) => {
                if (response.data.code === 100) {
                    this.setAdviseShow(false);
                    message.info(this.words.message.tjcg);
                }
            })
    }
}