package com.lottecard.myd.cmn.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


public class SessionUtil {
    /**
     * attribute 값을 가져 오기 위한 method
     *
     * @param String
     *            attribute key name
     * @return Object attribute obj
     */
    public static Object getAttribute(String name) throws Exception {
        return RequestContextHolder.getRequestAttributes() == null ? null : (Object) RequestContextHolder.getRequestAttributes().getAttribute(name, RequestAttributes.SCOPE_SESSION);
    }
    /**
     * attribute 설정 method
     *
     * @param String
     *            attribute key name
     * @param Object
     *            attribute obj
     * @return void
     */
    public static void setAttribute(String name, Object object) throws Exception {
        if(RequestContextHolder.getRequestAttributes() != null)
            RequestContextHolder.getRequestAttributes().setAttribute(name, object, RequestAttributes.SCOPE_SESSION);
    }
    /**
     * 설정한 attribute 삭제
     *
     * @param String
     *            attribute key name
     * @return void
     */
    public static void removeAttribute(String name) throws Exception {
        if(RequestContextHolder.getRequestAttributes() != null)
            RequestContextHolder.getRequestAttributes().removeAttribute(name, RequestAttributes.SCOPE_SESSION);
    }
    /**
     * session id
     *
     * @param void
     * @return String SessionId 값
     */
    public static String getSessionId() throws Exception {
        return RequestContextHolder.getRequestAttributes() == null ? null : RequestContextHolder.getRequestAttributes().getSessionId();
    }
    /**
     * 현재 접속중인 request의 session 객체 return
     *
     * @return
     */
    public static HttpSession getSession() {
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        if(attr!=null && attr.getRequest()!=null){
            return attr.getRequest().getSession(true);
        }else{
            return null;
        }
    }
    /**
     * 현재 접속중인 request 객체 return
     *
     * @return
     */
    public static HttpServletRequest getRequest() {
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        return attr == null ? null : attr.getRequest();
    }
}