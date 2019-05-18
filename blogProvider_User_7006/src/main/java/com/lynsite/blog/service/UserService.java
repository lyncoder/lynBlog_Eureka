package com.lynsite.blog.service;

import com.lynsite.blog.entity.User;
import java.util.List;

/**
 * @Description: TODO
 * @Author: 刘亚楠
 * @Date: 2019/3/6 13:52
 * @Version: 1.0
 */
public interface UserService {

    User queryUserById(Long id);

    List<User> queryUserByIds(List<Long> ids);

    List<User> selectAll();

//    List<User> queryAllUsers();

}
