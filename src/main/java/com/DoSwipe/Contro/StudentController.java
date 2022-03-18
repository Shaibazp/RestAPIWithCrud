package com.DoSwipe.Contro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DoSwipe.ProductException.ProductNotFountException;
import com.DoSwipe.entity.ProductInfo;
import com.DoSwipe.services.implementService;

@RestController
@RequestMapping("/rest/stud")
public class StudentController {

	@Autowired
	private implementService implementService;

	@GetMapping("/msg")
	public ResponseEntity<String> getMsg()
	{
		{
			return new ResponseEntity<String>("Hiii",HttpStatus.OK);
		}
	}
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
}
