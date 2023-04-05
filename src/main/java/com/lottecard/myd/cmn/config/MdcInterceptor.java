package com.lottecard.myd.cmn.config;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.web.servlet.AsyncHandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MdcInterceptor implements AsyncHandlerInterceptor {
	
    private static final Logger logger = LoggerFactory.getLogger(MdcInterceptor.class);
//    private static final String TRACE_ID = "traceId";
	
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//JWT 토큰 검증 예정
		return true;
	}
	
}
