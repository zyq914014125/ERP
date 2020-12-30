package com.hqyj.Service;

import com.hqyj.Dao.PunchDao;

import com.hqyj.entity.Punch;
import com.hqyj.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PunchService {
    @Autowired
    PunchDao punchDao;
    public List<Punch> getPunches() {
        return punchDao.getPunches();
    }

    public void insert(User user) {
        punchDao.insert(user);
    }

    public Punch getNow(User user) {
        return punchDao.getNow(user);
    }
}
