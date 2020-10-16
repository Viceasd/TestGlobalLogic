package com.example.testgloballogic.controller;

import com.example.testgloballogic.entity.EntityUser;
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



@RestController
public class ControllerUser {

    private static final Logger log = LoggerFactory.getLogger(ControllerUser.class);
    @Autowired
    private UserRepository userRepository;


    @PostMapping("/login")
    public String login(@RequestBody User usuario)
            throws ServiceException {
        String token = "";
        try{
            EntityUser user = userRepository.findByName(usuario.getName());
            if(usuario.getPassword().contains(user.getPassword())){
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
        EntityUser entityUser;
       try{
           if (JavaUtil.validateEmail(usuario.getEmail()) && JavaUtil.validatePassword(usuario.getPassword())){
               entityUser= userRepository.createUser(usuario);
           }else{
               throw new ServiceException(HttpStatus.NOT_FOUND.value(), "Error al Intentar Crear Usuario");
           }


       }catch(Exception e){
           throw new ServiceException(HttpStatus.NOT_FOUND.value(), "Error al Intentar Crear Usuario");
       }

       return userResponse= parseToUserResponse(entityUser);

    }

    private UserResponse parseToUserResponse(EntityUser user) {
        UserResponse userResponse = new UserResponse();
        userResponse.setCreated(user.getCreado().toString());
        userResponse.setId(user.getId().toString());
        userResponse.setIsactive(user.isActive());
        userResponse.setLast_login(user.getLast_login().toString());
        userResponse.setToken(user.getToken());
        return userResponse;


    }


}
