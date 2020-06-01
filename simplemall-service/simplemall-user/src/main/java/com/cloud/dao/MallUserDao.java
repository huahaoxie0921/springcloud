package com.cloud.dao;

import com.cloud.entity.MallUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MallUserDao extends JpaRepository<MallUser, Long> {

    MallUser findByUsername(String username);

}
