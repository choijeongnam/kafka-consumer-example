package com.lottecard.myd.cmn.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpUtils {
	   @SuppressWarnings("unused")
		private static final Logger logger  = LoggerFactory.getLogger(HttpUtils.class);
	    private static InetAddress inet = null;

	    public static String getServerIp() {
	        try {
	            if (inet == null) {
	                inet = InetAddress.getLocalHost();
	            }
	            return inet.getHostAddress();
	        } catch (UnknownHostException e) {
	            e.printStackTrace();
	            return "999.999.999.999";
	        }
	    }
	    public static String getClientIp() {
	        return getClientIp(SessionUtil.getRequest());
	    }
	    public static String getClientIp(HttpServletRequest request) {
	        if (request == null) {
	            request = SessionUtil.getRequest();
	            if (request == null) {
	                return "Unknown IP(Request 객체가 없음)";
	            }
	        }
	        String clientIp = request.getHeader("X-Forwarded-For");
	        if (isEmptyClientIp(clientIp)) {
	            clientIp = request.getHeader("Proxy-Client-IP");
	        }
	        if (isEmptyClientIp(clientIp)) {
	            clientIp = request.getHeader("WL-Proxy-Client-IP");
	        }
	        if (isEmptyClientIp(clientIp)) {
	            clientIp = request.getHeader("HTTP_CLIENT_IP");
	        }
	        if (isEmptyClientIp(clientIp)) {
	            clientIp = request.getHeader("HTTP_X_FORWARDED_FOR");
	        }
	        if (isEmptyClientIp(clientIp)) {
	            clientIp = request.getRemoteAddr();
	        }
	        return clientIp;
	    }
	    public static String getRemoteAddr(HttpServletRequest request) {
	        if (request == null) {
	            request = SessionUtil.getRequest();
	            if (request == null) {
	                return "Unknown IP(Request 객체가 없음)";
	            }
	        }
	        String clientIp = request.getRemoteAddr();
	        if (isEmptyClientIp(clientIp)) {
	            clientIp = "999.999.999.999";
	        }
	        return clientIp;
	    }
	    public static boolean isEmptyClientIp(String clientIp) {
	        return StringUtil.isEmpty(clientIp) || "unknown".equalsIgnoreCase(clientIp);
	    }
}
