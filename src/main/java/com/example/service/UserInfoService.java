package com.example.service;

import com.example.bean.Record;
import com.example.bean.RecordView;
import com.example.bean.Userinfo;
import com.example.bean.UserinfoView;
import com.example.mapper.RecordMapper;
import com.example.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

//实现层，增删查
@Service
@Transactional(rollbackFor = RuntimeException.class)
public class UserInfoService {
    @Autowired
    private UserInfoMapper userInfoMapper;

    public void add(Userinfo userinfo) {
        userInfoMapper.AddUserInfo(userinfo);
    }

    public void delete(long numberId) {
        userInfoMapper.delUserInfoByNumberId(numberId);
    }

    public List<UserinfoView> getUserinfoView() {
        return  userInfoMapper.getUserInfoView();
    }

    public List<UserinfoView> searchByNumberId(String numberId) {
        return userInfoMapper.getUserInfoViewByNumberId(numberId);
    }
    public void update(String phone,String email,String numberId) {
        userInfoMapper.updateUserInfoByNumberId(phone,email,numberId);
    }

}
