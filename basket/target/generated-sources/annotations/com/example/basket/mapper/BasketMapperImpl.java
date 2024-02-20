package com.example.basket.mapper;

import com.example.basket.dto.BasketDto;
import com.example.basket.model.Basket;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-19T14:17:11+0300",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class BasketMapperImpl implements BasketMapper {

    @Override
    public Basket toResource(BasketDto e) {
        if ( e == null ) {
            return null;
        }

        Basket basket = new Basket();

        basket.setBasketId( e.basketId );
        basket.setTotalAmount( e.totalAmount );
        basket.setStatus( e.status );
        basket.setUserId( e.userId );

        return basket;
    }

    @Override
    public BasketDto toEntity(Basket r) {
        if ( r == null ) {
            return null;
        }

        BasketDto basketDto = new BasketDto();

        basketDto.basketId = r.getBasketId();
        basketDto.totalAmount = r.getTotalAmount();
        basketDto.userId = r.getUserId();
        basketDto.status = r.getStatus();

        return basketDto;
    }

    @Override
    public List<Basket> toResourse(List<BasketDto> eList) {
        if ( eList == null ) {
            return null;
        }

        List<Basket> list = new ArrayList<Basket>( eList.size() );
        for ( BasketDto basketDto : eList ) {
            list.add( toResource( basketDto ) );
        }

        return list;
    }

    @Override
    public List<BasketDto> toEntity(List<Basket> rList) {
        if ( rList == null ) {
            return null;
        }

        List<BasketDto> list = new ArrayList<BasketDto>( rList.size() );
        for ( Basket basket : rList ) {
            list.add( toEntity( basket ) );
        }

        return list;
    }
}
