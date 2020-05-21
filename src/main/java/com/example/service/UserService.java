package com.example.service;




import com.example.bean.Record;
import com.example.bean.Result;
import com.example.bean.User;
import com.example.mapper.RecordMapper;
import com.example.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
@Transactional(rollbackFor = RuntimeException.class)
public class UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RecordMapper recordMapper;

    public Result regist(User user) {
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try {
            User existUser = userMapper.findUserByAccount(user.getUserAccount());
            if(existUser != null){
                //如果用户名已存在
                result.setMsg("用户名已存在");

            }else{
                userMapper.regist(user);
                //System.out.println(user.getId());
                result.setMsg("注册成功");
                result.setSuccess(true);
                result.setDetail(user);
            }
        } catch (Exception e) {
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    public Result login(User user) {
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try {
            Long userId= userMapper.login(user);
            if(userId == null){
                result.setMsg("用户名或密码错误");
            }else{

                Record record=new Record();
                String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                String inTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
                record.setUserId(userId);
                record.setDate(date);
                record.setInTime(inTime);
                recordMapper.AddRecord(record);
                result.setMsg("登录成功");
                result.setSuccess(true);
                user.setUserId(userId);
                result.setDetail(user);
            }
        } catch (Exception e) {
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }
    public Result loginOut(User user) {
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try {
            Long userId= user.getUserId();
            if(userId == null){
                result.setMsg("暂未登陆");
            }else{
                String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                String outTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
                recordMapper.updateOutTimeByDateAndUserId(outTime,date,userId);
                result.setMsg("退出成功");
                result.setSuccess(true);
                user.setUserId(userId);
                result.setDetail(user);
            }
        } catch (Exception e) {
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }
}
