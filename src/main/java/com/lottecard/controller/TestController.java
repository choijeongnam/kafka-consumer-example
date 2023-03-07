package com.lottecard.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lottecard.dto.ResponseDTO;
import com.lottecard.dto.TestDTO;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;

@RestController
public class TestController {

	@PostMapping(value = "/test")
	@ApiImplicitParams({
           @ApiImplicitParam(name = "name", required = true, dataType = "string", paramType = "path"),
           @ApiImplicitParam(name = "age", required = true, dataType = "string", paramType = "query")
   })
	public ResponseDTO test(TestDTO testDTO) {
		ResponseDTO res = new ResponseDTO();
		//res.setCode(200);
		//res.setMessage("Sucess");
		return res;
	}
}
