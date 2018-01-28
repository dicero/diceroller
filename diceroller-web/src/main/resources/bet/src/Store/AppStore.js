import mobx from "mobx";
import {observable, action, computed} from "mobx";
import axios from 'axios';
import { message } from 'antd';
import {languageCf} from '../Config.js';
export default class AppStore {
    constructor(rootStore) {
        this.rootStore = rootStore;
    }
    @observable name = 'qwe';

    @observable balance =  0; //  账户余额
    
    @observable hasPassword = false; // 是否有密码

    houseEdge = 0.01;

    @observable bet =  '0.00000000'; //押注金额

    @observable ethGasLimit = '21000';//手续费上限

    @observable ethGasPrice = '2000000000000'; //手续费

    @observable chance = 49.50; // 胜率

    @observable payout = 2.000; //派彩

    @observable rollOver = true; // 滚存

    @observable showMark = false; // 展示点数

    @observable stakeCollect = {
        historyCollect: {
            createTime: null,
            allStakeAmt: 0,
            allWinAmt: 0,
            allLoseAmt: 0,
            allWinGames: 0,
            allLoseGames: 0,
            winningPos: 0
          },
          todayCollect: {
            createTime: null,
            allStakeAmt: 0,
            allWinAmt: 0,
            allLoseAmt: 0,
            allWinGames: 0,
            allLoseGames: 0,
            winningPos: 0
          }
    }

    @observable marks = '0';

    @observable changeAmt = '';

    @observable showAnim = false;

    @observable fundType;

    @observable myStakes=[];

    @observable allStakes=[];

    @observable highStakes = [];

    @observable language = 'ZH';

    @observable words = languageCf[this.language];


    @computed
    get hasPasswordToJs() {
        return mobx.toJS(this.hasPassword)
    }

    @computed
    get myStakesToJs() {
        return mobx.toJS(this.myStakes)
    }
    @computed
    get allStakesToJs() {
        return mobx.toJS(this.allStakes)
    }
    @computed
    get highStakesToJs() {
        return mobx.toJS(this.highStakes)
    }
    @computed
    get balanceToJs() {
        return mobx.toJS(this.balance)
    }

    // 计算盈利
    @computed
    get profit() {
        return this.payout === 0 ? 'N/A' : Number(this.payout * this.bet - this.bet).toFixed(8)
    }
    // 计算滚存值
    @computed
    get diceRoll() {
        if(!isFinite(this.chance)) {
            return '不适合';
        } else {
            return this.rollOver ? (99.99 - Number(this.chance)).toFixed(2) : Number(this.chance).toFixed(2)
        }
        
    }
    // 
    @computed
    get stakeCollectToJs() {
        return mobx.toJS(this.stakeCollect)
    }

    @computed
    get wordsToJs() {
        return mobx.toJS(this.words);
    }
    //  查询余额
    @action.bound
    queryBalance() {
        axios({
            method: 'post',
            url: '/rest/query/balance',
          })
            .then((response) => {
                if (response.data.code === 100) {
                    let data = response.data.data;
                    this.balance = data.balance;
                    this.ethGasLimit = data.ethGasLimit;
                    this.ethGasPrice = data.ethGasPrice;
                }
            })
    }
    //  验证是否有密码
    @action.bound
    verifyHasPassword() {
        axios({
            method: 'post',
            url: '/rest/query/password',
          })
            .then((response) => {
                if (response.data.code === 100) {
                    let data = response.data.data;
                    if(data.has === '1') {
                        this.hasPassword = true;
                    }
                }
            })
    }
    //  设置密码
    @action.bound
    setPassword(key1, key2) {
        
        key1 = key1.trim()
        key2 = key2.trim()
        if (!key1) {
            message.info(this.words.message.mmbnwk);
        } else {
            if (key1 === key2) {
                axios({
                    method: 'post',
                    url: '/rest/member/password',
                    params: {
                        password: key1
                    }
                  })
                    .then((response) => {
                        if (response.data.code === 100) {
                            message.info(this.words.message.mmszcg);
                            this.hasPassword = true;
                        } else if (response.data.code === 198){
                            message.info(this.words.message.mmbunxy);
                        }
                    })
            } else {
                message.info(this.words.message.lcmmbyz);
            }
        }
        
        
    }
    //  更改密码
    @action.bound
    updatePassword(key1,key2,key3) {
        key1 = key1.trim()
        key2 = key2.trim()
        key3 = key3.trim()
        if (!key3) { 
            message.info(this.words.message.jmmbnwk);
            return false;
        }
        if (!key1) {
            message.info(this.words.message.xmmbnwk);
            return false;
        }
        if (key1 === key2) {
            axios({
                method: 'post',
                url: '/rest/member/updatePassword',
                params: {
                    oldPassword: key3,
                    newPassword: key1
                }
              })
                .then((response) => {
                    if (response.data.code === 100) {
                        message.info(this.words.message.mmszcg);
                    } else{
                        message.info(this.words.message.jmmbzq);
                    }
                })
        } else {
            message.info(this.words.message.lcmmbyz);
        }
    }
    // 改变下注金额
    @action.bound
    changeBetNumber(bet) {
        const validBetNumber = this.getValidNumber(this.bet, bet, this.balance)
        this.bet = validBetNumber;
    }
    //  倍数按钮
    @action.bound
    changeBetBt(number) {
        let newValue;
        if (number === 'max') {
            newValue = Number(this.balance);
        } else {
            newValue = parseFloat(this.bet) * number;
        }
    
        if (Number(this.bet) === 0 && number === 2) {
            newValue = 1 / 1e8;
        }
    
        if (newValue > this.balance) {
            newValue = this.balance;
        }
        newValue = parseFloat(newValue).toFixed(8);
        if (this.bet === 1 / 1e8 && newValue === 1 / 1e8) {
            this.bet = (0).toFixed(8);
        } else {
            this.bet = parseFloat(newValue).toFixed(8);
        }
        
    }
    // 设置滚存
    @action.bound
    changeRollOver() {
        this.rollOver = !this.rollOver;
    }
    // 改变派彩
    @action.bound
    changePayout(value) {
        this.payout = value;
        this.calculateChance();
    }
    // 改变胜率
    @action.bound
    changeChance(value) {
        this.chance = value;
        this.calculatePayout();
    }
    //  计算胜率
    @action.bound
    calculateChance() {
        this.chance = (100 * (1 - this.houseEdge) / this.payout).toFixed(2)
    }
    
    //  计算派彩
    @action.bound
    calculatePayout() {
        
        const target = this.chance * 100;
    
        const result = Math.floor((10000 - this.houseEdge * 10000) / target * 10e4) / 10e4;
    
        this.payout =  String(result);
    }
    //  获取下注金额
    getValidNumber(oldNumber, newNumber, max = false, min = false) {
        max = parseFloat(max);
        newNumber = newNumber.replace(',', '.');
        const split = newNumber.indexOf(',') !== -1 ? newNumber.split(',') : newNumber.split('.');
        
        if (isNaN(newNumber)) return oldNumber;
        
        if (split.length < 3) {
            if (max) {
            if (newNumber > max) {
                return max.toFixed(8);
            }
            }
        
            if (min) {
            if (newNumber < min) {
                return min;
            }
            }
        
            if (typeof split[1] === 'undefined') {
            return newNumber;
            }
        
            if (split[1].length < 9) {
            // console.log(!isNaN(newNumber) ? newNumber : oldNumber)
            return newNumber;
            }
        }
        
        return oldNumber;
    };

    //  投掷
    @action.bound
    throwBet() {
        axios({
            method: 'post',
            url: '/rest/stake/make',
            params: {
                amt: this.bet,
                target: this.diceRoll,
                targetCondition: this.rollOver ? '1' : '0'
            }
          })
            .then((response) => {
                if (response.data.code === 100) {
                    //this.rootStore.dialogStore.setLoading(true);
                    
                    let data = response.data.data;
                    // 输
                    let balance, changeAmt;
                    if (data.fundType === 'FO') {
                        balance = Number(this.balance) - Number(data.changeAmt)
                        changeAmt = '-' + Number(data.changeAmt).toFixed(8);
                        this.fundType = false;
                    } else {
                        balance = Number(this.balance) + Number(data.changeAmt)
                        changeAmt = '+' + Number(data.changeAmt).toFixed(8);
                        this.fundType = true;
                    }
                    this.balance = balance.toFixed(8);
                    this.setMarks(data.randomResult);
                    this.setAmt(changeAmt)
                    this.getSakeCollect();
                    this.getAllStakes();
                    //this.balance = data.balance;
                }
            })
    }
    // 设置显示点数
    @action.bound
    setMarks(value) {
        this.showMark = true;
        clearTimeout(this.timeId1);
        setTimeout(()=>{
            this.marks = value;
            this.timeId1 = setTimeout(()=> {
                this.showMark = false;
            }, 6000)
        },0) 
    }
    @action.bound
    setAmt(value) {
        let that = this;
        that.showAmt = true;
        that.changeAmt = value;
        clearTimeout(this.timeId2);
        setTimeout(()=>{
            that.showAnim = true;
            that.timeId2 = setTimeout(()=> {
                that.showAmt = false;
                this.showAnim = false;
            }, 2000)
        },0) 
    }
    //  查询每日及历史投注数额
    @action.bound
    getSakeCollect() {
        axios({
            method: 'post',
            url: '/rest/query/stakeCollect'
        })
            .then((response) => {
                if (response.data.code === 100) {
                    let data = response.data.data;
                    let copyStakeCollect = this.stakeCollectToJs;
                    Object.assign(copyStakeCollect,data);
                    this.stakeCollect = copyStakeCollect;
                    //this.balance = data.balance;
                }
            })
    }
    // get初始化接口
    @action.bound
    init() {
        this.queryBalance();
        this.getSakeCollect();
        this.getAllStakes();
        setInterval(() => {
            this.getAllStakes();
        }, 5000)
        //this.createWebSocket();
    }
    // 获取下注列表
    @action.bound
    getStakes(type) {
        axios({
            method: 'post',
            url: '/rest/query/stakes',
            params: {
                page: 1,
                pageSize:10,
                queryType: type
            }
        })
            .then((response) => {
                if (response.data.code === 100) {
                    let data = response.data.data;
                    switch(type) {
                        case 0: 
                            this.myStakes = data;
                        break;
                        case 1: 
                            this.allStakes = data;
                        break;
                        case 2: 
                            this.highStakes = data;
                        break;
                        default:
                        break;
                    }
                    //this.balance = data.balance;
                }
            })
    }
    // 获取所有下注列表
    @action.bound
    getAllStakes() {
        this.getStakes(0);
        this.getStakes(1);
        this.getStakes(2);
    }
    
    // 切换语言
    @action.bound
    setLanguageCf(value) {
        this.language = value;
        this.words = languageCf[this.language];
    }
    
}