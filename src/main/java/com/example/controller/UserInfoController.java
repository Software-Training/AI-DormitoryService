package com.example.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.bean.*;
import com.example.service.UserInfoService;
import com.example.util.ResultUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//业务层
@CrossOrigin
@Controller
@RequestMapping("/userinfo")
public class UserInfoController {
    @Autowired
    private UserInfoService userInfoService;

    /**
     * 个人查询
     */
    @RequestMapping(value = "/{numberId}")
    @ResponseBody
    public  Object searchByNumberId(String numberId){
        List<UserinfoView> list=userInfoService.searchByNumberId(numberId);
        return  ResultUtil.success(list);
    }
    /**
     * 管理员全部查询
     */
    @RequestMapping(value = "/search")
    @ResponseBody
    public  Object search(){
        List<UserinfoView> list=userInfoService.getUserinfoView();
        return  ResultUtil.success(list);
    }

    /**
     * 更新
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public void updateUserinfoView(UserinfoView userInfo){
        userInfoService.update(userInfo.getPhone(),userInfo.getEmail(),userInfo.getNumberId());
    }

    /**
     * 增加
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public void add( Userinfo userinfo){
        userInfoService.add(userinfo);
    }
    /**
     * 删除
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public void delete(long numberId){
        userInfoService.delete(numberId);
    }

}
