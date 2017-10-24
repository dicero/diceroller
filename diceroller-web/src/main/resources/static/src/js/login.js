/**
 * @description: 登录模块;
 * @author: yhm;
 * @creat date: 2016-06-21;
 * @modify date: 2016-06-30;
 */

var Login = {
  userInfo: {
    "userName": "",
    "password": ""
  },

  _getUserInfo: function() {
    var userName = $("#userName").val();
    var password = $("#password").val();
    var userInfo = {
      "userName": userName,
      "password": password
    }

    return userInfo;
  },

  _checkUserInfo: function() {
    this.userInfo = this._getUserInfo();

    if(!this.userInfo.userName) {
      alert("请输入帐号！");

      return false;
    } else if(this.userInfo.userName.indexOf(" ") > 0) {
      alert("帐号不能有空格！");

      return false;
    } else if(!this.userInfo.password) {
      alert("请输入密码！");

      return false;
    }

    return true;
  },

  _login: function() {
    if(this._checkUserInfo()){
      alert("Login!");
    }
  }
};

$("#login").click(function(){
  Login._login();
});