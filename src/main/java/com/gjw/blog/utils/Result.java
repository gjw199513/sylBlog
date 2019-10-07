package com.gjw.blog.utils;

import java.io.Serializable;

/**
 * @author gjw19
 * @date 2019/10/6
 * 结果封装
 */
public class Result<T> implements Serializable {
    private static final long serialVersionUID = -1084485911309693591L;

    private int resultCode;
    private String message;
    private T data;

    public Result() {

    }

    public Result(int resultCode, String message) {
        this.resultCode = resultCode;
        this.message = message;
    }

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
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

    public Result failure(String code) {
        return new Result(500, "服务错误");
    }

    @Override
    public String toString() {
        return "Result{" +
                "resultCode=" + resultCode +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
