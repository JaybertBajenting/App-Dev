package com.example.demo.Controller;


import com.example.demo.Classes.Student;
import com.example.demo.Entity.UserEntity;
import com.example.demo.Service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("account")
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



    @DeleteMapping("/deleteAccount/{id}")
    public String deleteAccount(@PathVariable  int id){
        return this.userService.deleteUser(id);
    }




    @GetMapping("getAccountById/")
    public UserEntity getAccountById(@RequestParam int id){
        return this.userService.getAccountById(id);
    }





    @PostMapping("getAccountByCredentials/")
    public UserEntity getAccountByCredentials(@RequestParam String email, @RequestParam String password){
        return this.userService.getAccountByCredentials(email,password);
    }






    @PostMapping("uploadPicture/")
    public void uploadPicture(@RequestParam("id") int id, @RequestParam("file") MultipartFile picture){
        this.userService.uploadPicture(id,picture);
    }


    @GetMapping("getProfilePicture/")
    public byte[] getProfilePictre(@RequestParam int id){
        return this.userService.getProfilePicture(id);
    }




    @PutMapping("updateAccount")
    public UserEntity updateAccount(@RequestParam("id") int id,@RequestBody UserEntity userEntity){
    return this.userService.updateAccount(id,userEntity);
    }


























}
