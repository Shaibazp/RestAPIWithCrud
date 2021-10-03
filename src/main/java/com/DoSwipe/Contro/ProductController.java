package com.DoSwipe.Contro;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DoSwipe.ProductException.ProductNotFountException;
import com.DoSwipe.entity.ProductInfo;
import com.DoSwipe.services.implementService;

@RestController
@RequestMapping("/prod")
public class ProductController {
	@Autowired
	private implementService implementService;

	@PostMapping("/save")
	public ResponseEntity<String> prodsave(@RequestBody ProductInfo info)
	{
		ResponseEntity<String> res=null;
		Integer id = implementService.saveProduct(info);
		try
		{
			res = new ResponseEntity<String>(id+ " - Product Add Successfull",HttpStatus.CREATED);
		}
		catch (ProductNotFountException e) 
		{
			//e.printStackTrace();
			 res = new ResponseEntity<String>("Not Ctrated",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return res;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<ProductInfo>> getAllProduct()
	{
		ResponseEntity<List<ProductInfo>> res = null;
		List<ProductInfo> list = implementService.getAllProduct();
		res = new ResponseEntity<List<ProductInfo>>(list,HttpStatus.OK);
		return res;
	}
	
	@GetMapping("/findOne/{id}")
	public ResponseEntity<?> findOne(@PathVariable int id)
	{
		ResponseEntity<?> res = null;
		try
		{
			ProductInfo pro = implementService.getOneProduct(id);
			res = new ResponseEntity<ProductInfo>(pro,HttpStatus.OK);
		}
		catch (ProductNotFountException e) {
			e.printStackTrace();
			//throw e;
			res = new ResponseEntity<String>(id+" - Product Not Found",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return res;
	}
	
	@DeleteMapping("/deleted/{id}")
	public ResponseEntity<String> deletedOne(@PathVariable int id)
	{
		ResponseEntity<String> res = null;
		try
		{
			implementService.deletProduct(id);
			res = new ResponseEntity<String>(id+" - Product Deleted",HttpStatus.OK);
		}
		catch (ProductNotFountException e) {
			e.printStackTrace();
			throw e;
			//res = new ResponseEntity<String>(id+" - Product Not Found",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return res;
	}
	
	@PutMapping("/modity")
	public ResponseEntity<String> update(@RequestBody ProductInfo info)
	{
		ResponseEntity<String> res = null;
		try
		{
			implementService.updateProduct(info);
			res = new ResponseEntity<String>(" - Product Updated",HttpStatus.OK);
		}
		catch (ProductNotFountException e) {
			e.printStackTrace();
			throw e;
			//res = new ResponseEntity<String>(id+" - Product Not Found",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return res;
	}
}
