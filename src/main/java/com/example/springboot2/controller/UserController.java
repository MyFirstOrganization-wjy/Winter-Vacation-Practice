package com.example.springboot2.controller;

import com.example.springboot2.mapper.UserMapper;
import com.example.springboot2.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserMapper userMapper;

    @RequestMapping("update")
    public ModelAndView update(@RequestParam("id") Integer id, ModelAndView mv) {
        User user = userMapper.findUserById(id);
        mv.addObject("user",user);
        mv.setViewName("update");
        return mv;
    }

    @PostMapping("do_update")
    public ModelAndView updateUserById(User user, ModelAndView mv) {
        System.out.println(user.getId());
        userMapper.updateUserById(user);
        System.out.println(user.getId());
        System.out.println(user.getUsername());
        mv.setViewName("redirect:select");
        return mv;
    }

    @RequestMapping("select")
    public ModelAndView selectAll(ModelAndView mv) {
        List<User> list = userMapper.selectAll();
        mv.addObject("users", list);
        mv.setViewName("selectAll");
        return mv;
    }
}