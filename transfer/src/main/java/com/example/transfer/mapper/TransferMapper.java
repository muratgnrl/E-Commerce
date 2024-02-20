package com.example.transfer.mapper;

import com.example.transfer.dto.TransferDto;
import com.example.transfer.model.Transfer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TransferMapper extends IEntityMapper<TransferDto, Transfer>{
}
