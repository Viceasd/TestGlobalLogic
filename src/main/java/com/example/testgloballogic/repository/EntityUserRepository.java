package com.example.testgloballogic.repository;

import com.example.testgloballogic.entity.EntityUser;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EntityUserRepository extends CrudRepository<EntityUser, Long> {
    EntityUser findByName(String name);

}
