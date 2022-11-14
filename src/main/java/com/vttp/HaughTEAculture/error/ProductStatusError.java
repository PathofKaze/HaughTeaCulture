package com.vttp.HaughTEAculture.error;
import lombok.Getter;

@Getter
public enum ProductStatusError implements CodeError{
    UP(0, "Available"),
    DOWN(1, "Unavailable")
    ;
    private Integer code;
    private String message;

    ProductStatusError(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getStatus(Integer code) {

        for(ProductStatusError statusError : ProductStatusError.values()) {
            if(statusError.getCode() == code) return statusError.getMessage();
        }
        return "";
    }

    public Integer getCode() {
        return code;
    }
}
