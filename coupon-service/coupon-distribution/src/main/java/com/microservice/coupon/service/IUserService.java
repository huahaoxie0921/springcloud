package com.microservice.coupon.service;

import com.microservice.coupon.entity.Coupon;
import com.microservice.coupon.exception.CouponException;
import com.microservice.coupon.vo.AcquireTemplateRequest;
import com.microservice.coupon.vo.CouponTemplateSDK;
import com.microservice.coupon.vo.SettlementInfo;

import java.util.List;

public interface IUserService {

    List<Coupon> findCouponsByStatus(Long userId, Integer status)
            throws CouponException;

    List<CouponTemplateSDK> findAvailableTemplate(Long userId)
        throws CouponException;

    Coupon acquireTemplate(AcquireTemplateRequest request)
            throws CouponException;

    SettlementInfo settlement(SettlementInfo info) throws CouponException;
}
