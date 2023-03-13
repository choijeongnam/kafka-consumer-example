package com.lottecard.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.lottecard.dto.ResponseDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class ExceptionController {

    /**
     * @valid  유효성체크에 통과하지 못하면  MethodArgumentNotValidException 이 발생한다.
     */
	
    private static final Logger logger = LoggerFactory.getLogger(ExceptionController.class);
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseDTO> methodValidException(MethodArgumentNotValidException e, HttpServletRequest request){
    	logger.error("MethodArgumentNotValidException 발생!!! url:{}, trace:{}",request.getRequestURI(), e.getStackTrace());
    	
       // ResponseDTO errorResponse = makeErrorResponse(e.getBindingResult());
        return new ResponseEntity<ResponseDTO>(new ResponseDTO(), HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler({BindException.class})
    public ResponseEntity<ResponseDTO> errorValid(BindException e, HttpServletRequest request) {
    	logger.error("BindException 발생!!! url:{}, trace:{}",request.getRequestURI(), e.getStackTrace());
    	
        // ResponseDTO errorResponse = makeErrorResponse(e.getBindingResult());
         return new ResponseEntity<ResponseDTO>(new ResponseDTO(), HttpStatus.BAD_REQUEST);
    }
}
