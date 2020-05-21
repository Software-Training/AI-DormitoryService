package com.example.controller;

import com.example.bean.Admin;
import com.example.bean.Result;
import com.example.bean.User;
import com.example.service.AdminService;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;
    /**
     * 登录
     * @param admin 参数封装
     * @return Result
     */
    @PostMapping(value = "/login")
    public Result login(Admin admin){
        return adminService.login(admin);
    }
}

