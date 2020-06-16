package com.microservice.coupon.service;

import com.microservice.coupon.entity.Coupon;
import com.microservice.coupon.exception.CouponException;

import java.util.List;

public interface IRedisService {

    List<Coupon> getCachedCoupons(Long userId, Integer status);

    void saveEmptyCouponListToCache(Long userId, List<Integer> status);

    String tryToAcquireCouponCodeFromCache(Integer templateId);

    Integer addCouponToCache(Long userId, List<Coupon> coupons,
                             Integer status) throws CouponException;
}
