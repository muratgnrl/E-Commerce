package com.example.paymentservice.service.ımpl;

import com.example.paymentservice.dto.BasketDto;
import com.example.paymentservice.dto.DoPayDto;
import com.example.paymentservice.mapper.PaymentMapper;
import com.example.paymentservice.repository.PaymentRepository;
import com.example.paymentservice.response.*;
import com.example.paymentservice.service.PaymentService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentMapper paymentMapper;
    private final PaymentRepository paymentRepository;

    public PaymentServiceImpl(PaymentMapper paymentMapper, PaymentRepository paymentRepository) {
        this.paymentMapper = paymentMapper;
        this.paymentRepository = paymentRepository;
    }
    public BasketResponse sendRequestBasketService(long basketId){
        RestTemplate restTemplate=new RestTemplate();
        return restTemplate.getForObject("http://localhost:7050/baskets/getBasket/"+basketId,BasketResponse.class);
    }

    public BasketResponse sendRequestUpdateBasket(BasketDto basketDto){
        RestTemplate restTemplate=new RestTemplate();
        return restTemplate.getForObject("http://localhost:7050/baskets/updateBasket"+basketDto,BasketResponse.class);
    }

    public TransferResponse sendRequestTransferService(long basketId){
        RestTemplate restTemplate=new RestTemplate();
        return restTemplate.getForObject("http://localhost:6060/transfer/feedBack"+ basketId ,TransferResponse.class);
    }

    @Override
    public PaymentResponse doPay(DoPayDto doPayDto) {

        Meta meta=new Meta();
        PaymentResponse paymentResponse =new PaymentResponse();


        meta.errorCode=200;
        paymentResponse.meta =new Meta();

        BaseResponse result = sendRequestBasketService(doPayDto.basketId);
        if (doPayDto.success){
            result.status=1;

            BasketResponse basketResponse =sendRequestUpdateBasket(result.basket);

        if (basketResponse.meta.errorCode != 200) {
            paymentResponse.meta.errorCode = 4000;
            paymentResponse.meta.errorDescription = "Sepet güncellenemediği için ödemeye devam edilemedi.";
        }else {
            TransferResponse transferResponse = sendRequestTransferService(result.basket.basketId);
            if (transferResponse.meta.errorCode == 200){

                paymentResponse.meta.errorCode = 200;
                paymentResponse.meta.errorDescription = "Başarılı.";
            }else {
                paymentResponse.meta.errorCode = 4001;
                paymentResponse.meta.errorDescription = "Kargo verilemedi.";
                result.basket.status = 0;
                BasketResponse basketResponse1 = sendRequestUpdateBasket(result.basket);
            }
        }
        }else {
            paymentResponse.meta.errorCode = 5001;
            paymentResponse.meta.errorDescription = "Ödeme alınamadığı için işleme devam edilemedi.";
        }
        return paymentResponse;
    }



}
