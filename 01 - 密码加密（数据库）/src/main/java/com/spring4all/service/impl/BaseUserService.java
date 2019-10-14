package com.spring4all.service.impl;

import com.spring4all.entity.UserDO;
import com.spring4all.repository.UserRepository;
import com.spring4all.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Primary
@Slf4j
public class BaseUserService implements UserService {

    @Resource
    BCryptPasswordEncoder passwordEncoder;

    @Resource
    private UserRepository userRepository;

    @Override
    public void insert(UserDO userDO) {
        String username = userDO.getUsername();
        if (exist(username)) {
            throw new RuntimeException("用户名已存在！");
        }
        // 随机使用加密方式
        String encodePwd = passwordEncoder.encode(userDO.getPassword());
        userDO.setPassword(encodePwd);
        userRepository.save(userDO);
    }

    @Override
    public UserDO getByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    /**
     * 判断用户是否存在
     */
    private boolean exist(String username) {
        UserDO userDO = userRepository.findByUsername(username);
        return (userDO != null);
    }

}
