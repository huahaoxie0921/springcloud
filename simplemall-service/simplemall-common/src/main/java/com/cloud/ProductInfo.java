package com.cloud;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductInfo {

    private Long id;
    private String productName;
    private String productType;
    private String productIcon;
    private String productIntro;

    public static ProductInfo invalid() {

        return new ProductInfo(-1L, "", "", "", "");
    }
}
