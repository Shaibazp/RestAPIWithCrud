package com.DoSwipe.Contro;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/stud")
public class StudentController {

	@RequestMapping("/msg")
	public ResponseEntity<String> getMsg()
	{
		ResponseEntity<String> res = new ResponseEntity<String>("Hii", HttpStatus.OK);
		return res;
	}
}
