package com.lottecard.myd.be;

import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

@Aspect
@Component
@Order(2)
public class LogAspectService {
    private static final Logger logger = LoggerFactory.getLogger(LogAspectService.class);
    
    @Autowired
    private HttpServletRequest request;
    
//    @Around("@annotation(org.springframework.web.bind.annotation.PostMapping)")
//    public Object logging(ProceedingJoinPoint pjp) throws Throwable {
//        
//        String requestMethod = request.getMethod();
//        String requestURI = request.getRequestURI();
//        logger.info("[HTTP Request] Method: {} URI: {}", requestMethod, requestURI);
//
//        BindingResult bindingResult = null;
//        for (Object arg : pjp.getArgs()) {
//            if (arg instanceof BindingResult) {
//                bindingResult = (BindingResult) arg;
//                break;
//            }
//        }
//
//        Object result = pjp.proceed();
////
////        if (bindingResult != null && bindingResult.hasErrors()) {
////            String errors = bindingResult.getAllErrors().stream()
////                    .map(ObjectError::toString)
////                    .collect(Collectors.joining(", "));
////            logger.error("[Validation Error] Method: {} URI: {} Errors: {}", requestMethod, requestURI, errors);
////        }
//
//        return result;
//
//    }
}
