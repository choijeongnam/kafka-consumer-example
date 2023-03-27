package com.lottecard.myd.be;

import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.google.common.base.Joiner;

@Aspect
@Component
@Order(1)
public class LogAspect {
    private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);

    @Around("execution(* com.lottecard.myd..*.*(..))")
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

//    @Pointcut("execution(* com.lottecard.controller.*.*(..))")
//    public void cut() {
//
//    }
//
//    @Around("cut()")
//    public Object validationHandler(ProceedingJoinPoint joinPoint) throws Throwable {
//    	String type = joinPoint.getSignature().getDeclaringTypeName();
//    	String method = joinPoint.getSignature().getName();
//
//    	logger.info("validation handler type = {}", type);
//    	logger.info("validation handler method = {}", method);
//
//        String requestMethod = request.getMethod();
//        String requestURI = request.getRequestURI();
//        logger.info("[HTTP Request] Method: {} URI: {}", requestMethod, requestURI);
//
//        BindingResult bindingResult = null;
//        for (Object arg : joinPoint.getArgs()) {
//            if (arg instanceof BindingResult) {
//                bindingResult = (BindingResult) arg;
//                break;
//            }
//        }
//
//        Object result = joinPoint.proceed();
//
//        if (bindingResult != null && bindingResult.hasErrors()) {
//            String errors = bindingResult.getAllErrors().stream()
//                    .map(ObjectError::toString)
//                    .collect(Collectors.joining(", "));
//            logger.error("[Validation Error] Method: {} URI: {} Errors: {}", requestMethod, requestURI, errors);
//        }
//
//        return result;
//    }

//
//    @Around("@annotation(javax.validation.Valid)")
//    public Object logValidatedMethods(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
//        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
//        Method method = methodSignature.getMethod();
//
//        logger.debug("Validating method: {}", method.getName());
//
//        // do something before
//
//        Object result = proceedingJoinPoint.proceed();
//
//        // do something after
//
//        return result;
//    }
//
//    @Before("execution(* com.lottecard.controller.*.*(..))")
//    public void logBefore(ProceedingJoinPoint joinPoint) {
//    	logger.info("----------> Controller Start Log :");
//
//    	String params = getRequestParams();
//
//    	logger.info("----------> REQUEST : {}({}) = {}", joinPoint.getSignature().getDeclaringTypeName(),
//              joinPoint.getSignature().getName(), params);
//        System.out.println("Before executing method: " + joinPoint.getSignature().getName());
//    }
//
//    @After("execution(* com.lottecard.controller.*.*(..))")
//    public void logAfter(ProceedingJoinPoint joinPoint) throws Throwable {
//      Object result = joinPoint.proceed();
//
//      long endAt = System.currentTimeMillis();
//
//      logger.info("----------> RESPONSE : {}({}) = {} ({}ms)", joinPoint.getSignature().getDeclaringTypeName(),
//    		  joinPoint.getSignature().getName(), result);
//    }

//    @Around("execution(* org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handle(..)) && args(request, ..)")
//    public Object validateMethodArguments(ProceedingJoinPoint joinPoint, HttpServletRequest request) throws Throwable {
//        MethodParameter[] methodParameters = ((HandlerMethod) request.getAttribute("org.springframework.web.servlet.HandlerMapping.bestMatchingHandler")).getMethodParameters();
//        for (MethodParameter methodParameter : methodParameters) {
//            if (methodParameter.getParameterAnnotation(Valid.class) != null) {
//                Object[] args = joinPoint.getArgs();
//                for (Object arg : args) {
//                    if (arg instanceof BindingResult) {
//                        BindingResult bindingResult = (BindingResult) arg;
//                        for (FieldError fieldError : bindingResult.getFieldErrors()) {
//                            // 로그 출력
//                            LoggerFactory.getLogger("//제발 로그좀.." + joinPoint.getTarget().getClass()).warn(fieldError.getDefaultMessage());
//                        }
//                    }
//                }
//            }
//        }
//        return joinPoint.proceed();
//    }

}
