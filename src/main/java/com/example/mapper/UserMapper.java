package com.example.mapper;


import com.example.bean.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {
    /**
     * 查询用户名是否存在，若存在，不允许注册
     * 注解@Param(value) 若value与可变参数相同，注解可省略
     * 注解@Results  列名和字段名相同，注解可省略
     * @param userAccount
     * @return
     */
    @Select(value = "select u.userAccount,u.password from user u where u.userAccount=#{userAccount}")
    @Results
            ({@Result(property = "userAccount",column = "userAccount"),
                    @Result(property = "password",column = "password")})
    User findUserByAccount(@Param("userAccount") String userAccount);

    /**
     * 注册  插入一条user记录
     * @param user
     * @return
     */
    @Insert("insert into user values(#{userId},#{userAccount},#{password},#{numberId})")
    //加入该注解可以保存对象后，查看对象插入id
    @Options(useGeneratedKeys = true,keyProperty = "userId",keyColumn = "userId")
    void regist(User user);

    /**
     * 登录
     * @param user
     * @return
     */
    @Select("select u.userId from user u where u.userAccount = #{userAccount} and password = #{password}")
    Long login(User user);

    //更新
    @Update("update user set password=#{password} where numberId = #{numberId}")
    void updateUserByNumberId( @Param("password") String password,@Param("numberId") String numberId);

    //删除
    //删除信息record
    @Delete("delete from user where numberId=#{numberId}")
    void delUserByNumberId(@Param("numberId") long numberId);

}
