package com.DoSwipe.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.DoSwipe.entity.ProductInfo;

public interface ProductRepo extends JpaRepository<ProductInfo, Integer>{

	@Modifying
	@Query(value = "UPDATE product SET prodcost=:cost WHERE prodid=:id", nativeQuery = true)
	void modifyCodeById( String cost,  Integer id);//@Param("id")   @Param("cost")
}
