package com.lottecard;


import static springfox.bean.validators.plugins.Validators.annotationFromBean;
import static springfox.bean.validators.plugins.Validators.annotationFromField;

import java.net.BindException;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Optional;

import springfox.bean.validators.plugins.Validators;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.schema.ModelPropertyBuilderPlugin;
import springfox.documentation.spi.schema.contexts.ModelPropertyContext;


@Component
@Order(Validators.BEAN_VALIDATOR_PLUGIN_ORDER)
public class LocaValidator implements ModelPropertyBuilderPlugin, ConstraintValidator<LocaValidation, Object>{
	
	private boolean required;
	
	@Override
	public boolean supports(DocumentationType delimiter) {
		// TODO Auto-generated method stub
		return true;
	}
	
	@Override
	public void apply(ModelPropertyContext context) {
		// TODO Auto-generated method stub
		
		Optional<LocaValidation> locaValidation = extractAnnotation(context);
		
		if(locaValidation.isPresent()) {
			context.getBuilder().required(locaValidation.get().required()).example(locaValidation.get().example()).build();
		}

		
		
//		Optional<CheckValidator> c = extractAnnotation(context);
//		if(c.isPresent()) {
//			System.err.println(c.get().name());
//			context.getBuilder().required(c.isPresent()).build();
//		}
		//.example(c.get().example())
		
	}

	@VisibleForTesting
	private Optional<LocaValidation> extractAnnotation(ModelPropertyContext context) {
		// TODO Auto-generated method stub
		return annotationFromBean(context, LocaValidation.class).or(annotationFromField(context, LocaValidation.class));
	}
	
	public void initialize(LocaValidation constraintAnnotation) {
		//this.ALLOW_ARRAY = constraintAnnotation.codes(); // 허용할 코드 설정
		this.required = constraintAnnotation.required();
	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		
		//Class<?> valueType = value.getClass();
		System.err.println(value);
		
		if(required) {
			if(value == null) {
				//throw new MethodArgumentNotValidException(value, bindingResult)
//				try {
//					throw new BindException();
//				} catch(Exception e) {
//					return false;
//				}
				return false;
			}
		}
		
//	    if (required) {
//	        if (value == null) {
//	        	return false;
//	        }
//	    }
	    
//        if (value instanceof String) {
//            // validate string value
//        } else if (value instanceof Long) {
//            // validate integer value
//        } else {
//            // invalid data type
//            context.buildConstraintViolationWithTemplate("Invalid data type")
//                    .addConstraintViolation();
//            return false;
//        }
		return true;
	}
	
	
	
	
//    @Override
//    public void initialize(CheckValidator constraintAnnotation) {
//    	//this.ALLOW_ARRAY = constraintAnnotation.codes(); // 허용할 코드 설정
//    	this.name = constraintAnnotation.name();
//    	this.example = constraintAnnotation.example();
//    }
//
//	@Override
//	public boolean isValid(Object arg0, ConstraintValidatorContext arg1) {
//		// TODO Auto-generated method stub
//		String value = arg0.toString();
//		
//		System.err.println("찍어보자? 되긴하나");
//		System.err.println("찍어보자? isValid" + name);
//		if(value == null) {
//			return false;
//		} 
//		
//		return true;
//	}
}
