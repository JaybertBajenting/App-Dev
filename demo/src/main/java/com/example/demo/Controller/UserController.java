package com.example.demo.Controller;


import com.example.demo.Classes.Student;
import com.example.demo.Entity.UserEntity;
import com.example.demo.Service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("accounts")
@CrossOrigin(origins = "*")

public class UserController {


    private final UserService userService;


    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }



    @PostMapping("/createAccount")
    public Student createAccount(@RequestBody Student student){
     return this.userService.makeAccount(student);
    }








    @GetMapping("/getAccounts")
    public List<UserEntity> getAccounts() {
        return this.userService.getAccounts();
    }










}
