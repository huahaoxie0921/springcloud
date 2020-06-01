package com.cloud.service;


import com.cloud.UserInfo;
import com.cloud.vo.CreateUserRequest;
import com.cloud.vo.UserProductInfo;

public interface UserService {

    UserInfo createUser(CreateUserRequest request);

    UserInfo getUserInfo(Long id);

    UserProductInfo getUserProductInfo(Long id);
}

