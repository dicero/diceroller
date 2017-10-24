$(function(){
	 $.validator.addMethod("customRegExp", function(value, element, param) {
	     return param.test(value);
	 })
	 
    $("#mySpreadForm").validate({
      //debug:false,
      rules: {
        text: {
          required: true
        },
        contact: {
          required: true,
        },
        phone: {
          required: true,
          customRegExp: /^1[3|4|5|7|8]\d{9}$/
        },
        price: {
          required: true,
          number:true
        },
      },
      messages: {
        text: {
          required: "请输入您的详细需求"
        },
        contact: {
          required: "请输入联系人的名字"
        },
        phone: {
          required: "请输入联系人的手机号码",
          customRegExp: "请输入正确的手机号"
        },
        price: {
          required: "请输入您的参考价格",
          number: "参考价格只能由数字或小数点组成"
        }
      },
      submitHandler:function(form){
        alert("发布成功");
        form.submit();
      }
    });

})
