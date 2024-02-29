package com.example.transferservice.dto;

import java.io.Serializable;

public class TransferDto implements Serializable {
    public long transferId;
    public String transferDesc;
    public long basketId;
    public boolean status;
}
