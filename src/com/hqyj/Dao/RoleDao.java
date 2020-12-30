package com.hqyj.Dao;

import com.hqyj.entity.Role;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface RoleDao {
    @Select("SELECT * FROM role")
    List<Role> query();

    @Select("SELECT roleName FROM role where roleId=#{roleId}")
    String queryByRoleId(int roleId);

    @Update("UPDATE role SET roleName=#{roleName} where roleId=#{roleId}")
    void update(Role role);

    @Delete("DELETE FROM role where roleId=#{roleId}")
    void delete(int roleId);
}
