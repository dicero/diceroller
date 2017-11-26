import mobx from "mobx";
import {observable, action, computed} from "mobx";
import axios from 'axios';
import { message } from 'antd';
export default class DialogStore {
    @observable userName = '';
    @observable loginVisible = true;

    @computed
    get userNameToJs() {
        return mobx.toJS(this.userName)
    }
    @action.bound
    isShowLogin() {
        axios.post('/rest/query/state')
        .then((response) => {
            if (response.data.code === 100) {
                this.userName = response.data.data.username;
                this.loginVisible = false;
            } else {
                this.loginVisible = true;
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
                let msg = '';
                switch(response.data.code) {
                    case 100:
                        message.info('登陆成功');
                        this.loginVisible = false;
                        this.userName = name;
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
}