package com.lottecard.myd.test.controller;

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
import org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver;

import com.lottecard.myd.cmn.model.dto.ResponseDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class ExceptionController extends DefaultHandlerExceptionResolver {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionController.class);

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseDTO> methodValidException(MethodArgumentNotValidException e, HttpServletRequest request){
    	logger.error("MethodArgumentNotValidException 발생!!! url:{}, trace:{}",request.getRequestURI(), e.getStackTrace());

        return new ResponseEntity<ResponseDTO>(new ResponseDTO(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BindException.class)
    public ResponseEntity<ResponseDTO> errorValid(BindException e, HttpServletRequest request) {
    	logger.error("BindException 발생!!! url:{}, trace:{}",request.getRequestURI(), e.getStackTrace());

         return new ResponseEntity<ResponseDTO>(new ResponseDTO(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(SQLException.class)
    public ResponseEntity<ResponseDTO> errorSQL(SQLException e, HttpServletRequest request) {
    	logger.error("SQLException 발생!!! url:{}, trace:{}",request.getRequestURI(), e.getStackTrace());

         return new ResponseEntity<ResponseDTO>(new ResponseDTO(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<ResponseDTO> errorSQL(SQLIntegrityConstraintViolationException e, HttpServletRequest request) {
    	logger.error("SQLIntegrityConstraintViolationException 발생!!! url:{}, trace:{}",request.getRequestURI(), e.getStackTrace());

         return new ResponseEntity<ResponseDTO>(new ResponseDTO(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ResponseDTO> errorSQL(NullPointerException e, HttpServletRequest request) {
    	logger.error("NullPointerException 발생!!! url:{}, trace:{}",request.getRequestURI(), e.getStackTrace());

         return new ResponseEntity<ResponseDTO>(new ResponseDTO(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<ResponseDTO> errorSQL(HttpRequestMethodNotSupportedException e, HttpServletRequest request) {
    	logger.error("HttpRequestMethodNotSupportedException 발생!!! url:{}, trace:{}",request.getRequestURI(), e.getStackTrace());

         return new ResponseEntity<ResponseDTO>(new ResponseDTO(), HttpStatus.BAD_REQUEST);
    }
}
