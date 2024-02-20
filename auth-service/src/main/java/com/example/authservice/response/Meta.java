package com.example.authservice.response;

import java.io.Serializable;

public class Meta extends BaseResponse implements Serializable {

    public int errorCode;
    public String errorDescription;

    public Meta(int errorCode, String errorDescription) {
        this.errorCode = errorCode;
        this.errorDescription = errorDescription;
    }

    public Meta() {
    }
}
