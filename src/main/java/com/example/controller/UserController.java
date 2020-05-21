package com.example.controller;

import com.example.bean.Image;
import com.example.bean.ImageResult;
import com.example.bean.Result;
import com.example.bean.User;
import com.example.service.FaceRegisterService;
import com.example.service.FaceSearchService;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;
@CrossOrigin
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private FaceSearchService faceSearch;
    @Autowired
    private FaceRegisterService faceRegister;
    @Autowired
    private UserService userService;

    @RequestMapping("/faceLogin")
    @ResponseBody
    public ImageResult login(Image image, HttpSession session){
        User user = new User();
        ImageResult result = faceSearch.faceLogin(image);
        user.setNumberId(result.getUserId());
        session.setAttribute("user",user);
        return result;
    }

    @RequestMapping("/faceRegister")
    @ResponseBody
    public ImageResult register(Image image){
        ImageResult result = faceRegister.register(image);
        return result;
    }

    /**
     * 注册
     * @param user 参数封装
     * @return Result
     */
    @RequestMapping(value = "/regist")
    @ResponseBody
    public Result regist(User user){
        return userService.regist(user);
    }

    /**
     * 登录
     * @param user 参数封装
     * @return Result
     */
    @RequestMapping(value = "/login")
    @ResponseBody
    public Result login(User user){
        return userService.login(user);
    }

    /**
     * 登录
     * @param user 参数封装
     * @return Result
     */
    @RequestMapping(value = "/loginOut")
    @ResponseBody
    public Result loginOut(User user){
        return userService.loginOut(user);
    }
}

