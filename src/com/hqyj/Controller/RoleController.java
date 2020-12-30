package com.hqyj.Controller;

import com.hqyj.Service.RoleService;
import com.hqyj.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/system")
public class RoleController {
    @Autowired
    RoleService roleService;

    @RequestMapping(value = "/role/update.do",method = RequestMethod.POST)
    public String update(Role role){
        roleService.update(role);
        return "redirect:/system/role.do";
    }

    @RequestMapping("/role/delete.do")
    public String delete(@RequestParam("roleId")int roleId){
        roleService.delete(roleId);
        return "redirect:/system/role.do";
    }
}
