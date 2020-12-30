package com.hqyj.Service;

import com.hqyj.Dao.RoleDao;
import com.hqyj.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    RoleDao roleDao;
    public List<Role> query() {
        return roleDao.query();
    }

    public void update(Role role) {
        roleDao.update(role);
    }

    public void delete(int roleId) {
         roleDao.delete(roleId);
    }
}
