package com.example.transferservice.service.ımpl;

import com.example.transferservice.dto.TransferDto;
import com.example.transferservice.entity.Transfer;
import com.example.transferservice.exception.TransferException;
import com.example.transferservice.mapper.TransferMapper;
import com.example.transferservice.repository.TransferRepository;
import com.example.transferservice.response.BasketResponse;
import com.example.transferservice.response.Meta;
import com.example.transferservice.response.TransferResponse;
import com.example.transferservice.service.TransferService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TransferServiceImpl implements TransferService {

    private final TransferRepository transferRepository;

    public TransferServiceImpl(TransferRepository transferRepository) {
        this.transferRepository = transferRepository;
    }

    @Override
    public TransferResponse feedback(TransferDto transferDto) throws TransferException {
        BasketResponse basketResponse = sendRequestBasketId(transferDto.basketId);
        TransferResponse transferResponse = new TransferResponse();
        if (basketResponse.basket.status == 1) {

            transferResponse.meta = new Meta(200, "Kargonuz yola çıkmıştır");
        } else {
            throw new TransferException();
        }
        throw new TransferException();

    }

    public BasketResponse sendRequestBasketId(long basketId) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("http://localhost:7050/baskets/getBasket/" + basketId, BasketResponse.class);
    }

    public TransferDto feedbackaboutcargo(TransferDto transferDto) {
        Transfer transfer = TransferMapper.mapToEntity(transferDto);
        transfer = transferRepository.save(transfer);
        return TransferMapper.mapToDto(transfer);
    }
}
