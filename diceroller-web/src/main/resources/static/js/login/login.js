/**
 * @description: 登录模块;
 * @author: yhm;
 * @creat date: 2016-06-21;
 * @modify date: 2016-06-30;
 */

var Login = {
  userInfo: {
    "userName": "",
    "password": "",
    "imageCode": ""   //图形验证码
  },

  _getUserInfo: function() {
    var userName = $("#userName").val();
    var password = $("#password").val();
    var imageCode = $("#imageCode").val();
    var userInfo = {
      "userName": userName,
      "password": password,
      "imageCode": imageCode
    }

    return userInfo;
  },
  _reloadCaptcha: function(){
    console.log("hello");
    $("#captchaPic").attr("src", "/imageCode?" + Math.random());
  },
  
  _checkUserInfo: function() {
    this.userInfo = this._getUserInfo();
    var error_D = $(".error-prompt");

    if(!this.userInfo.userName) {
      error_D.html("请输入帐号！");

      return false;
    } else if(this.userInfo.userName.indexOf(" ") > 0) {
      error_D.html("帐号不能有空格！");

      return false;
    } else if(!this.userInfo.password) {
      error_D.html("请输入密码！");

      return false;
    } else if (!this.userInfo.imageCode){
      error_D.html("请输入验证码！");

      return false;
    }

    return true;
  },

  _login: function() {
    if(this._checkUserInfo()){
        var pData = turnToJsonData($("#loginBox").serializeArray());
        console.log(pData);
        //向后台发送注册请求;
        new Ajax()._post("/submitLogin", pData).success(function(data) {
          if(data.success){
        	  window.location.href = "/";
          }else{
        	  $(".error-prompt").text(data.msg);
          }
          
        })
    }
  },
  
  _clearError: function() {
	var error_D = $(".error-prompt");
	if(error_D.html()) {
		error_D.html("");
	}
  }
};

!(function(){
  $("#login").click(function(){
    Login._login();
  });
  
  var minHeight = window.innerHeight - 311;
  $(".main").css("minHeight", minHeight > 405 ? minHeight : 405);
})();
