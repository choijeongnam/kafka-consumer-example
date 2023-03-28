package com.lottecard.myd.be;

import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.google.common.base.Joiner;

@Aspect
@Component
@Order(2)
public class LogAspectDao {
    private static final Logger logger = LoggerFactory.getLogger(LogAspectDao.class);
    	
    @Around("execution(* com.lottecard.myd..dao.*.*(..))")
    public Object logging(ProceedingJoinPoint pjp) throws Throwable {

        String params = getRequestParams();

        long startAt = System.currentTimeMillis();

        logger.info("----------> [REQUEST] : {}({}) = {}", pjp.getSignature().getDeclaringTypeName(),
                pjp.getSignature().getName(), params);

        Object result = pjp.proceed();

        long endAt = System.currentTimeMillis();

        logger.info("----------> [RESPONSE] : {}({}) = {} ({}ms)", pjp.getSignature().getDeclaringTypeName(),
                pjp.getSignature().getName(), result, endAt-startAt);

        return result;
    }

    private String getRequestParams() {

        String params = "";

        RequestAttributes requestAttribute = RequestContextHolder.getRequestAttributes();

        if(requestAttribute != null){
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                    .getRequestAttributes()).getRequest();

            Map<String, String[]> paramMap = request.getParameterMap();

            if(!paramMap.isEmpty()) {
                params = " [" + paramMapToString(paramMap) + "]";
            }
        }
        return params;
    }

    private String paramMapToString(Map<String, String[]> paramMap) {
        return paramMap.entrySet().stream()
                .map(entry -> String.format("%s -> (%s)",
                        entry.getKey(), Joiner.on(",").join(entry.getValue())))
                .collect(Collectors.joining(", "));
    }
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
