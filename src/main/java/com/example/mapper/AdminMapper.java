package com.example.mapper;


import com.example.bean.Admin;
import com.example.bean.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface AdminMapper {
    /**
     * 登录
     * @param admin
     * @return
     */
    @Select("select a.adminId from admin a where a.adminAccount = #{adminAccount} and a.password = #{password}")
    Long login(Admin admin);
}
