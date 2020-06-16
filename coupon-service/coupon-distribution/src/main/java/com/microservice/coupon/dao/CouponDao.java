package com.microservice.coupon.dao;

import com.microservice.coupon.constant.CouponStatus;
import com.microservice.coupon.entity.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CouponDao extends JpaRepository<Coupon, Integer> {

    List<Coupon> findAllByUserIdAndStatus(Long userId, CouponStatus status);
}
