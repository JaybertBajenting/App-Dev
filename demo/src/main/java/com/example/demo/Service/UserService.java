package com.example.demo.Service;

import com.example.demo.Classes.Student;
import com.example.demo.Entity.UserEntity;
import com.example.demo.Repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

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



    public String deleteUser(int id){
            if(this.userRepository.existsById(id)){
                this.userRepository.deleteById(id);
                return "Account has been Deleted";
            }

            return "Account not Found";
    }


    public UserEntity getAccountByCredentials(String email, String password){

        List<UserEntity> accounts = this.userRepository.findAll();

        for(UserEntity account:accounts){
            if(account.getEmail().equals(email) && account.getPassword().equals(password)) return account;
        }


        return null;
    }


    public UserEntity getAccountById(int id){
        if(this.userRepository.existsById(id)){
            return this.userRepository.findById(id).get();
        }
        return null;
    }


    public void uploadPicture(int id, MultipartFile picture){
     try{
         UserEntity currentUser = this.userRepository.findById(id).get();
         currentUser.setProfilePicture(picture.getBytes());
         this.userRepository.save(currentUser);
         System.out.println("Successfully Uploaded a Picture");
     }catch(Exception e){
         System.out.println(e);
     }
    }


    public byte[] getProfilePicture(int id){
        UserEntity currentUser = this.userRepository.findById(id).get();
        return currentUser.getProfilePicture();
    }





    public UserEntity updateAccount(int id, UserEntity userEntity){
            UserEntity user = this.userRepository.findById(id).get();
            user.setFirstName(userEntity.getFirstName());
            user.setLastName(userEntity.getLastName());
            user.setIdNumber(userEntity.getIdNumber());
            user.setEmail(userEntity.getEmail());
            return this.userRepository.save(user);
    }










}
