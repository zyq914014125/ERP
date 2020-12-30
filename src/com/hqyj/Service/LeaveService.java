package com.hqyj.Service;


import com.hqyj.Dao.LeaveDao;
import com.hqyj.entity.Leave;
import com.hqyj.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class LeaveService  {
    @Autowired
    LeaveDao leaveDao;

    public List<Leave> getAllLeave() {
        return leaveDao.getAllLeave();
    }

    public List<Leave> getUntreatedLeave() {
        return leaveDao.getUntreatedLeave();
    }

    public void insert(Leave leave) {
       leaveDao.insert(leave);
    }

    public void update(int leaveId) {
        leaveDao.update(leaveId);
    }

    public List<Leave> getAllLeaveAndUser() {
        return leaveDao.getAllLeaveAndUser();
    }
}
