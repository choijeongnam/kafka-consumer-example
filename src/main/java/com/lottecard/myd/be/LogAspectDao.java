package com.lottecard.myd.be;

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

@Aspect
@Component
@Order(2)
public class LogAspectDao {
    private static final Logger logger = LoggerFactory.getLogger(LogAspectDao.class);

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
