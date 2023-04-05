package com.lottecard.myd.test.controller;

import javax.validation.Valid;

import org.apache.ibatis.exceptions.IbatisException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lottecard.myd.cmn.model.ResponseCode;
import com.lottecard.myd.cmn.model.dto.ResponseDTO;
import com.lottecard.myd.test.model.dto.TestDTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;


@RestController
@Api(tags = "[SAMPLE] TESTCONTROLLER")
public class TestController {

	@ApiOperation(value = "GET Method SAMPLE", notes = "DESCRIPTION", response = ResponseDTO.class)
	@GetMapping(value="/test")
	public ResponseDTO test() {
		ResponseDTO res = new ResponseDTO();
		res.setCode(ResponseCode.TEST_SUCCESS.getKey());
		res.setMessage(ResponseCode.TEST_SUCCESS.getValue());
		
		return res;
	}


	@ApiOperation(value = "POST Method SAMPLE", notes = "DESCRIPTION", response = ResponseDTO.class)
	@PostMapping(value="/test")
	public ResponseDTO testb(@Valid @RequestBody TestDTO testDTO) {
		ResponseDTO res = new ResponseDTO();
		res.setCode(ResponseCode.TEST_SUCCESS.getKey());
		res.setMessage(ResponseCode.TEST_SUCCESS.getValue());
		
		return res;
	}

	/*
	 * @ApiIgnore 사용 시 문서상에 표시되지 않음
	 * */
	@ApiIgnore
    @GetMapping("/LoggingTest")
    public String Logging(){
        return "Logging Test Success";
    }
}
