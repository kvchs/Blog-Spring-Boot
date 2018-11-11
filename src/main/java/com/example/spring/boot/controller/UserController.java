package com.example.spring.boot.controller;

import com.example.spring.boot.dao.User;
import com.example.spring.boot.repository.UserReository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserReository userReository;

    /**
     * 查询所有用户
     * @param model
     * @return
     */
    @GetMapping
    public ModelAndView list(Model model){
        model.addAttribute("userList", userReository.listUsers());
        model.addAttribute("title", "用户管理");
        return new ModelAndView("users/list", "userModel" , model);
    }

    /**
     * 根据id查询用户信息
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/{id}")
    public ModelAndView view(@PathVariable("id") Long id, Model model){
        model.addAttribute("userList", userReository.getUserById(id));
        model.addAttribute("title", "查看用户");
        return new ModelAndView("users/view", "userModel" , model);
    }

    /**
     * 获取创建表单页面
     *
     * @param model
     * @return
     */
    @GetMapping("/form")
    public ModelAndView createForm(Model model){
        model.addAttribute("user", new User());
        model.addAttribute("title", "创建用户");
        return new ModelAndView("users/form", "userModel" , model);
    }

    @PostMapping
    public ModelAndView saveOrUpdateUser(User user){
        userReository.saveOrUpdateUser(user);
        return new ModelAndView("redirect:/users");
    }
}

