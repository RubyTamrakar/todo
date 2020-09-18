package com.todo.todo.Services;

import com.todo.todo.Models.ToDoDAO;
import com.todo.todo.Models.ToDoDTO;
import com.todo.todo.Models.UserDAO;
import com.todo.todo.Models.UserDTO;
import com.todo.todo.Repository.ToDoRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

@Service
public class ToDoService {
    @Autowired
    PasswordEncoder encoder;
    @Autowired
    ToDoRepository toDoRepository;

//    public MongoDbFactory mongoDbFactory() {
//        MongoDbFactory factory = new SimpleMongoDbFactory(mongoClient(), getDatabaseName());
//        return factory;
//    }
   @Autowired
    MongoTemplate mongoTemplate;

    public ToDoDAO saveToDo(ToDoDTO todoDTO){
        ToDoDAO todo = new ToDoDAO();
        todo.setCompleted(todoDTO.isCompleted());
        todo.setDescription(todoDTO.getDescription());
        todo.setEmail(todoDTO.getEmail());
        todo.setDueOn(todoDTO.getDueOn());
        return toDoRepository.save(todo);
    }

    public List<ToDoDAO> getToDOs(String email) {
//        Query query = new Query();
//        query.addCriteria(Criteria.where("email").is(email));
//        List<ToDoDAO> toDos = mongoTemplate.find(query, ToDoDAO.class);
//        return toDos;
       List toDos= toDoRepository.findAllByEmail(email);
       return toDos;
    }

    public ToDoDAO markAsCompleted(ObjectId id){
//        Optional<ToDoDAO> result = toDoRepository.findById(id);
//        result.setCompleted(true);
//        toDoRepository.save(result);
            return toDoRepository.findById(id).orElseThrow();
    }

    public void deleteToDO(ObjectId id){
        toDoRepository.deleteById(id);
    }
}
