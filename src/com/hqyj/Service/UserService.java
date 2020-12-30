package com.hqyj.Service;

import com.hqyj.Dao.UserDao;
import com.hqyj.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    //自动注入logindao对象
    @Autowired
    UserDao userDao;
    public User queryByusername(String username) {
        //接收并返回
        return userDao.queryByusername(username);
    }

    public List<User> queryByRoleId(int roleId) {
        return userDao.queryByRoleId(roleId);
    }

    public void insert(User user) {
          userDao.InsertUser(user);
    }

    public void delete(int user_id) {
        userDao.delete(user_id);
    }

    public void update(User user) {
        userDao.update(user);
    }

    public int CountAllUsers() {
        return userDao.CountAllUsers();
    }
//
//    public void InsertUser(User user) {
//        userDao.InsertUser(user);
//    }
}
