package com.cloud.dao;

import com.cloud.entity.MallUserProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MallUserProductDao extends JpaRepository<MallUserProduct, Long> {
    List<MallUserProduct> findAllByUserId(Long userId);
}
