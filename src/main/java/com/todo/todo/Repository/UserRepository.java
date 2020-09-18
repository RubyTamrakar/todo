package com.todo.todo.Repository;

import com.todo.todo.Models.UserDAO;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<UserDAO, ObjectId> {

    Optional<UserDAO> findByEmail(String email);
    Boolean existsByEmail( String email);

}
