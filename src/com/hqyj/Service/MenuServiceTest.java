package com.hqyj.Service;

import com.hqyj.Dao.MenuDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring-mybatis.xml" })
public class MenuServiceTest {
    @Autowired
    MenuDao menuDao;
    @Test
    public void queryByRoleId() {
        System.out.println(menuDao.queryByRoleId(100));
    }
}