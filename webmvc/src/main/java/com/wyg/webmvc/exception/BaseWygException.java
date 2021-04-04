package com.wyg.webmvc.exception;

import lombok.Data;

@Data
public class BaseWygException extends RuntimeException {

    /**
     * 错误码
     */
    private int errorCode;
    /**
     * 错误信息
     */
    private String errorMsg;

    public BaseWygException() {
        super();
    }
    public BaseWygException(BaseErrorInfoInterface errorInfo) {
        super(errorInfo.getResultMsg());
        this.errorCode = errorInfo.getResultCode();
        this.errorMsg = errorInfo.getResultMsg();
    }
    public BaseWygException(BaseErrorInfoInterface errorInfo, Throwable cause) {
        super(errorInfo.getResultMsg(), cause);
        this.errorCode = errorInfo.getResultCode();
        this.errorMsg = errorInfo.getResultMsg();
    }
    public BaseWygException(String errorMsg) {
        this.errorMsg = errorMsg;
    }
    public BaseWygException(int errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }
    public BaseWygException(int errorCode, String errorMsg, Throwable cause) {
        super(errorMsg, cause);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
