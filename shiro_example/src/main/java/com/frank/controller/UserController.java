package com.frank.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/list")
    @RequiresPermissions("user:user")
    public String userList(Model model) {
        model.addAttribute("value", "获取用户信息");
        return "user";
    }

    @RequestMapping("/add")
    @RequiresPermissions("user:add")
    public String addUser(Model model) {
        model.addAttribute("value", "新增用户信息");
        return "user";
    }

    @RequestMapping("/delete")
    @RequiresPermissions("user:delete")
    public String deleteUser(Model model) {
        model.addAttribute("value", "删除用户信息");
        return "user";
    }
}
