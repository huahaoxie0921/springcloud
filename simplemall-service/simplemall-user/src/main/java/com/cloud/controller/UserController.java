package com.cloud.controller;

import com.alibaba.fastjson.JSON;
import com.cloud.UserInfo;
import com.cloud.service.UserService;
import com.cloud.vo.CreateUserRequest;
import com.cloud.vo.UserProductInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create/user")
    public UserInfo createUser(@RequestBody CreateUserRequest request) {

        log.info("<mall-user>: create user -> {}", JSON.toJSONString(request));
        return userService.createUser(request);
    }

    @GetMapping("/get/user")
    public UserInfo getUserInfo(Long id) {

        log.info("<mall-user>: get user -> {}", id);
        return userService.getUserInfo(id);
    }

    @GetMapping("/get/user/product")
    public UserProductInfo getUserProductInfo(Long id) {

        log.info("<mall-user>: get user mall info -> {}", id);
        return userService.getUserProductInfo(id);
    }
}
