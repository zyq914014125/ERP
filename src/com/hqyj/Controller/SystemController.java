package com.hqyj.Controller;

import com.hqyj.Service.*;
import com.hqyj.entity.*;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/system")
public class SystemController {
    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;
    @Autowired
    MenuService menuService;
    @Autowired
    LeaveService leaveService;
    @Autowired
    PunchService punchService;
    @RequestMapping("/user.do")
    public String user(HttpServletRequest request){
        User user=(User) request.getSession().getAttribute("user");
        List<User> userList=userService.queryByRoleId(user.getRoleId());
        request.setAttribute("userList",userList);
        return "user/people";
    }

    @RequestMapping("/role.do")
    public String role(Model model){
        List<Role> roleList=roleService.query();
        model.addAttribute("roleList",roleList);
        return "role/roleList";
    }

    @RequestMapping("/menu.do")
    public String menu(Model model){
        List<Menu> menuLis=menuService.query();
        model.addAttribute("menuLis",menuLis);
        return "menu/menuList";
    }

    @RequestMapping("/punch.do")
    public String punch(Model model){
        //获取未处理请假信息，以及今日打卡信息
        List<Leave> leaveList=leaveService.getUntreatedLeave();
        List<Leave> leaves=leaveService.getAllLeave();
        List<Punch> punches=punchService.getPunches();
        //总人数
        int Count=userService.CountAllUsers();
        //反馈给前端
        model.addAttribute("leaveList",leaveList);
        model.addAttribute("punches",punches);
        model.addAttribute("leaves",leaves);
        model.addAttribute("count",Count);
        return "console/punch";
    }
/*
* state 0表示请假提交
* */
    @RequestMapping("/leave.do")
    public String leave(){
        return "console/leaves";
    }
    @RequestMapping("/apply.do")
    public String LeaveApply(Leave leave,HttpServletRequest request){
        User user=(User) request.getSession().getAttribute("user");
        leave.setUserId(user.getUser_id());
        leaveService.insert(leave);
        return "console/success";
    }
    @RequestMapping("/leavesList.do")
    public String getLeaveList(Model model){
        List<Leave> leaves=leaveService.getAllLeaveAndUser();
        model.addAttribute("leaves",leaves);
        return "console/LeavesList";
    }
    @RequestMapping("/update.do")
    public String leaveUpdate(String leaveId){
        leaveService.update(Integer.parseInt(leaveId));
        System.out.println(leaveId);
        return "redirect:leavesList.do";
    }

    @RequestMapping("/person.do")
    public String person(HttpServletRequest request,Model model){
        User user=(User)request.getSession().getAttribute("user");
        model.addAttribute("user",user);
        return "user/personal";
    }
    @RequestMapping("/updatePerson.do")
    public String updatePerson(User user,Model model){
        System.out.println(user);
        userService.update(user);
        User login= userService.queryByusername(user.getUsername());
        model.addAttribute("user",login);
        return "user/personal";
    }
    @RequestMapping(value = "/pick.ajax",produces={"text/plain;charset=UTF-8"})
    @ResponseBody
    public String pick(HttpServletRequest request){
        User user=(User)request.getSession().getAttribute("user");
        if(punchService.getNow(user)==null) {
            punchService.insert(user);
            return "已打卡";
        }else
            return "请勿重复打卡";
    }

}
