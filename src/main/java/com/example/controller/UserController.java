package com.example.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.bean.*;
import com.example.service.*;
import com.example.util.Md5Util;
import com.example.util.ResultUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;
import java.util.List;

@CrossOrigin
@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private FaceSearchService faceSearch;
    @Autowired
    private FaceRegisterService faceRegister;

    @Autowired
    private UserService userService;

    /**
     * 个人查询
     */
    @GetMapping(value = "/{userAccount}")
    @ResponseBody
    public Object searchByAccount(@PathVariable("userAccount") String userAccount){

        List<User>  list=userService.getUserView(userAccount);
        return ResultUtil.success(list);

    }
    /**
     * 全部查询
     */
    @RequestMapping(value = "/search")
    @ResponseBody
    public Object search(){
        List<User>  list=userService.getUser();
        System.out.println(list);
        return ResultUtil.success(list);
    }

    /**
     * 增加
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add( User user){
        if (!user.getPassword().isEmpty()) {
            String enCodePassword = Md5Util.create32Md5(user.getPassword());
            user.setPassword(enCodePassword);
        }
        userService.add(user);
        return ResultUtil.success();
    }
    /**
     * 删除
     */
    @DeleteMapping(value = "/{userId}")
    @ResponseBody
    public Object delete(@PathVariable("userId") long userId){
        userService.delete(userId);
        return ResultUtil.success();
    }

    @RequestMapping("/faceLogin")
    @ResponseBody
    public ImageResult login(@RequestBody Image image, HttpSession session){

        System.out.println(image);
        User user = new User();
        ImageResult result = faceSearch.faceLogin(image);
        user.setNumberId(result.getUserId());
        System.out.println(user);
        session.setAttribute("user",user);
        return result;
    }

    @RequestMapping("/faceRegister")
    @ResponseBody
    public ImageResult register(@RequestBody Image image){
        ImageResult result = faceRegister.register(image);
        System.out.println(image);
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
        if (!user.getPassword().isEmpty()) {
            String enCodePassword = Md5Util.create32Md5(user.getPassword());
            user.setPassword(enCodePassword);
        }
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
        if (!user.getPassword().isEmpty()) {
            String enCodePassword = Md5Util.create32Md5(user.getPassword());
            user.setPassword(enCodePassword);
        }
        return userService.login(user);
    }

    /**
     * 退出
     * @param user 参数封装
     * @return Result
     */
    @RequestMapping(value = "/loginOut")
    @ResponseBody
    public Result loginOut(User user){
        return userService.loginOut(user);
    }
}

