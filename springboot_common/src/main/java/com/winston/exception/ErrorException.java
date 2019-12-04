package com.winston.exception;

import com.winston.result.CodeMsg;
import lombok.Data;

@Data
public class ErrorException extends RuntimeException {

    private CodeMsg codeMsg;
    private Integer status;
    private String msg;

    public ErrorException(Integer status, String msg){
        this.status= status;
        this.msg=msg;
        this.codeMsg.setStatus(status);
        this.codeMsg.setMsg(msg);
    }
    public ErrorException(String msg){
        this.status= 500;
        this.msg=msg;
        this.codeMsg.setStatus(500);
        this.codeMsg.setMsg(msg);
    }

    public ErrorException(CodeMsg codeMsg){
        this.status= codeMsg.getStatus();
        this.msg=codeMsg.getMsg();
        this.codeMsg = codeMsg;
    }
}
