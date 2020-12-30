package com.hqyj.Dao;


import com.hqyj.entity.Leave;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface LeaveDao {
    @Select("SELECT * FROM leaves  ")
    List<Leave> getAllLeave();
    @Select("SELECT leaveId,userId,time,reason,header,name FROM leaves,user where user.user_id=leaves.leaveId and leaves.state=0  ")
    List<Leave> getAllLeaveAndUser();
    @Select("SELECT * FROM leaves where state=0")
    List<Leave> getUntreatedLeave();

    @Insert("INSERT INTO leaves (userId,time,reason,state,header) VALUES (#{userId},NOW(),#{reason},0,#{reason})")
    void insert(Leave leave);

    @Update("UPDATE leave SET state=1 where leaveId=#{leaveId}")
    void update(int leaveId);
}
