package com.bilchege.commuteazy.Services;

import com.bilchege.commuteazy.Entities.User;
import com.bilchege.commuteazy.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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

    public List<User> getUsers(){
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    public Optional<User> login(String userName,String password){
        Optional<User> response = Optional.of(new User());
        response = userRepository.findUserByUserNameAndAccountPassword(userName,password);
        return response;
    }

    public void updateUser(Long id,User user){
        userRepository.save(user);
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }

}
