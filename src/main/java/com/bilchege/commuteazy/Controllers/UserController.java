package com.bilchege.commuteazy.Controllers;

import com.bilchege.commuteazy.Entities.User;
import com.bilchege.commuteazy.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST,value = "/addUser")
    public User addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @RequestMapping("/getuser/{id}")
    public Optional<User> getUser(@PathVariable Long id){
        return userService.getUser(id);
    }

    @RequestMapping("/login/{username}/{password}")
    public Optional<User> login(@PathVariable("username")String username, @PathVariable("password")String password){
        return userService.login(username,password);
    }

    @RequestMapping("/getUsers")
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @RequestMapping(path = "/updateUser/{id}")
    public void updateUser(@RequestBody User user,@PathVariable Long id){
        userService.addUser(user);
    }

    @RequestMapping("/deleteUser/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }

}
