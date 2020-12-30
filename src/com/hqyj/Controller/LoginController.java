package com.hqyj.Controller;

import com.hqyj.Service.MenuService;
import com.hqyj.Service.UserService;
import com.hqyj.entity.Menu;
import com.hqyj.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

//登录控制器
@Controller
public class LoginController {
    //自动注入Service层对象
    @Autowired
    UserService userService;
    @Autowired
    MenuService menuService;

    //表示以POST提交方式，提交给/login.do，执行login方法,produces：指定响应体返回类型和编码，这里设定为utf-8
//    produces={"text/plain;charset=UTF-8"}
    @RequestMapping(value = "/login.do",method = RequestMethod.POST)
    public String login(String username, String password,HttpServletRequest request)  {
        System.out.println(username);
        System.out.println(password);
//        User userold=null;
       //调用loginService的业务
//        userold=(User) request.getSession().getAttribute("user");
//        if(userold!=null) {
//            if (userold.getUsername().equals(username)) {
//                request.setAttribute("MSG", "用户已登录");
//                return "index";
//            }
//        }
        User login= userService.queryByusername(username);
        //不存在用户判断
     if(login==null){
         request.setAttribute("MSG","用户不存在");
         return "login";
     }
        //进行密码判断
        //密码判断
        if(password.equals(login.getPassword())){
            //将用户信息存入session
            request.getSession().setAttribute("user",login);
            //返回姓名
            request.setAttribute("name",login.getName());
            //取出roleId
            int roleId=login.getRoleId();
            System.out.println(roleId);
            //菜单查询
            List<Menu> menuList= menuService.queryByRoleId(roleId);
            //权限列表悉数返回
            request.setAttribute("menuList",menuList);
            System.out.println(menuList);
            //成功则页面跳转
            return "system/user/main2";
        }
        //密码错误则停留原界面
        return "login";
    }

//    @RequestMapping(value = "register.do",method = RequestMethod.POST)
//    public  String register(User user, HttpServletRequest request){
//        //接受请求，调用业务，跳转界面
//        //调用新增用户，调用判断，判断是否用户名重复
//        if(userService.queryByusername(user.getUsername())!=null){
//            request.setAttribute("MSG","用户名已被注册");
//        }
//        else {
//            userService.InsertUser(user);
//            request.setAttribute("MSG", "添加成功");
//        }
//        return "index";
//    }

//    @RequestMapping(value = "information.do",method = RequestMethod.GET)
//    public  String getLoginInformation(HttpServletRequest request){
//        User user=(User) request.getSession().getAttribute("user");
//        request.setAttribute("user",user);
//        return "PerInformation";
//    }
//
//    @RequestMapping(value = "updatePerson.do",method = RequestMethod.POST)
//    public String updatePerson(User user,HttpServletRequest request){
//          User user1=(User) request.getSession().getAttribute("user");
//          menuService.updatePersonal(user);
//          //用户名与密码均未修改
//          if (user1.getUsername().equals(user.getUsername())&&user1.getPassword().equals(user.getPassword())){
//              request.setAttribute("name",user.getName());
//              //取出roleId
//              int roleId=user1.getRole();
//              List<Duty> dutyList= menuService.queryByRoleId(roleId);
//              //权限列表悉数返回
//              request.setAttribute("dutyList",dutyList);
//              return "welcome";
//          }else
//              return "index";
//    }


    @RequestMapping("/loginout.do")
    public String loginOut(){
        return "login";
    }

}

