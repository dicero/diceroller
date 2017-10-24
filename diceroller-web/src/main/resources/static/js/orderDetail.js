$(function(){
	 $.validator.addMethod("customRegExp", function(value, element, param) {
	     return param.test(value);
	 })
	 
    $("#orderDetailForm").validate({
      rules: {
    	activityName: {
          required: true,
          maxlength:14
        },
        title: {
          required: true,
          maxlength:50
        },
        author: {
          maxlength:8
        },
        text: {
          required: true
        },
      },
      messages: {
    	activityName: {
          required: "请输入活动名称",
          maxlength: "活动名称不能超过14个字符"
        },
        title: {
          required: "请输入文章标题",
          maxlength: "文章标题不能超过50个字符"
        },
        author: {
        	maxlength: "作者不能超过8个字符"
        },
        text: {
          required: "请输入直发的内容"
        },
        directImgUrlFile:{
           accept: "请上传正确的图片格式"
        },
        coverImgUrlFile:{
           accept: "请上传正确的图片格式"
        }
      },
      submitHandler:function(form){
    	  form.submit();
      }
    });
	 
    $("#filePic").rules("add", {
        accept: "jpg|jpeg|png|gif"
    });
    
    $("#fileCover").rules("add", {
        accept: "jpg|jpeg|png|gif"
    });

})
