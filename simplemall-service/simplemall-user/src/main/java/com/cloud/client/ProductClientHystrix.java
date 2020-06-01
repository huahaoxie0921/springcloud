package com.cloud.client;

import com.cloud.ProductInfo;
import com.cloud.ProductInfosRequest;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class ProductClientHystrix implements ProductClient {

    @Override
    public ProductInfo getProductInfo(Long id) {
        return ProductInfo.invalid();
    }

    @Override
    public List<ProductInfo> getProductInfos(ProductInfosRequest request) {
        return Collections.emptyList();
    }
}