package com.example.transferservice.mapper;

import com.example.transferservice.dto.TransferDto;
import com.example.transferservice.entity.Transfer;

public class TransferMapper {


    public static Transfer mapToEntity(TransferDto transferDto){
        Transfer transfer =new Transfer();
        transfer.setTransferId(transferDto.transferId);
        transfer.setTransferDesc(transferDto.transferDesc);
        transfer.setBasketId(transferDto.basketId);
        transfer.setStatus(transferDto.status);
        return transfer;
    }

    public static TransferDto mapToDto(Transfer transfer){
        TransferDto transferDto =new TransferDto();
        transferDto.transferId=transfer.getTransferId();
        transferDto.transferDesc=transfer.getTransferDesc();
        transferDto.basketId=transfer.getBasketId();
        transferDto.status=transfer.isStatus();
        return transferDto;
    }
}
