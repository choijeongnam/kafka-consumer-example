package com.lottecard.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lottecard.dto.ResponseDTO;
import com.lottecard.dto.TestDTO;

@RestController
public class TestController {

	@PostMapping(value = "/test")
	public ResponseDTO test(TestDTO testDTO) {
		ResponseDTO res = new ResponseDTO();
		res.setCode(200);
		res.setMessage("Sucess");
		return res;
	}
}
