package com.example.spring.boot.repository;

import com.example.spring.boot.dao.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class UserReositoryImpl implements UserReository {

    // https://www.jianshu.com/p/8f7b2cd34c47 ConcurrentMap技术讲解
    private final ConcurrentMap<Long, User> userMap = new ConcurrentHashMap<>();
    // 每次增加一个用户，计数器加1
    private static AtomicLong counter = new AtomicLong();


    @Override
    public User saveOrUpdateUser(User user) {
        Long id = user.getId();
        if (id == null) {
            id = counter.incrementAndGet();
            user.setId(id);
        }

        userMap.put(id, user);
        return user;
    }

    @Override
    public void deleteUser(Long id) {
        userMap.remove(id);
    }

    @Override
    public User getUserById(Long id) {
        return userMap.get(id);
    }

    @Override
    public List<User> listUsers() {
        return new ArrayList<User>(userMap.values()) ;
    }
}
