package com.hqyj.Dao;

import com.hqyj.entity.Punch;
import com.hqyj.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PunchDao {
    @Select("Select * from punch where TO_DAYS(time) = TO_DAYS(NOW()) ")
    List<Punch> getPunches();

    @Insert("INSERT INTO punch (userId,time,name) VALUES (#{user_id},now(),#{name}) ")
    void insert(User user);
    @Select("Select * from punch where TO_DAYS(time) = TO_DAYS(NOW()) AND userId=#{user_id} ")
    Punch getNow(User user);
}
