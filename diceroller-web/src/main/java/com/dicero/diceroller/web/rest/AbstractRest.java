package com.dicero.diceroller.web.rest;

import com.dicero.diceroller.common.bean.extension.CashControllerException;
import com.dicero.diceroller.common.bean.extension.CashIntegartionException;
import com.dicero.diceroller.common.bean.extension.CashServiceException;
import com.dicero.diceroller.common.bean.result.RestCode;
import com.dicero.diceroller.common.bean.result.RestResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p></p>
 *
 * @author znz
 * @version 2017/11/25
 */
@Slf4j
public class AbstractRest {

    boolean isMockMode = false;
    public static Timestamp now(){
        return new Timestamp(new Date().getTime());
    }

    // NOTE: 构建返回数据
    public class DataObject {
        private Map<String, Object> data;

        public DataObject() {
            this.data = new HashMap<String,Object>();
        }

        public Map<String,Object> put(String k, Object v){
            this.data.put(k, v);
            return data;
        }

        public Map<String, Object> getData() {
            return data;
        }
    }


    // REM  Rest 异常处理
    protected abstract class RestExecuteContrl {
        public RestResponse run() {
            String subMsg;
            RestCode.CodeMessage code;

            try {
                validate();
            } catch (Exception e) {
                subMsg = e.getMessage();
                code = RestCode.PARAMES_ERROR;
                return RestResponse.createFailure(code, subMsg);
            }

            try {

                if (!isMockMode) {
                    return process();
                } else {
                    RestResponse data = processByUserMockData();
                    if (data == null) {
                        return process();
                    } else {
                        return data;
                    }
                }

            } catch (Exception e) {
                if (e instanceof com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException || e instanceof org.springframework.dao.DuplicateKeyException) {
                    log.error("请不要重复提交", e);
                    subMsg = "重复请求";
                    code = RestCode.DUPLICATE_REQUEST_NO;

                } else if (e instanceof java.sql.SQLException || e.getCause() instanceof java.sql.SQLException) {
                    log.error("SQL 出错", e);
                    subMsg = "SQLException" + e.getMessage();
                    code = RestCode.FAILED;

                } else if (e instanceof CashControllerException || e instanceof CashServiceException || e instanceof CashIntegartionException) {
                    log.error("CommonDefinedException:", e);
                    subMsg = "CommonDefinedException:" + e.getMessage();
                    code = RestCode.FAILED;

                } else {
                    log.error("Exception:", e);
                    subMsg = "Exception:" + StringUtils.defaultIfBlank(e.getMessage(), "出现异常");
                    code = RestCode.FAILED;
                }
//                try {
//                    iEmail.sendErrorExceptionEmail("SDK 出现异常: " + subMsg + ", 异常详情: ", e);
//                } catch (Throwable throwable) {
//                    log.error("Throwable:", throwable);
//                }


            }

            return RestResponse.createFailure(code,  subMsg);
        }

        protected abstract void validate() throws Exception;

        protected abstract RestResponse process() throws Exception;

        protected RestResponse processByUserMockData() throws Exception {
            return null;
        }
    }
}
