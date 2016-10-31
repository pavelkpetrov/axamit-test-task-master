package com.axamit.spring.exceptions;

/**
 * Created by Pavel on 30.10.2016.
 */
public class StringsException extends Exception {

    public final static int CODE_INVALID_STRINGS = 1;
    
    private int code;

    public StringsException(String message, int code){
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
