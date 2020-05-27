package com.example.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.bean.Admin;

import com.example.service.AdminService;
import com.example.util.ResultUtil;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

//    @Autowired
//    private JwtUtils jwtTokenUtil;
//    /**
//     * 登录
//     * @param
//     * @return Result
//     */
//    @PostMapping(value = "/login")
//    public Result login(  Admin admin){
//        return adminService.login(admin);
//    }
//
//
//    /**
//     * 退出
//     * @param admin 参数封装
//     * @return Result
//     */
//    @RequestMapping(value = "/loginOut")
//    @ResponseBody
//    public Result loginOut( @RequestBody Admin admin){
//        return adminService.loginOut(admin);
//    }
    @PostMapping(value = "/login")
    public Object login(@RequestBody Admin admin) {
        Map<String, Object> data = new HashMap();
        data.put("k1", "v1");
        String password = admin.getPassword();
        String account = admin.getAdminAccount();
        System.out.println(account);
        System.out.println(password);
        Admin admin1 = adminService.getAdmin(account,password);
        if (admin1 != null) {
            data.put("JWT","123456");
            return ResultUtil.success(data);
        } else {
            return ResultUtil.loginError();
        }

    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public Object logout() {
        return ResultUtil.success();
    }

    @RequestMapping(value = "/info", method = RequestMethod.POST)
    public Object getInfo(HttpServletRequest request) {

//        UserDetail userDetail = analysisJwt.getUserFromJwt(request);
//        User user = userService.getById(userDetail.getUsername());

        Map<String, Object> data = new HashMap<String, Object>();
        Map map = new HashMap();
        String[] role = new String[1];
        role[0] = "admin";
        map.put("id", "23233");
        map.put("username", "232323");
        map.put("password", "");
        map.put("introduction", "2332323");
        map.put("email", "");
        map.put("name", "2323232323");
        map.put("roles", role);
        map.put("avatar", "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        data.put("user", map);
        return ResultUtil.success(data);
    }
}

