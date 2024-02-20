package com.example.transfer.service;

import com.example.transfer.dto.TransferDto;
import com.example.transfer.mapper.TransferMapper;
import com.example.transfer.model.Transfer;
import com.example.transfer.repository.TransferRepository;
import com.example.transfer.response.BasketResponse;
import com.example.transfer.response.Meta;
import com.example.transfer.response.TransferResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TransferService {

    private final TransferRepository transferRepository;
    private final TransferMapper mapper;

    public TransferService(TransferRepository transferRepository, TransferMapper mapper) {
        this.transferRepository = transferRepository;
        this.mapper = mapper;
    }
    public TransferDto feedbackaboutcargo(TransferDto transferDto) {
        Transfer transfer=mapper.toEntity(transferDto);
        transfer=transferRepository.save(transfer);
        return mapper.toResource(transfer);
    }

    public TransferResponse feedback(TransferDto transferDto) {
        Meta meta=new Meta();
        TransferResponse transferResponse=new TransferResponse();
        meta.errorCode=200;
        transferResponse.meta=meta;
        BasketResponse basketResponse=sendRequestBasketId(transferDto.basketId);
        if (basketResponse.basket.status == 1){
            transferResponse.meta.errorCode=200;
            transferResponse.meta.errorDescription="Kargonuz yola çıkmıştır";
        }else {
            transferResponse.meta.errorCode=200;
            transferResponse.meta.errorDescription="Kargonuz gönderilemedi";
        }
        return transferResponse;

    }

    public BasketResponse sendRequestBasketId(int basketId) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("http://localhost:9120/basket/getBasket/" + basketId, BasketResponse.class);
    }
}
