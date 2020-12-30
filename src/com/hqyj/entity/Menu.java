package com.hqyj.entity;

import java.util.List;

//菜单栏
public class Menu {
    private int menuId;
    private String menuName;
    private int roleId;
    private String url;
    private int parentMenu;


    private List<Menu> menu;

    public List<Menu> getMenu() {
        return menu;
    }

    public void setMenu(List<Menu> menu) {
        this.menu = menu;
    }

    public int getParentMenu() {
        return parentMenu;
    }

    public void setParentMenu(int parentMenu) {
        this.parentMenu = parentMenu;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "menuId=" + menuId +
                ", menuName='" + menuName + '\'' +
                ", roleId=" + roleId +
                ", url='" + url + '\'' +
                ", parentMenu=" + parentMenu +
                ", menu=" + menu +
                '}';
    }

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
