package com.DoSwipe.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.DoSwipe.entity.ProductInfo;

public interface ProductRepo extends JpaRepository<ProductInfo, Integer>{

}
