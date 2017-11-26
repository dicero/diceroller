import mobx from "mobx";
import {observable, action, computed} from "mobx";
import axios from 'axios';
import { message } from 'antd';
export default class AppStore {

    @observable name = 'qwe';

    @observable balance =  0;
    
    @observable hasPassword = false;

    @computed
    get hasPasswordToJs() {
        return mobx.toJS(this.hasPassword)
    }
    @computed
    get balanceToJs() {
        return mobx.toJS(this.balance)
    }
    @action.bound
    //  查询余额
    queryBalance() {
        axios({
            method: 'post',
            url: '/rest/query/balance',
          })
            .then((response) => {
                if (response.data.code === 100) {
                    let data = response.data.data;
                    this.balance = data.balance;
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
            message.info('密码不能为空');
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
                            message.info('密码设置成功');
                            this.hasPassword = true;
                        } else if (response.data.code === 198){
                            message.info('密码不能少于10个字符串');
                        }
                    })
            } else {
                message.info('两次密码不一致');
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
            message.info('旧密码不能为空');
            return false;
        }
        if (!key1) {
            message.info('新密码不能为空');
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
                        message.info('密码设置成功');
                    } else{
                        message.info('旧密码不正确');
                    }
                })
        } else {
            message.info('两次密码不一致');
        }

    }
}