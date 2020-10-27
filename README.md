# eCoupon

## Project Overview

This project is a microservice web application using Spring Boot, Spring Cloud, Spring Data JPA, Redis, and Kafka. This `eCoupon` project provides coupon functionalities that can be used as an add-on component to the existing eCommerce platform.

## Modules Structures

``` lua
eCoupon
├── eureka -- Eureka Server (Eureka Service registry)
├── gateway -- API Gateway Service using Spring Cloud Zuul & Feign
├── coupon-service
    ├── coupon-common -- Utils and common code module
    ├── coupon-template -- Coupon template generation Service
    └── coupon-distribution -- Coupon Distribution Service
```
