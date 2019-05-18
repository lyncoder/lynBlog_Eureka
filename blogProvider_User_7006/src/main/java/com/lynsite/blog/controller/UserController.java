package com.lynsite.blog.controller;

import com.lynsite.blog.entity.User;
import com.lynsite.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description: TODO
 * @Author: 刘亚楠
 * @Date: 2019/3/8 11:00
 * @Version: 1.0
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/get/{id}")
    public User queryUserById(@PathVariable("id") Long id){
        System.out.println(id);
        return userService.queryUserById(id);
    }

    @GetMapping("/gets/{ids}")
    public List<User> queryUserById(@PathVariable("ids") List<Long> ids){
        return userService.queryUserByIds(ids);
    }

    @GetMapping("/list")
    public List<User> queryAllUsers(){
        return userService.selectAll();
    }

}
