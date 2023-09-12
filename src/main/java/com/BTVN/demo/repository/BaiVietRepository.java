package com.BTVN.demo.repository;

import com.BTVN.demo.entity.BaiVietEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BaiVietRepository extends JpaRepository<BaiVietEntity, Integer> {
}
