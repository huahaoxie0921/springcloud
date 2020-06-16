package com.microservice.coupon.service;

import com.microservice.coupon.entity.CouponTemplate;
import com.microservice.coupon.exception.CouponException;
import com.microservice.coupon.vo.TemplateRequest;

public interface IBuildTemplateService {

    CouponTemplate buildTemplate(TemplateRequest request)
            throws CouponException;
}
