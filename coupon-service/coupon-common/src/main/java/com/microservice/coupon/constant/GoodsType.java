package com.microservice.coupon.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;
import java.util.stream.Stream;

@Getter
@AllArgsConstructor
public enum GoodsType {

    ENTERTAIN("ENTERTAIN", 1),
    FRESH("FRESH", 2),
    HOME("HOME", 3),
    OTHERS("OTHERS", 4),
    ALL("ALL", 5);

    private String description;

    private Integer code;

    public static GoodsType of(Integer code) {

        Objects.requireNonNull(code);

        return Stream.of(values())
                .filter(bean -> bean.code.equals(code))
                .findAny()
                .orElseThrow(
                        () -> new IllegalArgumentException(code + " not exists!")
                );
    }
}
