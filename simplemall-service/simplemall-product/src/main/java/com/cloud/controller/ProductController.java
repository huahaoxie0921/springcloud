package com.cloud.controller;

import com.alibaba.fastjson.JSON;
import com.cloud.ProductInfo;
import com.cloud.ProductInfosRequest;
import com.cloud.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    /* GET
    localhost:7001/simplemall-product/get/product?id=
    localhost:9000/simplemall/simple-mall/get/product?id=
     */
    @GetMapping("/get/product")
    public ProductInfo getProductInfo(Long id) {

        log.info("<simplemall-product>: get product -> {}", JSON.toJSONString(id));
        return productService.getProductInfo(id);
    }

    /* POST
    localhost:7001/simplemall-product/get/products
    localhost:9000/simplemall/simplemall-product/get/products
     */
    @PostMapping("/get/products")
    public List<ProductInfo> getProductsInfos(@RequestBody ProductInfosRequest request) {

        log.info("<simplemall-products>: get products -> {}", JSON.toJSONString(request));
        return productService.getProductInfos(request);
    }
}
