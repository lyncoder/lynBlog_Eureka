package com.lynsite.blog.controller;

import com.lynsite.blog.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: TODO
 * @Author: 刘亚楠
 * @Date: 2019/3/19 16:57
 * @Version: 1.0
 */
@RestController
@RequestMapping("user")
public class UserController {

    private static String REST_URL_PREFIX = "http://PROVIDERUSER";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/get/{id}")
    public User queryUserById(@PathVariable("id") long id){
        return restTemplate.getForObject(REST_URL_PREFIX + "/user/get/" + id, User.class);
    }

    @GetMapping("/gets/{ids}")
    public List<User> queryUsersByIds(@PathVariable("ids") List<Long> ids){
        List<User> users = new ArrayList<>();
        ids.forEach(id -> {
            users.add(restTemplate.getForObject(REST_URL_PREFIX + "/user/get/" + id, User.class));
        });
        return users;
    }

    @GetMapping("/list")
    public List<User> queryAllUsers(){
        return restTemplate.getForObject(REST_URL_PREFIX + "/user/list", List.class);
    }



}
