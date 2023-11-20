package com.example.demo.Controller;


import com.example.demo.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("admin")
@CrossOrigin(origins = "*")
public class AdminController {


    private final AdminService adminService;


    @Autowired
    public AdminController(AdminService adminService){
        this.adminService = adminService;
    }


    @DeleteMapping("deleteUserById/{id}")
    public String deleteUserById(@PathVariable  int id){
        return this.adminService.deleteUserById(id);
    }





}
