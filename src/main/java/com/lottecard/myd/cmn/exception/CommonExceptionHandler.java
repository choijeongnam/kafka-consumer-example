package com.lottecard.myd.cmn.exception;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.lottecard.myd.cmn.model.dto.ResponseDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class CommonExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(CommonExceptionHandler.class);

    @ExceptionHandler(LocaException.class)
    public ResponseEntity<ResponseDTO> LocaException(LocaException e, HttpServletRequest request){
    	logger.error("LocaException 발생!!! url:{}, trace:{}",request.getRequestURI(), e.getStackTrace());

        return new ResponseEntity<ResponseDTO>(new ResponseDTO(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseDTO> Exception(Exception e, HttpServletRequest request){
    	logger.error("Exception 발생!!! url:{}, trace:{}",request.getRequestURI(), e.getStackTrace());

        return new ResponseEntity<ResponseDTO>(new ResponseDTO(), HttpStatus.BAD_REQUEST);
    }
}
