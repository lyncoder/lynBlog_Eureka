package com.lynsite.blog.service.impl;

import com.lynsite.blog.dao.UserMapper;
import com.lynsite.blog.entity.User;
import com.lynsite.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: TODO
 * @Author: 刘亚楠
 * @Date: 2019/3/16 15:22
 * @Version: 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User queryUserById(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<User> queryUserByIds(List<Long> ids) {
        List<User> users = new ArrayList<>();
        ids.forEach(id -> {
            users.add(userMapper.selectByPrimaryKey(id));
        });
        return users;
    }

    @Override
    public List<User> selectAll() {
        return userMapper.selectAll();
    }

    //    @Override
//    public List<User> queryAllUsers() {
//        return userMapper.selectByExample();
//    }
}
