package com.microservice.coupon.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;
import java.util.stream.Stream;

@Getter
@AllArgsConstructor
public enum CouponCategory {

    PRICEBREAK("Price-break Coupon", "001"),
    RATEDISCOUNT("Rate off Discount Coupon", "002"),
    MONEYDISCOUNT("Money off Discount Coupon", "003");

    private String description;

    private String code;

    public static CouponCategory of(String code) {

        Objects.requireNonNull(code);

        return Stream.of(values())
                .filter(bean -> bean.code.equals(code))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(code + " not exists!"));
    }
}
