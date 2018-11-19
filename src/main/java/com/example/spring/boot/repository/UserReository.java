package com.example.spring.boot.repository;

import com.example.spring.boot.dao.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * User Repository接口
 */
public interface UserReository extends CrudRepository<User, Long> {

}
