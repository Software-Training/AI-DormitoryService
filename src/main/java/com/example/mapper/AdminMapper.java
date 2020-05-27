package com.example.mapper;


import com.example.bean.Admin;
import com.example.bean.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AdminMapper {
    /**
     * 登录
     * @param
     * @return
     */
    @Select("select a.adminId from admin a where a.adminAccount = #{adminAccount} and a.password = #{password}")
    Long login(@Param("adminAccount") String adminAccount,  @Param("password") String password);
    @Select("select * from admin a where a.adminAccount = #{adminAccount} and a.password = #{password}")
    Admin getAdminByAdminAccountAndPassword(@Param("adminAccount") String adminAccount, @Param("password") String password);
}
