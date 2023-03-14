package com.lottecard.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lottecard.dto.ResponseDTO;
import com.lottecard.dto.TestDTO;
import com.lottecard.test.model.vo.COMMONCodeVO;
import com.lottecard.test.service.impl.COMMONCodeServiceImpl;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class TestController {

	@Autowired
	COMMONCodeServiceImpl cmon;
	
	@PostMapping(value = "/test")
	public ResponseDTO test(@RequestBody @Valid TestDTO testDTO) throws Exception {
		
		//MethodArgumentNotValidException은 스프링에서 제공하는 예외 클래스 중 하나로, @Valid 어노테이션을 이용하여 객체 유효성 검증을 수행할 때 발생할 수 있습니다. 유효성 검증에 실패한 경우, MethodArgumentNotValidException 예외가 발생합니다.
		//반면, HttpMessageNotReadableException은 요청 메시지를 읽을 때 발생할 수 있는 예외입니다. 예를 들어, 요청 바디가 JSON 형식이고, 해당 JSON의 필드에 필수 값이 누락된 경우 HttpMessageNotReadableException이 발생할 수 있습니다.
		//따라서 MethodArgumentNotValidException이 발생하지 않고 HttpMessageNotReadableException이 발생하는 이유는 유효성 검증이 수행되기 전에 요청 메시지를 읽을 때 발생하는 예외로, 요청 바디의 형식이나 필드 값이 잘못된 경우 발생할 수 있습니다.
		//유효성 검증과 요청 메시지 읽기는 스프링에서 다른 과정으로 처리되므로, 발생하는 예외도 서로 다를 수 있습니다. 따라서 HttpMessageNotReadableException이 발생하는 경우, 요청 바디의 형식이나 필드 값이 잘못되었는지 확인해야 합니다.
		COMMONCodeVO vo = new COMMONCodeVO();
		ResponseDTO res = new ResponseDTO();
		res.setCode(200);
		//res.setMessage("Sucess");
		//res.setMessage(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(cmon.selectList(vo)));
		vo.setGroupCode("10000");
		List<COMMONCodeVO> list = cmon.selectList(vo);
		res.setMessage(list.toString());
		return res;
	}
	
    @GetMapping("/LoggingTest")
    public String Logging(){
        return "Logging Test Success";
    }
}
