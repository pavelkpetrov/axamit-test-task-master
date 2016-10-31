package com.axamit.spring.dto;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.io.Serializable;

/**
 * Created by Pavel on 30.10.2016.
 */
public class ErrorResponse implements Serializable{
    private String message;
    private int code;

    public ErrorResponse(){
    }

    public ErrorResponse(String message, int code){
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String toString(){
        return ReflectionToStringBuilder.toString(this);
    }

}
