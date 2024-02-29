package com.example.authservice.mapper;

import com.example.authservice.dto.CommunicateInformationDto;
import com.example.authservice.dto.ProfileDto;
import com.example.authservice.dto.UserDto;
import com.example.authservice.entity.CommunicateInformation;
import com.example.authservice.entity.Profile;
import com.example.authservice.entity.User;
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
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDto toResource(User e) {
        if ( e == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.userId = e.getUserId();
        userDto.userName = e.getUserName();
        userDto.userLastName = e.getUserLastName();
        userDto.password = e.getPassword();
        userDto.mail = e.getMail();
        userDto.profile = profileToProfileDto( e.getProfile() );
        userDto.communicateInformation = communicateInformationToCommunicateInformationDto( e.getCommunicateInformation() );

        return userDto;
    }

    @Override
    public User toEntity(UserDto r) {
        if ( r == null ) {
            return null;
        }

        User user = new User();

        user.setUserId( r.userId );
        user.setUserName( r.userName );
        user.setUserLastName( r.userLastName );
        user.setMail( r.mail );
        user.setPassword( r.password );
        user.setProfile( profileDtoToProfile( r.profile ) );
        user.setCommunicateInformation( communicateInformationDtoToCommunicateInformation( r.communicateInformation ) );

        return user;
    }

    @Override
    public List<UserDto> toResourse(List<User> eList) {
        if ( eList == null ) {
            return null;
        }

        List<UserDto> list = new ArrayList<UserDto>( eList.size() );
        for ( User user : eList ) {
            list.add( toResource( user ) );
        }

        return list;
    }

    @Override
    public List<User> toEntity(List<UserDto> rList) {
        if ( rList == null ) {
            return null;
        }

        List<User> list = new ArrayList<User>( rList.size() );
        for ( UserDto userDto : rList ) {
            list.add( toEntity( userDto ) );
        }

        return list;
    }

    protected ProfileDto profileToProfileDto(Profile profile) {
        if ( profile == null ) {
            return null;
        }

        ProfileDto profileDto = new ProfileDto();

        profileDto.profileId = profile.getProfileId();

        return profileDto;
    }

    protected CommunicateInformationDto communicateInformationToCommunicateInformationDto(CommunicateInformation communicateInformation) {
        if ( communicateInformation == null ) {
            return null;
        }

        CommunicateInformationDto communicateInformationDto = new CommunicateInformationDto();

        communicateInformationDto.communicateInformationId = communicateInformation.getCommunicateInformationId();
        communicateInformationDto.adress = communicateInformation.getAdress();
        communicateInformationDto.telephonNumber = communicateInformation.getTelephonNumber();
        communicateInformationDto.birthDay = communicateInformation.getBirthDay();

        return communicateInformationDto;
    }

    protected Profile profileDtoToProfile(ProfileDto profileDto) {
        if ( profileDto == null ) {
            return null;
        }

        Profile profile = new Profile();

        profile.setProfileId( profileDto.profileId );

        return profile;
    }

    protected CommunicateInformation communicateInformationDtoToCommunicateInformation(CommunicateInformationDto communicateInformationDto) {
        if ( communicateInformationDto == null ) {
            return null;
        }

        CommunicateInformation communicateInformation = new CommunicateInformation();

        communicateInformation.setCommunicateInformationId( communicateInformationDto.communicateInformationId );
        communicateInformation.setAdress( communicateInformationDto.adress );
        communicateInformation.setTelephonNumber( communicateInformationDto.telephonNumber );
        communicateInformation.setBirthDay( communicateInformationDto.birthDay );

        return communicateInformation;
    }
}
