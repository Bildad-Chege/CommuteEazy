package com.bilchege.commuteazy.Services;

import com.bilchege.commuteazy.Entities.User;
import com.bilchege.commuteazy.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void addUser(User user){
        userRepository.save(user);
    }

    public Optional<User> getUser(Long id){
        return userRepository.findById(id);
    }

}
