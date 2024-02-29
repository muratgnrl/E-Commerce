package com.example.authservice.service.ımpl;

import com.example.authservice.dto.CommunicateInformationDto;
import com.example.authservice.entity.CommunicateInformation;
import com.example.authservice.entity.User;
import com.example.authservice.exception.CommunicateInformationNotCreateException;
import com.example.authservice.exception.CommunicateInformationNotDeleted;
import com.example.authservice.mapper.CommunicateInformationMapper;
import com.example.authservice.repository.CommunicateInformationRepository;
import com.example.authservice.response.CommunicateInformationResponse;
import com.example.authservice.response.Meta;
import com.example.authservice.service.CommunicateInformationService;
import org.springframework.stereotype.Service;

@Service
public class CommunicateInformationServiceImpl implements CommunicateInformationService {
    private final CommunicateInformationRepository communicateInformationRepository;
    private final CommunicateInformationMapper communicateInformationMapper;
    private final UserServiceImpl userService;

    public CommunicateInformationServiceImpl(CommunicateInformationRepository communicateInformationRepository, CommunicateInformationMapper communicateInformationMapper, UserServiceImpl userService) {
        this.communicateInformationRepository = communicateInformationRepository;
        this.communicateInformationMapper = communicateInformationMapper;
        this.userService = userService;
    }

    public CommunicateInformationResponse addCommunicateInformation(CommunicateInformationDto informationDto) throws CommunicateInformationNotCreateException {
        CommunicateInformation communicateInformation=communicateInformationMapper.toEntity(informationDto);
        User user=userService.findUser(informationDto.userId);
        communicateInformation.setUser(user);
        communicateInformation=communicateInformationRepository.save(communicateInformation);
        if (communicateInformation!=null){
            CommunicateInformationResponse communicateInformationResponse=new CommunicateInformationResponse();
            communicateInformationResponse.communicateInformationDto=communicateInformationMapper.toResource(communicateInformation);
            communicateInformationResponse.meta=new Meta(200,"İletişim bilgileri eklendi");
            return communicateInformationResponse;
        }else {
            throw new CommunicateInformationNotCreateException();
        }
    }

    @Override
    public CommunicateInformationResponse deleteCommunicateInformation(long communicateInformationId) throws CommunicateInformationNotDeleted {
        CommunicateInformation communicateInformation = communicateInformationRepository.findByCommunicateInformationId(communicateInformationId);
        if (communicateInformation !=null){
            CommunicateInformationResponse response = new CommunicateInformationResponse();
            communicateInformationRepository.deleteByCommunicateInformationId(communicateInformationId);
            response.communicateInformationDto=communicateInformationMapper.toResource(communicateInformation);
            return response;
        }else {

            throw new CommunicateInformationNotDeleted();

        }
    }
}
