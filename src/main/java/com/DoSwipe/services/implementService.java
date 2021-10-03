package com.DoSwipe.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DoSwipe.ProductException.ProductNotFountException;
import com.DoSwipe.entity.ProductInfo;
import com.DoSwipe.repo.ProductRepo;
@Service
public class implementService implements CreateService {

	@Autowired
	private ProductRepo productRepo;
	
	@Override
	public Integer saveProduct(ProductInfo productInfo) {
		double tot = productInfo.getProdCost()*productInfo.getProdQnt();
		productInfo.setProdTotal(tot);
		return productRepo.save(productInfo).getProid();
	}

	@Override
	public List<ProductInfo> getAllProduct() {
		// TODO Auto-generated method stub
		return productRepo.findAll();
	}

	@Override
	public ProductInfo getOneProduct(Integer id) {
		// TODO Auto-generated method stub
		return productRepo.findById(id).orElseThrow(()->new ProductNotFountException(id+" Product Not Fount"));
	}

	@Override
	public void deletProduct(Integer id) {
		productRepo.delete(getOneProduct(id));

	}

	@Override
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

}
