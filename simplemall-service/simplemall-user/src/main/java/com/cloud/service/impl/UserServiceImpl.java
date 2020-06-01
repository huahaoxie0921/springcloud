package com.cloud.service.impl;

import com.cloud.ProductInfo;
import com.cloud.ProductInfosRequest;
import com.cloud.UserInfo;
import com.cloud.client.ProductClient;
import com.cloud.dao.MallUserDao;
import com.cloud.dao.MallUserProductDao;
import com.cloud.entity.MallUser;
import com.cloud.entity.MallUserProduct;
import com.cloud.service.UserService;
import com.cloud.vo.CreateUserRequest;
import com.cloud.vo.UserProductInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    private final MallUserDao mallUserDao;

    private final MallUserProductDao mallUserProductDao;

    private final ProductClient productClient;

    @Autowired
    public UserServiceImpl(MallUserDao mallUserDao, MallUserProductDao mallUserProductDao, ProductClient productClient) {
        this.mallUserDao = mallUserDao;
        this.mallUserProductDao = mallUserProductDao;
        this.productClient = productClient;
    }

    @Override
    public UserInfo createUser(CreateUserRequest request) {

        if (!request.validate()) {
            return UserInfo.invalid();
        }

        MallUser oldUser = mallUserDao.findByUsername(request.getUsername());
        if (null != oldUser) {
            return UserInfo.invalid();
        }

        MallUser newUser = mallUserDao.save(new MallUser(request.getUsername(), request.getEmail()));

        return new UserInfo(newUser.getId(), newUser.getUsername(), newUser.getEmail());
    }

    @Override
    public UserInfo getUserInfo(Long id) {

        Optional<MallUser> user = mallUserDao.findById(id);
        if (!user.isPresent()) {
            return UserInfo.invalid();
        }

        MallUser curUser = user.get();
        return new UserInfo(curUser.getId(), curUser.getUsername(), curUser.getEmail());
    }

    @Override
    public UserProductInfo getUserProductInfo(Long id) {

        Optional<MallUser> user = mallUserDao.findById(id);
        if (!user.isPresent()) {
            return UserProductInfo.invalid();
        }

        MallUser homepageUser = user.get();
        UserInfo userInfo = new UserInfo(homepageUser.getId(), homepageUser.getUsername(), homepageUser.getEmail());

        List<MallUserProduct> userCourses = mallUserProductDao.findAllByUserId(id);
        if (CollectionUtils.isEmpty(userCourses)) {
            return new UserProductInfo(userInfo, Collections.emptyList());
        }

        List<ProductInfo> courseInfos = productClient.getProductInfos(
                new ProductInfosRequest(userCourses.stream().map(MallUserProduct::getCourseId).collect(Collectors.toList()))
        );

        return new UserProductInfo(userInfo, courseInfos);
    }
}
