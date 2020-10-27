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


## Technology

| Technology             | Description               | Official Website                                  |
| ---------------------- | ------------------------- | ------------------------------------------------- |
| Spring Cloud           | Microservice Framework    | https://spring.io/projects/spring-cloud           |
| Spring Cloud Netflix   | Microservice Framework    | https://spring.io/projects/spring-cloud-netflix   |
| Spring Security        | Security Framework        | https://spring.io/projects/spring-security        |
| Spring Boot            | Container + MVC Framework | https://spring.io/projects/spring-boot            |
| Spring Data JPA        | ORM Framework             | https://spring.io/projects/spring-data-jpa        |
| Kafka                  | Message Queue             | https://kafka.apache.org/                         |
| Redis                  | Cache                     | https://redis.io/                                 |
| MySQL                  | MySql Database            | https://www.mysql.com/                            |
| JWT                    | Json Web Token            | https://github.com/jwtk/jjwt                      |
| Lombok                 | Java library              | https://projectlombok.org/                        |
| Docker                 | Image Container           | https://www.docker.com/                           |

## TODO
- Add Demo Front End Page
- Add Permission Module
- Add Docker Configuration
