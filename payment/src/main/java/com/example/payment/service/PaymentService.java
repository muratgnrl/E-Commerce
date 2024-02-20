package com.example.payment.service;

import com.example.payment.dto.BasketDto;
import com.example.payment.dto.DoPayDto;
import com.example.payment.dto.PaymentDto;
import com.example.payment.mapper.PaymentMapper;
import com.example.payment.model.Transaction;
import com.example.payment.repository.PaymentRepository;
import com.example.payment.response.BasketResponse;
import com.example.payment.response.Meta;
import com.example.payment.response.PaymentResponse;
import com.example.payment.response.TransferResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PaymentService {
    private final PaymentRepository paymentRepository;
    private final PaymentMapper paymentMapper;

    public PaymentService(PaymentRepository paymentRepository, PaymentMapper paymentMapper) {
        this.paymentRepository = paymentRepository;
        this.paymentMapper = paymentMapper;
    }

    public BasketResponse sendRequestBasketService(int basketId) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("http://localhost:9120/basket/getBasket/" + basketId, BasketResponse.class);
    }

    public BasketResponse sendRequestUpdateBasket(BasketDto basketDto) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("http://localhost:9120/basket/updateBasket" + basketDto, BasketResponse.class);
    }

    public TransferResponse sendRequestTransferService(int basketId) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("http://localhost:9116/transfer/feedBack" + basketId, TransferResponse.class);
    }


    public PaymentResponse doPay(DoPayDto doPay) {
        Meta meta = new Meta();
        PaymentResponse paymentResponse = new PaymentResponse();
        paymentResponse.meta = meta;
        BasketResponse result = sendRequestBasketService(doPay.basketId);

        if (doPay.success) {
            result.basketDto.status=1;
            //TODO basket ms updateBasketi buraya çağır.
            BasketResponse basketResponse = sendRequestUpdateBasket(result.basketDto);
            if (basketResponse.meta.errorCode != 200) {
                paymentResponse.meta.errorCode = 4000;
                paymentResponse.meta.errorDescription = "Sepet güncellenemediği için ödemeye devam edilemedi.";
            }  else {
            TransferResponse transferResponse1 = sendRequestTransferService(result.basketDto.basketId);


            if (transferResponse1.meta.errorCode == 200) {
                paymentResponse.meta.errorCode = 200;
                paymentResponse.meta.errorDescription = "Başarılı.";
            } else {
                paymentResponse.meta.errorCode = 4001;
                paymentResponse.meta.errorDescription = "Kargo verilemedi.";
                result.basketDto.status = 0;
                BasketResponse basketResponse1 = sendRequestUpdateBasket(result.basketDto);
            }
        }

    } else {
        paymentResponse.meta.errorCode = 5001;
        paymentResponse.meta.errorDescription = "Ödeme alınamadığı için işleme devam edilemedi.";
        //TODO başarsız senaryoyu calıstır. basketi güncelleme
    }
        return paymentResponse;
}






}
