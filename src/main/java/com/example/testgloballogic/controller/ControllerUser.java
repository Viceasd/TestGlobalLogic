package com.example.testgloballogic.controller;

import com.example.testgloballogic.entity.EntityUser;
import com.example.testgloballogic.model.Phone;
import com.example.testgloballogic.model.ServiceException;
import com.example.testgloballogic.model.User;
import com.example.testgloballogic.model.UserResponse;
import com.example.testgloballogic.repository.UserRepository;
import com.example.testgloballogic.util.JavaUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@RestController
public class ControllerUser {

    private static final Logger log = LoggerFactory.getLogger(ControllerUser.class);
    @Autowired
    private UserRepository userRepository;

    public EntityUser adminUser(){
        User user = new User();
        user.setName("admin");
        user.setPassword("Admin123");
        user.setEmail("adasd@asd.cl");
        List<Phone> phones= new ArrayList<>();
        Phone phone = new Phone();
        phone.setNumber("3453453");
        phone.setCountrycode("56");
        phone.setCitycode("02");
        phones.add(phone);
        user.setPhones(phones);
        return userRepository.createUser(user);

    }

    @PostMapping("/login")
    public String login(@RequestBody User usuario)
            throws ServiceException {
        EntityUser entityUser;
        try {
            entityUser = userRepository.findByName("admin");
        }catch(Exception e){
            e.printStackTrace();
            entityUser = adminUser();
        }

        String token = "";
        try{

            if(entityUser.getPassword().contains(usuario.getPassword())){
                 token = JavaUtil.getJWTToken(usuario.getName());
            }
        }catch(Exception e){
            e.printStackTrace();
            throw new ServiceException(HttpStatus.NOT_FOUND.value(), "Error al Intentar Logear");

        }
        return token;
    }

    @PostMapping(path = "/user", consumes = "application/json", produces = "application/json")
    public UserResponse addUser(@RequestBody User usuario) throws ServiceException {
        UserResponse userResponse;
        EntityUser entityUser = new EntityUser();
       try{
           if (JavaUtil.validateEmail(usuario.getEmail()) && JavaUtil.validatePassword(usuario.getPassword())){
               entityUser = userRepository.createUser(usuario);
           }else{
               throw new ServiceException(HttpStatus.NOT_FOUND.value(), "Error al Intentar Crear Usuario");
           }


       }catch(Exception e){
           throw new ServiceException(HttpStatus.NOT_FOUND.value(), "Error al Intentar Crear Usuario");
       }

       return userResponse = parseToUserResponse(entityUser);

    }

    private UserResponse parseToUserResponse(EntityUser user) {
        UserResponse userResponse = new UserResponse();
        userResponse.setCreated(user.getCreado().toString());
        userResponse.setId(user.getUserId());
        userResponse.setIsactive(user.isActive());
        userResponse.setLast_login(user.getLast_login().toString());
        userResponse.setToken(user.getToken());
        return userResponse;


    }


}
