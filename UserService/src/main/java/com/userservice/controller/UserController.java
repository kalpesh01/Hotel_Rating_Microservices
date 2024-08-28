package com.userservice.controller;

import com.userservice.entities.User;
import com.userservice.payload.ApiResponse;
import com.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add-user")
    public ResponseEntity<?> addUser(@RequestBody User user){
        User user1 = userService.saveUser(user);
        if(user1 != null){
            return ResponseEntity.ok(new ApiResponse("user fetched successfully",true, HttpStatus.OK,user1));
        }else{
            return ResponseEntity.ok(new ApiResponse("user not found",false, HttpStatus.NOT_FOUND));
        }
    }

    @GetMapping("/get-all-users")
    public ResponseEntity<?> getAllUser(){
        List<User> allUsers = userService.getAllUsers();
        if(allUsers != null){
            return ResponseEntity.ok(new ApiResponse("users fetched successfully",true, HttpStatus.OK,allUsers));
        }else{
            return ResponseEntity.ok(new ApiResponse("users not found",false, HttpStatus.NOT_FOUND));
        }
    }

    @GetMapping("/get-user-by/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Integer id){
        User user = userService.getUserById(id);
        if(user != null){
            return ResponseEntity.ok(new ApiResponse("users fetched successfully",true, HttpStatus.OK,user));
        }else{
            return ResponseEntity.ok(new ApiResponse("users not found",false, HttpStatus.NOT_FOUND));
        }
    }
}
