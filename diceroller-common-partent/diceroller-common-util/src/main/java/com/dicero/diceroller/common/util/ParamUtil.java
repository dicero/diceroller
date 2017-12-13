package com.dicero.diceroller.common.util;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/**   
* <p></p>
* @author ningzong.zeng
*/
public class ParamUtil {
	/** 
	 * 方法名称:transMapToString 
	 * 传入参数:map 
	 * 返回值:String 形如 username=chenziwen&password=1234 
	*/  
	public static String getBodyParam(Map<String, String[]> map){  
	  StringBuffer sb = new StringBuffer();  
	  for(Iterator iterator = map.entrySet().iterator(); iterator.hasNext();) {  
		  Entry entry = (Entry) iterator.next();  
		  Object ok=entry.getKey();
	      Object ov=entry.getValue();
	      if(ov == null) {
	    	  sb.append(ok.toString()).append("=").append("null").append(iterator.hasNext() ? "&" : ""); 
	      } else if(ov instanceof String[]){
			  sb.append(ok.toString()).append( "=" ).append( 
			      ((String[])ov)[0]).append (iterator.hasNext() ? "&" : ""); 
		  } else {
              if (ok.toString().toLowerCase().contains("username".toLowerCase())
                      || ok.toString().toLowerCase().contains("password".toLowerCase())) {
                  sb.append(ok.toString()).append( "=" ).append("******").append(iterator.hasNext() ? "&" : "");
              } else {
                  sb.append(ok.toString()).append( "=" ).append(ov.toString()).append(iterator.hasNext() ? "&" : "");
              }
		  }
	  }  
	  return sb.toString();  
	} 
}
