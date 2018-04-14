package org.gd.sbc.electric.entity;

/**
 * @author yigang.wu
 * @date created in $time $date
 */
public class RestResponse<T> {
    private T t;

    private String errorCode;

    private String errorMsg;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
