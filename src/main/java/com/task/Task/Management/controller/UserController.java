package com.task.Task.Management.controller;

import com.task.Task.Management.dto.UserDTO;
import com.task.Task.Management.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public UserDTO addUser(@Valid @RequestBody UserDTO userDTO){
        return userService.addUser(userDTO);
    }

    @GetMapping("/getAll")
    public List<UserDTO> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/getUserById/{userId}")
    public UserDTO getUserById(@PathVariable long userId){
        return userService.getUserById(userId);
    }

    @PutMapping("/update/{userId}")
    public UserDTO updateUser(@PathVariable long userId,@Valid @RequestBody UserDTO userDTO){
        return userService.updateUser(userId,userDTO);
    }

    @DeleteMapping("/delete/{userId}")
    public  UserDTO deleteUser(@PathVariable long userId){
        return  userService.removeUser(userId);
    }

    @GetMapping("/getUserByName/{userName}")
    public List<UserDTO> getUserByName(@PathVariable String userName){
        return userService.getUserByName(userName);
    }

    @GetMapping("/getUserByEmail/{userEmail}")
    public UserDTO getUserByEmail(@PathVariable String userEmail){
        return userService.getUserByEmail(userEmail);
    }
}
