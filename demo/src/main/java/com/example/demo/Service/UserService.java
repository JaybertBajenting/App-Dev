package com.example.demo.Service;

import com.example.demo.Classes.Student;
import com.example.demo.Entity.UserEntity;
import com.example.demo.Repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class UserService {


    private final UserRepository userRepository;


    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }


    public Student makeAccount(Student student) {
        return this.userRepository.save(student);
    }



    public List<UserEntity> getAccounts(){
        return this.userRepository.findAll();
    }




}
