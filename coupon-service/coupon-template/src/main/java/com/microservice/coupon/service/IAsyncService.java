package com.microservice.coupon.service;

import com.microservice.coupon.entity.CouponTemplate;

public interface IAsyncService {

    void asyncConstructCouponByTemplate(CouponTemplate template);
}
