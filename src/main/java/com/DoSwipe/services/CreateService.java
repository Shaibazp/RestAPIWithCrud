package com.DoSwipe.services;

import java.util.List;

import com.DoSwipe.entity.ProductInfo;

public interface CreateService {
	
	Integer saveProduct(ProductInfo productInfo);
	List<ProductInfo> getAllProduct();
	ProductInfo getOneProduct(Integer id);
	void deletProduct(Integer id);
	void updateProduct(ProductInfo productInfo);

}
