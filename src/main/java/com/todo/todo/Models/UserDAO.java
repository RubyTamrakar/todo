package com.todo.todo.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;


@Document (collection = "user")
public class UserDAO {

    @Id
    private ObjectId Id;

    @Indexed(unique = true)
    private String email;

    @JsonIgnore
    private String password;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String toString() {
        return "User{" +
                "id='" + Id + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

}
