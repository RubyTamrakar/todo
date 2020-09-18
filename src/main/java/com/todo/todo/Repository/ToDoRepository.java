package com.todo.todo.Repository;

import com.todo.todo.Models.ToDoDAO;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface ToDoRepository extends MongoRepository<ToDoDAO,ObjectId> {


//    void deleteToDo(ObjectId Id);
    List<ToDoDAO> findAllByEmail(String email);
    Optional<ToDoDAO> findById(ObjectId id);
    void deleteById(ObjectId id);



}
