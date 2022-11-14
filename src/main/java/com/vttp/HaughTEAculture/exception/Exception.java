package com.vttp.HaughTEAculture.exception;

import com.vttp.HaughTEAculture.error.ResultError;

public class Exception extends RuntimeException {

    private Integer code;
    
    public Exception(ResultError resultEnum) {
        super(resultEnum.getMessage());
    
        this.code = resultEnum.getCode();
    }
    
    public Exception(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
