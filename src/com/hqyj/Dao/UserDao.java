package com.hqyj.Dao;

import com.hqyj.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserDao {
    @Select("SELECT COUNT(user_id) FROM user")
    int CountAllUsers();

//    @Select("SELECT * from user where roleId>#{roleId} limit #{page},#{limit}")
//    List<User> getAllUsers(@Param("roleId") int roleId, @Param("page") int page, @Param("limit") int limit);

    @Select("SELECT * FROM user,role where user.roleId=role.roleId and user.username=#{username}")
    User queryByusername(String username);

    @Select("SELECT * FROM user,role where user.roleId=role.roleId and user.roleId>#{roleId}")
    List<User> queryByRoleId(int roleId);

    @Select("insert into user (username,password,name,telephone,sex,age,state,roleId) VALUES (#{username},#{password},#{name},#{telephone},#{sex},#{age},0,#{roleId})")
    void InsertUser(User user);

    @Select("DELETE FROM user where user_id=#{user_id}")
    void delete(int user_id);

    @Update("UPDATE user set telephone=#{telephone},password=#{password},name=#{name},sex=#{sex},age=#{age} WHERE user_id=#{user_id}")
    void update(User user);
}
