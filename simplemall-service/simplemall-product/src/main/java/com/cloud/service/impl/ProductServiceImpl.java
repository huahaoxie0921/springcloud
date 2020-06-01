package com.cloud.service.impl;

import com.cloud.ProductInfo;
import com.cloud.ProductInfosRequest;
import com.cloud.dao.MallProductDao;
import com.cloud.entity.MallProduct;
import com.cloud.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final MallProductDao mallProductDao;

    @Autowired
    public ProductServiceImpl(MallProductDao mallProductDao) {
        this.mallProductDao = mallProductDao;
    }


    @Override
    public ProductInfo getProductInfo(Long id) {
        Optional<MallProduct> course = mallProductDao.findById(id);
        return buildProductInfo(course.orElse(MallProduct.invalid()));
    }

    @Override
    public List<ProductInfo> getProductInfos(ProductInfosRequest request) {
        if (CollectionUtils.isEmpty(request.getIds())) {
            return Collections.emptyList();
        }

        List<MallProduct> products = mallProductDao.findAllById(request.getIds());
        return products.stream().map(this::buildProductInfo).collect(Collectors.toList());
    }

    public ProductInfo buildProductInfo(MallProduct product) {
        return ProductInfo.builder().id(product.getId())
                .productName(product.getProductName())
                .productType(product.getProductType())
                .productIcon(product.getProductIcon())
                .productIntro(product.getProductIntro())
                .build();
    }
}