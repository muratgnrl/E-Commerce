package com.example.authservice.service.ımpl;

import com.example.authservice.dto.CommunicateInformationDto;
import com.example.authservice.dto.UserDto;
import com.example.authservice.entity.CommunicateInformation;
import com.example.authservice.entity.User;
import com.example.authservice.exception.UserNotCreateException;
import com.example.authservice.exception.UserNotDeletedException;
import com.example.authservice.exception.UserNotFoundException;
import com.example.authservice.exception.UserNotLoginException;
import com.example.authservice.mapper.UserMapper;
import com.example.authservice.repository.UserRepository;
import com.example.authservice.response.BasketResponse;
import com.example.authservice.response.Meta;
import com.example.authservice.response.UserResponse;
import com.example.authservice.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }
    public BasketResponse takeAllActiveBasket(int basketId){
        RestTemplate restTemplate=new RestTemplate();
        return restTemplate.getForObject("http://localhost:7050/baskets/getBasket/{{basketId}}"+basketId, BasketResponse.class);
    }

    @Override
    public UserResponse addUser(UserDto userDto) throws UserNotCreateException {
        User user=userMapper.toEntity(userDto);
        user=userRepository.save(user);
        if (user!=null){
            UserResponse userResponse=new UserResponse();
            userResponse.meta=new Meta(200,"Kullanıcı Kayıt başarılı");
            userResponse.dto=userMapper.toResource(user);
            logger.info("Kullanıcı başarıyla kaydedildi: {}", user.getUserName());
            return userResponse;
        }else {
            logger.error("Kullanıcı kaydedilirken bir hata oluştu.");
            throw new UserNotCreateException();
        }

    }


    @Override
    public UserResponse deleteUser(long userId) throws UserNotDeletedException {
        User user=userRepository.findByUserId(userId);
        if (user!=null){
            UserResponse userResponse=new UserResponse();
            userRepository.deleteByUserId(userId);
            userResponse.dto=userMapper.toResource(user);
            userResponse.meta=new Meta(200,"Kullanıcı silindi");
            logger.info("Kullanıcı başarıyla silindi: {}", user.getUserName());
            return userResponse;
        }else {
            logger.error("Silinmek istenen kullanıcı bulunamadı. Kullanıcı ID: {}", userId);
            throw new UserNotDeletedException();
        }
    }

    @Override
    public List<UserDto> getAllUser() {
        List<UserDto> userDtos =new ArrayList<>();

        Iterable<User> users = userRepository.findAll();

        for (User user : users){

            UserDto userDto = userMapper.toResource(user);
            userDtos.add(userDto);
        }
        logger.info("Tüm kullanıcılar listelendi.");
        return userDtos;

    }

    @Override
    public UserResponse getUser(long userId) throws UserNotFoundException {
        User user = findUser(userId);
        if (user != null) {
            UserResponse userResponse = new UserResponse();
            userResponse.dto = userMapper.toResource(user);
            logger.info("Kullanıcı bulundu: {}", user.getUserName());
            return userResponse;
        } else {
            logger.error("Kullanıcı bulunamadı. Kullanıcı ID: {}", userId);
            throw new UserNotFoundException();
        }

    }

    public User findUser(long userId) {
        User user=userRepository.findByUserId(userId);
        return user;
    }



    @Override
    public UserResponse login(UserDto userDto) throws UserNotLoginException {
        User user =userRepository.findUserByMailAndPassword(userDto.mail,userDto.password);
        if (user!=null){
            UserResponse userResponse =new UserResponse();
            userResponse.meta=new Meta(200,"Kullanıcı giriş yapıldı");
            userResponse.dto=userMapper.toResource(user);
            return userResponse;
        }else {
            throw new UserNotLoginException();
        }
    }

    @Override
    public UserDto updateUser(UserDto dto, long userId) {
            User entity=userMapper.toEntity(dto);
            User user=userRepository.findByUserId(userId);

            user.setUserName(entity.getUserName());
            user.setMail(entity.getMail());
            user.setUserLastName(entity.getUserLastName());
            user.setPassword(entity.getPassword());

            User updatedUser=userRepository.save(user);

            UserDto usertoDto=userMapper.toResource(updatedUser);
            return usertoDto;
    }
}
