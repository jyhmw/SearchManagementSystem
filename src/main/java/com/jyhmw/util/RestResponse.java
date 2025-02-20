package com.jyhmw.util;

import java.io.Serializable;

public class RestResponse<T> implements Serializable {
    private boolean success; // 操作是否成功
    private int code;        // 状态码
    private String message;  // 返回消息
    private T data;          // 返回数据
    public RestResponse() {}
    public RestResponse(boolean success, int code, String message, T data) {
        this.success = success;
        this.code = code;
        this.message = message;
        this.data = data;
    }
    // Getter 和 Setter
    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
