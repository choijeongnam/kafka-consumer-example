package com.lottecard.myd.config;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MdcFilter implements Filter{
	
    private static final Logger logger = LoggerFactory.getLogger(MdcFilter.class);
    private static final String TRACE_ID = "traceId";
	
    @Override
    public void doFilter(final ServletRequest servletRequest, final ServletResponse servletResponse, final FilterChain filterChain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		String traceId = UUID.randomUUID().toString();
		MDC.put(TRACE_ID,traceId);
		logger.info("----------> [Filter MDC Start] ");

	    filterChain.doFilter(servletRequest, servletResponse);
		logger.info("----------> [Filter MDC End] ");
	    MDC.clear();
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		Filter.super.destroy();
	}
	

}
