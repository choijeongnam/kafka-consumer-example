package com.lottecard.controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lottecard.dto.ResponseDTO;
import com.lottecard.dto.TestDTO;

@RestController
public class TestController {

	@PostMapping(value = "/test")
	public ResponseDTO test(@RequestBody @Valid TestDTO testDTO) {
		
		System.err.println(testDTO.getName());
		System.err.println(testDTO.getValue());
		ResponseDTO res = new ResponseDTO();
		//res.setCode(200);
		//res.setMessage("Sucess");
		return res;
	}
}
