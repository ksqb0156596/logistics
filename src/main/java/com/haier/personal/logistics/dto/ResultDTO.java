package com.haier.personal.logistics.dto;

import com.haier.personal.logistics.util.MessageEnum;

public class ResultDTO<T> {
    private String code;
    private String message;
    private T result;

    public ResultDTO(){}

    public ResultDTO(String code){
        this.code = code;
    }

    public ResultDTO(String code, String message){
        this.code = code;
        this.message = message;
    }

    public ResultDTO(String code, String message, T result){
        this.code = code;
        this.message = message;
        this.result = result;
    }

    public ResultDTO(MessageEnum errorMessageEnum){
        this.code = errorMessageEnum.getCode();
        this.message = errorMessageEnum.getMessage();
    }

    public ResultDTO(MessageEnum errorMessageEnum, T result){
        this.code = errorMessageEnum.getCode();
        this.message = errorMessageEnum.getMessage();
        this.result = result;
    }

    @Override
    public String toString() {
        return "ResultDTO{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", result=" + result +
                '}';
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
