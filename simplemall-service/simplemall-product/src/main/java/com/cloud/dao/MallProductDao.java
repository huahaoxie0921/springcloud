package com.cloud.dao;

import com.cloud.entity.MallProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MallProductDao extends JpaRepository<MallProduct, Long> {
}
