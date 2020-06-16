package com.microservice.coupon.service.impl;

import com.microservice.coupon.dao.CouponTemplateDao;
import com.microservice.coupon.entity.CouponTemplate;
import com.microservice.coupon.exception.CouponException;
import com.microservice.coupon.service.IAsyncService;
import com.microservice.coupon.service.IBuildTemplateService;
import com.microservice.coupon.vo.TemplateRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BuildTemplateServiceImpl implements IBuildTemplateService {

    private final IAsyncService asyncService;

    private final CouponTemplateDao templateDao;

    @Autowired
    public BuildTemplateServiceImpl(IAsyncService asyncService,
                                    CouponTemplateDao templateDao) {
        this.asyncService = asyncService;
        this.templateDao = templateDao;
    }

    @Override
    public CouponTemplate buildTemplate(TemplateRequest request)
            throws CouponException {

        if (!request.validate()) {
            throw new CouponException("BuildTemplate Param Is Not Valid!");
        }

        if (null != templateDao.findByName(request.getName())) {
            throw new CouponException("Exist Same Name Template!");
        }

        CouponTemplate template = requestToTemplate(request);
        template = templateDao.save(template);

        asyncService.asyncConstructCouponByTemplate(template);

        return template;
    }

    private CouponTemplate requestToTemplate(TemplateRequest request) {

        return new CouponTemplate(
                request.getName(),
                request.getLogo(),
                request.getDesc(),
                request.getCategory(),
                request.getProductLine(),
                request.getCount(),
                request.getUserId(),
                request.getTarget(),
                request.getRule()
        );
    }
}
