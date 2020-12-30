package com.hqyj.Controller;

import com.hqyj.Service.UserService;
import com.hqyj.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/system")
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping(value = "/user/add.ajax",method = RequestMethod.POST)
    @ResponseBody
    public User add(User user) {
        if (userService.queryByusername(user.getUsername()) == null) {
            userService.insert(user);
            User user1=userService.queryByusername(user.getUsername());
            System.out.println(user1);
            return user1;
        } else
            return new User();
    }

    /**
     * @param user_id 用户id，url上携带
     * @return  return "redirect:system/user.do"; 重定向到访问员工管理
     */
    @RequestMapping("/user/delete.do")
    public String delete(@RequestParam("user_id")int user_id){
        userService.delete(user_id);
        return "redirect:/system/user.do";
    }


    @RequestMapping("/user/update.do")
    public String update(User user){
        userService.update(user);
        return "redirect:/system/user.do";
    }

}
