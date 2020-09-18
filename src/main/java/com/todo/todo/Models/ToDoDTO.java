package com.todo.todo.Models;

import com.mongodb.lang.NonNull;

import java.time.LocalDateTime;

public class ToDoDTO {
    private String description;
    private String dueOn;
    private boolean completed = false;
    private String email;

//    public ToDoDTO(String description, LocalDateTime dueOn, boolean completed, UserDTO userDTO){
//        this.description = description;
//        this.dueOn = dueOn;
//        this.completed = completed;
//        this.userDTO = userDTO;
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


    @Override
    public String toString() {
        return "ToDoDTO{" +
                "description='" + description + '\'' +
                ", dueOn=" + dueOn +
                ", completed=" + completed +
                ", userId='" + email + '\'' +
                '}';
    }
}


