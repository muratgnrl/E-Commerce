package com.example.payment.mapper;

import com.example.payment.dto.PaymentDto;
import com.example.payment.model.Transaction;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaymentMapper extends IEntityMapper<PaymentDto, Transaction>{
}
