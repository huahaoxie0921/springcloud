package com.microservice.coupon.service;

import com.microservice.coupon.entity.CouponTemplate;
import com.microservice.coupon.exception.CouponException;
import com.microservice.coupon.vo.CouponTemplateSDK;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface ITemplateBaseService {

    CouponTemplate buildTemplateInfo(Integer id) throws CouponException;

    List<CouponTemplateSDK> findAllUsableTemplate();

    Map<Integer, CouponTemplateSDK> findIds2TemplateSDK(Collection<Integer> ids);
}
