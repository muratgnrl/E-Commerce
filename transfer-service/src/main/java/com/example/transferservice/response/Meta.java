package com.example.transferservice.response;

import java.io.Serializable;

public class Meta extends BaseResponse implements Serializable {
    public int errorCode;
    public String errorDescriptions;


    public Meta(int errorCode, String errorDescriptions) {
        this.errorCode = errorCode;
        this.errorDescriptions = errorDescriptions;
    }

    public Meta() {
    }
}
