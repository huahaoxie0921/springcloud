package com.cloud.client;

import com.cloud.ProductInfo;
import com.cloud.ProductInfosRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(value = "eureka-client-product", fallback = ProductClientHystrix.class)
public interface ProductClient {

    @GetMapping(value = "/simplemall-product/get/product")
    ProductInfo getProductInfo(Long id);

    @PostMapping(value = "/simplemall-product/get/products")
    List<ProductInfo> getProductInfos(@RequestBody ProductInfosRequest request);
}
