package com.lib.training.model.service;

import com.lib.training.model.entities.Role;
import com.lib.training.model.entities.User;
import com.lib.training.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;

public class UserService {

    @Autowired
    private UserRepository userRepository;

    public boolean addUser(User user){
        User userFromDb = userRepository.findByEmail(user.getEmail());

        if(userFromDb != null){
            return false;
        }

        user.setRoles(Collections.singleton(Role.USER));
        user.setPassword(user.getPassword());

        userRepository.save(user);

        return true;
    }

}
