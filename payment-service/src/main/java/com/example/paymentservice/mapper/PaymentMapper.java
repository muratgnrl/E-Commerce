package com.example.paymentservice.mapper;

import com.example.paymentservice.dto.PaymentDto;
import com.example.paymentservice.entity.Transaction;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface PaymentMapper extends IEntityMapper<PaymentDto, Transaction>{
}
