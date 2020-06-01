package com.cloud.vo;

import com.cloud.ProductInfo;
import com.cloud.UserInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserProductInfo {

    private UserInfo userInfo;
    private List<ProductInfo> productInfos;

    public static UserProductInfo invalid() {

        return new UserProductInfo(
                UserInfo.invalid(),
                Collections.emptyList()
        );
    }
}
