package com.todo.todo.Models;

import com.mongodb.lang.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection ="todo")
public class ToDoDAO {

    @Id
    private ObjectId Id;

    @NonNull
    private String description;

    @NonNull
    private String dueOn;

    @NonNull
    private boolean completed = false;

    public ToDoDAO() {
    }

    private String email;

//    public ToDoDAO(String description, LocalDateTime dueOn, boolean completed, UserDAO userDAO) {
//        this.description = description;
//        this.dueOn = dueOn;
//        this.completed = completed;
//        this.userDAO = userDAO;
//    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDueOn() {
        return dueOn;
    }

    public void setDueOn(String dueOn) {
        this.dueOn = dueOn;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "ToDoDAO{" +
                "Id=" + Id +
                ", description='" + description + '\'' +
                ", dueOn=" + dueOn +
                ", completed=" + completed +
                ", userId='" + email + '\'' +
                '}';
    }
}
