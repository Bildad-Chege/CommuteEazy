package com.bilchege.commuteazy.Controllers;

import com.bilchege.commuteazy.Entities.User;
import com.bilchege.commuteazy.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST,value = "/addUser")
    public void addUser(@RequestBody User user){
        userService.addUser(user);
    }

    @RequestMapping("/getOperator/{id}")
    public Optional<User> getUser(@PathVariable Long id){
        return userService.getUser(id);
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
