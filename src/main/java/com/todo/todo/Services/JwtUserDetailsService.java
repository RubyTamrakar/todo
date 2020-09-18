package com.todo.todo.Services;

import com.todo.todo.Models.UserDAO;
import com.todo.todo.Models.UserDTO;
import com.todo.todo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private PasswordEncoder bcryptEncoder;


    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserDAO userDAO = userRepository.findByEmail(email)
                .orElseThrow(()->new UsernameNotFoundException("User not found with email:" + email));

        return new User(userDAO.getEmail(), userDAO.getPassword(), new ArrayList<>());
                //UserDetailsImplementation.build(user);
    }

    public UserDAO save (UserDTO user){
        UserDAO newUser = new UserDAO();
        newUser.setEmail(user.getEmail());
        newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
        return userRepository.save(newUser);
    }


}
