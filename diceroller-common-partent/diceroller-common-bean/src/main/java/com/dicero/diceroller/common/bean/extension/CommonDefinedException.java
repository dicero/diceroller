package com.dicero.diceroller.common.bean.extension;

/**
* <p></p>
* @author ningzong.zeng
*/
public class CommonDefinedException {
	// ------------------------------------------------------
	// ------------------ service Exception -----------------
	public static CommonException SYSTEM_ERROR(String message){
		 return new CashServiceException("系统内部错误[" + message + "]");
	}
	public static CommonException SYSTEM_NO_SUCH_SERVICE(String message){
		 return new CashServiceException("系统不存在这样的服务[" + message + "]");
	}
	public static CommonException SYSTEM_NO_QUERY_ERROR(String message){
		 return new CashServiceException("查询失败[" + message + "]");
	}
	public static CommonException SYSTEM_MQ_ERROR(String message){
		 return new CashServiceException("队列异常[" + message + "]");
	}
    public static CommonException SYSTEM_WITNESS_SERVICE_ERROR(String message){
        return new CashServiceException("见证服务异常[" + message + "]");
    }
	public static CommonException SYSTEM_NOT_OPEN_SERVICE(){
		 return new CashServiceException("服务不开放[]");
	}
	public static CommonException SYSTEM_NOT_OPEN_SERVICE(String message){
		 return new CashServiceException(message);
	}
	
	// ------------------------------------------------------
	// ------------------ integartion Exception --------------
	public static CommonException INTEGARTION_ERROR(String message){
		 return new CashIntegartionException("外部服务错误[" + message + "]");
	}
	
	public static CommonException INTEGARTION_PARAMS_ERROR(String message){
		 return new CashIntegartionException("外部服务参数错误[" + message + "]");
	}
	
	// ------------------------------------------------------
	// ------------------ controller Exception --------------
	public static CommonException ILLEGAL_USER_ACCOUNT_NOT_EXIST(String message){
		 return new CashControllerException("用户账号不存在[" + message + "]");
	}
	public static CommonException ILLEGAL_MEMBER_ID_NOT_EXIST(){
		 return ILLEGAL_MEMBER_ID_NOT_EXIST("");
	}
	public static CommonException ILLEGAL_MEMBER_ID_NOT_EXIST(String message){
		 return new CashControllerException("用户不存在[" + message + "]");
	}
	public static CommonException ILLEGAL_PARTNER_ID_NOT_EXIST(String message){
		 return new CashControllerException("合作方Id不存在[" + message + "]");
	}
	public static CommonException ILLEGAL_DUPLICATE_REQUEST_NO(String message){
		 return new CashControllerException("重复的请求号[" + message + "]");
	}
	public static CommonException ILLEGAL_REQUIRED_FIELD_NOT_EXIST(String message){
		 return new CashControllerException("必填字段未填写[" + message + "]");
	}
	public static CommonException ILLEGAL_FIELD_LENGTH_EXCEEDS_LIMIT(String message){
		 return new CashControllerException("字段长度超过限制[" + message + "]");
	}
	public static CommonException ILLEGAL_FIELD_TYPE_ERROR(String message){
		 return new CashControllerException("字段类型错误[" + message + "]");
	}
	public static CommonException ILLEGAL_PARAMES_ERROR(String message){
		 return new CashControllerException("提交参数错误[" + message + "]");
	}
	public static CommonException ILLEGAL_OUTER_TRADE_NO(String message){
		 return new CashControllerException("交易订单号不存在[" + message + "]");
	}
	public static CommonException ILLEGAL_SIGN_TYPE(String message){
		 return new CashControllerException("签名类型不正确[" + message + "]");
	}
	public static CommonException ILLEGAL_SIGN(String message){
		 return new CashControllerException("验签未通过[" + message + "]");
	}
	public static CommonException ILLEGAL_ARGUMENT(String message){
		 return new CashControllerException("参数校验未通过[" + message + "]");
	}
	public static CommonException ILLEGAL_SERVICE(String message){
		 return new CashControllerException("服务接口不存在[" + message + "]");
	}
	public static CommonException ILLEGAL_SERVICE_UPDATE(String message){
		 return new CashControllerException(message);
	}
	public static CommonException ILLEGAL_SERVICE_UPDATE(){
		 return new CashControllerException("服务接口升级维护中[]");
	}
	public static CommonException ILLEGAL_ID_TYPE(String message){
		 return new CashControllerException("ID类型不支持[" + message + "]");
	}

}
