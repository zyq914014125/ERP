package com.hqyj.Dao;

import com.hqyj.entity.Menu;
import org.apache.ibatis.annotations.*;

import javax.persistence.FetchType;
import java.util.List;
import java.util.Map;

public interface MenuDao {
//    @Select("SELECT * from menu where roleId=#{roleId} OR parentMenu=0")
//    List<Menu> queryByRoleId(int roleId);

    /*
    * property:实体类对象名字
    * column：列名，即子查询的限制条件*/
    @Select("SELECT  menuId,menuName,url,IFNULL(roleId,#{roleId}) AS roleIds,parentMenu  FROM menu where parentMenu=0")
    @Results({
            @Result(column = "menuId",property = "menuId",id = true),
            @Result(property = "menu", column = "{roleId=roleIds,menuId=menuId}",many = @Many(select = "com.hqyj.Dao.MenuDao.queryByparentMenu")),
    })
    List<Menu> queryByRoleId(@Param("roleId") int roleId);

    @Select("<script> SELECT * from menu where <if test='roleId!=0'> roleId=#{roleId}  and  </if> parentMenu=#{menuId} </script>")
    List<Menu> queryByparentMenu(Map<String,Object> Param);

    @Update("UPDATE  menu SET url=#{url},roleId=#{roleId} where menuId=#{menuId}")
    void update(Menu menu);

    @Delete("DELETE FROM menu where menuId=#{menuId}")
    void delete(int menuId);
}
