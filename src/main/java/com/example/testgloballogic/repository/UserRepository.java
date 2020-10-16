package com.example.testgloballogic.repository;

import com.example.testgloballogic.entity.EntityPhone;
import com.example.testgloballogic.entity.EntityUser;
import com.example.testgloballogic.model.Phone;
import com.example.testgloballogic.model.User;
import com.example.testgloballogic.util.JavaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Repository
public class UserRepository {
    @Autowired
    private EntityUserRepository entityUserRepository;

    public EntityUser createUser(final User user) {
        EntityUser u = new EntityUser();
        u.setEmail(user.getEmail());
        u.setName(user.getName());
        u.setPassword(user.getPassword());
        u.setCreado(new java.sql.Timestamp(Calendar.getInstance().getTime().getTime()));
        u.setLast_login(new java.sql.Timestamp(Calendar.getInstance().getTime().getTime()));
        u.setActive(true);
        u.setToken(JavaUtil.getJWTToken(user.getName()));
        List<EntityPhone> entityPhones = new ArrayList<>();
        for (Phone phone : user.getPhones()) {
            EntityPhone entityPhone = new EntityPhone();
            entityPhone.setCitycode(phone.getCitycode());
            entityPhone.setContrycode(phone.getCountrycode());
            entityPhone.setNumber(phone.getNumber());
            entityPhone.setEntityUser(u);
            entityPhones.add(entityPhone);

        }
        u.setPhones(entityPhones);
        entityUserRepository.save(u);
        return u;
    }

    public EntityUser findByName(String nameUser){
       return entityUserRepository.findByName(nameUser);
    }
}
