package com.example.paymentservice.dto;

import java.io.Serializable;

public class BasketDto  implements Serializable {
    public long basketId;
    public String basketPrice;
    public String count;
    public int status;
}
