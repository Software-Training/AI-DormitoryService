package com.example.service;




import com.example.bean.Admin;
import com.example.bean.Result;
import com.example.bean.User;
import com.example.mapper.AdminMapper;
import com.example.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = RuntimeException.class)
public class AdminService {
    @Autowired
    private AdminMapper adminMapper;

    public Result login(Admin admin) {
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try {
            Long adminId= adminMapper.login(admin);
            if(adminId == null){
                result.setMsg("用户名或密码错误");
            }else{
                result.setMsg("登录成功");
                result.setSuccess(true);
                admin.setAdminId(adminId);
                result.setDetail(admin);
            }
        } catch (Exception e) {
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }
}
