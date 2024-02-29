package com.example.authservice.mapper;

import com.example.authservice.dto.CommunicateInformationDto;
import com.example.authservice.entity.CommunicateInformation;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-24T23:05:18+0300",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class CommunicateInformationMapperImpl implements CommunicateInformationMapper {

    @Override
    public CommunicateInformationDto toResource(CommunicateInformation e) {
        if ( e == null ) {
            return null;
        }

        CommunicateInformationDto communicateInformationDto = new CommunicateInformationDto();

        communicateInformationDto.communicateInformationId = e.getCommunicateInformationId();
        communicateInformationDto.adress = e.getAdress();
        communicateInformationDto.telephonNumber = e.getTelephonNumber();
        communicateInformationDto.birthDay = e.getBirthDay();

        return communicateInformationDto;
    }

    @Override
    public CommunicateInformation toEntity(CommunicateInformationDto r) {
        if ( r == null ) {
            return null;
        }

        CommunicateInformation communicateInformation = new CommunicateInformation();

        communicateInformation.setCommunicateInformationId( r.communicateInformationId );
        communicateInformation.setAdress( r.adress );
        communicateInformation.setTelephonNumber( r.telephonNumber );
        communicateInformation.setBirthDay( r.birthDay );

        return communicateInformation;
    }

    @Override
    public List<CommunicateInformationDto> toResourse(List<CommunicateInformation> eList) {
        if ( eList == null ) {
            return null;
        }

        List<CommunicateInformationDto> list = new ArrayList<CommunicateInformationDto>( eList.size() );
        for ( CommunicateInformation communicateInformation : eList ) {
            list.add( toResource( communicateInformation ) );
        }

        return list;
    }

    @Override
    public List<CommunicateInformation> toEntity(List<CommunicateInformationDto> rList) {
        if ( rList == null ) {
            return null;
        }

        List<CommunicateInformation> list = new ArrayList<CommunicateInformation>( rList.size() );
        for ( CommunicateInformationDto communicateInformationDto : rList ) {
            list.add( toEntity( communicateInformationDto ) );
        }

        return list;
    }
}
