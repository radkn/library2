package com.lib.training.model.service;

import com.lib.training.model.entities.Role;
import com.lib.training.model.entities.User;
import com.lib.training.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserService  implements UserDetailsService {

    private final PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;

    @Autowired
    public UserService(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    public boolean addUser(User user){
        User userFromDb = userRepository.findByEmail(user.getEmail());

        if(userFromDb != null){
            return false;
        }

        user.setRoles(Collections.singleton(Role.USER));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setActive(true);
        userRepository.save(user);

        return true;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //User user =  userRepository.findByUsername(username);
        User user =  userRepository.findByEmail(username);

        if(user==null){
            throw new UsernameNotFoundException("User not found");
        }

        return user;
    }
}
