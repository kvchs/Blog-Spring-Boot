package com.example.spring.boot.repository;

import com.example.spring.boot.dao.User;

import java.util.List;

/**
 * User Repository接口
 */
public interface UserReository {
    /**
     * 创建或者修改用户
     * @param user
     * @return
     */
    User saveOrUpdateUser(User user);

    /**
     * 删除用户
     * @param id
     */
    void deleteUser(Long id);

    /**
     * 根据id查询单个用户
     * @param id
     * @return
     */
    User getUserById(Long id);

    /**
     * 获取用户列表
     * @return
     */
    List<User> listUsers();
}
