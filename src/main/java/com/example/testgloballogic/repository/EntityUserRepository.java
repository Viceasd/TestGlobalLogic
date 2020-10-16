package com.example.testgloballogic.repository;

import com.example.testgloballogic.entity.EntityUser;
import org.springframework.data.repository.CrudRepository;

public interface EntityUserRepository extends CrudRepository<EntityUser, String> {
    EntityUser findByName(String name);
}
