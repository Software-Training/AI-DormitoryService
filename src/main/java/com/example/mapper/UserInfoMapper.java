package com.example.mapper;

import com.example.bean.Record;
import com.example.bean.RecordView;
import com.example.bean.Userinfo;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

public interface UserInfoMapper {
    //新增信息UserInfo
    @Insert({"insert into userinfo(numberId,name,sex,subject,dormitoryId,phone,email) values(#{numberId},#{name},#{sex},#{subject},#{dormitoryId},#{phone},#{email})"})
    void AddUserInfo(Userinfo userinfo);
    //删除信息record
    @Delete("delete from userinfo where numberId=#{numberId}")
    void delUserInfoByNumberId(@Param("numberId") long numberId);

    //查询所有详细信息
    @Select("select * from userinfoview")
    List<Userinfo> getUserInfoView();

    //查询对应学号学生的信息
    @Select("select * from userinfoview where numberId=#{numberId}")
    List<Userinfo> getUserInfoViewByNumberId(@Param("numberId") String numberId);

    @Update("update userinfo set phone=#{phone},email = #{email}where numberId = #{numberId}")
    void updateUserInfoByNumberId( @Param("phone") String phone, @Param("email") String email, @Param("numberId") String numberId);

}
