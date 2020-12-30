package com.hqyj.Service;

import com.hqyj.Dao.MenuDao;
import com.hqyj.entity.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {
    @Autowired
    MenuDao menuDao;
    //菜单查询
    public List<Menu> queryByRoleId(int roleId) {
       return menuDao.queryByRoleId(roleId);
    }

    public List<Menu> query() {
        return menuDao.queryByRoleId(0);
    }

    public void update(Menu menu) {
        menuDao.update(menu);
    }

    public void delete(int menuId) {
        menuDao.delete(menuId);
    }
}
