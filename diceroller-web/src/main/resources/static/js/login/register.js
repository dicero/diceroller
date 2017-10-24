/**
 * @description: 注册模块;
 * @author: yhm;
 * @creat date: 2016-07-02;
 * @modify date: 2016-07-02;
 */

var Register = new function() {
  var registerUrl = "/submitRegister", //注册;
      getCaptchaUrl = "",    //获取图片验证码;
      getMobileCodeUrl = "/getSmCode"; //获取手机验证码;

  //获取用户注册信息;
  this._getUserInfo = function() {
    var pData = turnToJsonData($("#userInfoF").serializeArray());

    return pData;
  };

  //用户信息校验;
  this._init = function(userInfo) {
    $.validator.addMethod("customRegExp", function(value, element, param) {
      return param.test(value);
    }, "required");

    $.validator.addMethod("requiredIfOtherIsNull", function(value, element, param) {
      return $.trim($(param).val()) || $.trim(value);
    }, "required");

    $.validator.addMethod("checkWhenKeyExists", function(value, element) {
      if($.trim(value)){
        switch ($.trim(element.id)){
          case 'uQQNum':
          if($.trim(value).match(/^[1-9]([0-9]{4,10})$/)){
            console.log("helo")
            return true;
          }else{
            return false;
          }
          case 'uWechatAccount':
          if($.trim(value).match(/^[a-zA-Z][a-zA-Z0-9_\-]{5,19}$/)){
            return true;
          }else{
            return false;
          }
        }
        return true;
      }else {
        return true;
      }
    }, "required");


    $("#userInfoF").validate({
      debug:true,
      rules: {
        userName: {
          required: true,
          customRegExp: /^[a-zA-Z][0-9a-zA-Z_]{3,21}$/
        },
        password: {
          required: true,
          customRegExp: /^(?![a-zA-Z]+$)(?!\d+$)[a-zA-Z0-9]{6,22}$/
        },
        passwordAgain: {
          required: true,
          equalTo: "#uPassword"
        },
//        qq: {
//          requiredIfOtherIsNull: "#uQQNum",
//          checkWhenKeyExists:true
//        },
//        wechat: {
//          requiredIfOtherIsNull: "#uQQNum",
//          checkWhenKeyExists:true
//        },
        mobile: {
          required: true,
          customRegExp: /^1[3|4|5|7|8]\d{9}$/
        },
        authcode: {
          required: true
        },
        mobileCode: {
          required: true
        },
        agree: {
        	required: true
        }
      },
      messages: {
        userName: {
          required: "用户名不能为空",
          customRegExp: "4-22位字母、数字或下划线组合，首字符必须为字母"
        },
        password: {
          required: "密码不能为空",
          customRegExp: "密码由6-22位字母和数字组成，字母区分大小写"
        },
        passwordAgain: {
          required: "请再次输入密码",
          equalTo: "两次密码输入不一致"
        },
//        qq: {
//          requiredIfOtherIsNull: "QQ和微信请至少填写一个",
//          checkWhenKeyExists: "请填写正确的QQ号码"
//        },
//        wechat: {
//          requiredIfOtherIsNull: "QQ和微信请至少填写一个",
//          checkWhenKeyExists: "请填写正确的微信"
//        },
        mobile: {
          required: "手机号码不能为空",
          customRegExp: "请填写正确的手机号码"
        },
        authcode: "验证码不能为空",
        mobileCode: "手机验证码不能为空",
        agree: '请同意我们的条款'
      },
      focusInvalid: false,
      onkeyup: false,
      submitHandler:function(form){
    	  Register._register();
          
      }
    });
  };

  //注册;
  this._register = function() {

    var pData = this._getUserInfo();

    //向后台发送注册请求;
    new Ajax()._post(registerUrl, pData).success(function(data) {
    	if(data.success){
      	  window.location.href = "/registerSuc";
        }else{
      	  alert(data.msg);
        }
    });
  };

  //重新获取图片验证码;
  this._reloadCaptcha = function() {
    // Ajax._get(getCaptchaUrl).success(function(data) {
    //   if(data.success){
    //     $("#captchaImg").attr("src", data.src);
    //   }
    //});
    console.log("Reloading Captcha!")
  };
  
  //获取手机验证码;
  this._getMobileCode = function() {
    console.log("Getting mobile code!");
    var pData = {
      "mobile": $("#uMobile").val()
    };
    // Ajax._post(getMobileCodeUrl, pData).success(function(data) {
    //   if(data.success) {

    //   }
    // });
  };
  
  this._showAgreement = function() {
    $(".mask").show();
    $(".user-agreement").show();
  };
  
  this._hideAgreement = function() {
    $(".mask").hide();
    $(".user-agreement").hide();
  };
};

!(function() {
  Register._init();

  //重新获取验证码;
  $("#changeCaptcha").click(function() {
    Register._reloadCaptcha();
  });

  //获取手机验证码;
  $("#getMobileCode").click(function() {
    var time = 60,
        getCodeBtn = $(this);

    if(!getCodeBtn.hasClass("disabled")) {
      getCodeBtn.addClass("disabled").text("倒计时(60s)");

      var t = setInterval(function(){
        time--;
        var text = "倒计时(" + time + "s)";
        console.log(time)
        getCodeBtn.text(text);
        if(time == 0) {
          clearInterval(t);
          getCodeBtn.removeClass("disabled").text("重发验证码");
        }
      }, 1000);
      Register._getMobileCode();
    }
  });
  
  //显示用户协议;
  $("#userAgreement").click(function(){
    Register._showAgreement();
  });
  
  //隐藏用户协议;
  $("#closeAgree").click(function() {
    Register._hideAgreement();
  });
})();
