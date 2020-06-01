package com.cloud.service;

import com.cloud.ProductInfo;
import com.cloud.ProductInfosRequest;

import java.util.List;

public interface ProductService {

    ProductInfo getProductInfo(Long id);

    List<ProductInfo> getProductInfos(ProductInfosRequest request);
}