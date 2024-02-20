package com.example.authservice.service.impl;


import com.example.authservice.dto.CommunicateInformationDto;
import com.example.authservice.exception.CommunicateInformationDeletedException;
import com.example.authservice.exception.CommunicateInformationNotCreateException;
import com.example.authservice.mapper.CommunicateInformationMapper;
import com.example.authservice.model.CommunicateInformation;
import com.example.authservice.model.User;
import com.example.authservice.repository.CommunicateInformationRepository;
import com.example.authservice.response.CommunicateInformationResponse;
import com.example.authservice.response.Meta;
import com.example.authservice.service.CommunicateInformationService;
import com.example.authservice.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CommunicateInformationServiceImpl implements CommunicateInformationService {

    private final CommunicateInformationRepository communicateInformationRepository;
    private final CommunicateInformationResponse response;
    private final CommunicateInformationMapper mapper;
    private final UserServiceImpl userService;
    private final Logger logger= LoggerFactory.getLogger(CommunicateInformationService.class);

    public CommunicateInformationServiceImpl(CommunicateInformationRepository communicateInformationRepository, CommunicateInformationResponse response, CommunicateInformationMapper mapper, UserServiceImpl userService) {
        this.communicateInformationRepository = communicateInformationRepository;
        this.response = response;
        this.mapper = mapper;
        this.userService = userService;
    }

    @Override
    public CommunicateInformationResponse addCommunicateInformation(CommunicateInformationDto dto) throws CommunicateInformationNotCreateException {

        CommunicateInformation communicateInformation = mapper.toEntity(dto);
        User user=userService.findUser(dto.getUserId());
        if (user==null){
            throw new CommunicateInformationNotCreateException();
        }else {
            response.meta=new Meta(200,"User contact information added");
        }

        communicateInformation.setUser(user);
        communicateInformation=communicateInformationRepository.save(communicateInformation);
        if (communicateInformation!=null){
            response.meta=new Meta(200,"Add contact information");
            response.communicateInformationDto=mapper.toResource(communicateInformation);
            logger.info("information added");
            return response;
        }else {
            throw new CommunicateInformationNotCreateException();


        }
    }

    @Override
    public CommunicateInformationResponse deleteCommnicateInformation(long id) throws CommunicateInformationDeletedException {
        CommunicateInformation communicateInformation = communicateInformationRepository.findCommunicateInformationById(id);
        if (communicateInformation!=null){
            communicateInformationRepository.deleteById(id);
            response.meta=new Meta(200,"contact information deleted" + " =  " + id);
            response.communicateInformationDto=mapper.toResource(communicateInformation);
            logger.info("Contact information deleted");
            return response;
        }
        throw new CommunicateInformationDeletedException();
    }
}
