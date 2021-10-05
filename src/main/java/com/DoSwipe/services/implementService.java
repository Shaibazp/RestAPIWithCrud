package com.DoSwipe.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.DoSwipe.ProductException.ProductNotFountException;
import com.DoSwipe.entity.ProductInfo;
import com.DoSwipe.repo.ProductRepo;
@Service
public class implementService implements CreateService {

	@Autowired
	private ProductRepo productRepo;
	

	public Integer saveProduct(ProductInfo productInfo) {
		double tot = productInfo.getProdCost()*productInfo.getProdQnt();
		productInfo.setProdTotal(tot);
		return productRepo.save(productInfo).getProid();
	}


	public List<ProductInfo> getAllProduct() {
		// TODO Auto-generated method stub
		return productRepo.findAll();
	}


	public ProductInfo getOneProduct(Integer id) {
		// TODO Auto-generated method stub
		return productRepo.findById(id).orElseThrow(()->new ProductNotFountException(id+" Product Not Fount"));
	}


	public void deletProduct(Integer id) {
		productRepo.delete(getOneProduct(id));

	}


	public void updateProduct(ProductInfo productInfo) {
		
		if(productInfo.equals(null) || !productRepo.existsById(productInfo.getProid()))
		{
			throw new ProductNotFountException("Product Not Exists.....");
		}
		else
		{
			productRepo.save(productInfo);
		}
	}

	@Transactional
	public void modifyCodeById(String cost, Integer id) {
		if(!productRepo.existsById(id))
		{
			throw new ProductNotFountException("Product Not Available");
		}
		else
		{
			productRepo.modifyCodeById(cost, id);
		}
	}

}
