package com.example.demo.Service;


import com.example.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {




    private final UserRepository userRepository;


    @Autowired
    public AdminService(UserRepository userRepository){
        this.userRepository = userRepository;
    }





    public String deleteUserById(int id){
        if(this.userRepository.existsById(id)){
            this.userRepository.deleteById(id);
            return "User Successfully Deleted";
        }
        return "Deleted User Failed";
    }


}
