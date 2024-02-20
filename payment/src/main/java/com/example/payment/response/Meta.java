package com.example.payment.response;

import java.io.Serializable;

public class Meta extends BaseResponse implements Serializable {
    public int errorCode;
    public String errorDescription;
}
