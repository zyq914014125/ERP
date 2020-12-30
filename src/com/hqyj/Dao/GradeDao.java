package com.hqyj.Dao;

import com.hqyj.entity.Grade;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface GradeDao {
    @Select("SELECT grade_id,grade.user_id,score,time,name from grade,user where grade.user_id=user.user_id")
    List<Grade> query();

    @Insert("INSERT INTO grade (user_id,score,time) VALUES(#{user_id},#{score},now())")
    void addGrade(Grade grade);
}
