package com.hqyj.Controller;

import com.hqyj.Service.MenuService;
import com.hqyj.entity.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/system")
public class menuController {
    @Autowired
    MenuService menuService;


    @RequestMapping(value = "/menu/update.do",method = RequestMethod.POST)
    public String update(Menu menu){
        menuService.update(menu);
        return "redirect:/system/menu.do";
    }
    @RequestMapping("/menu/delete.do")
    public String delete(@RequestParam("menuId")int menuId){
        menuService.delete(menuId);
        return "redirect:/system/menu.do";
    }

}
