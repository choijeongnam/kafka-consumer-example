package com.lottecard;


import static springfox.bean.validators.plugins.Validators.annotationFromBean;
import static springfox.bean.validators.plugins.Validators.annotationFromField;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Optional;

import springfox.bean.validators.plugins.Validators;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.schema.ModelPropertyBuilderPlugin;
import springfox.documentation.spi.schema.contexts.ModelPropertyContext;


@Component
@Order(Validators.BEAN_VALIDATOR_PLUGIN_ORDER)
public class CodeValidator implements ModelPropertyBuilderPlugin{
	
	@Override
	public boolean supports(DocumentationType delimiter) {
		// TODO Auto-generated method stub
		return true;
	}
	
	@Override
	public void apply(ModelPropertyContext context) {
		// TODO Auto-generated method stub
		
		Optional<CheckValidator> checkValidator = extractAnnotation(context);
		
		context.getBuilder().required(checkValidator.get().required()).example(checkValidator.get().example()).build();
		
//		Optional<CheckValidator> c = extractAnnotation(context);
//		if(c.isPresent()) {
//			System.err.println(c.get().name());
//			context.getBuilder().required(c.isPresent()).build();
//		}
		//.example(c.get().example())
		
	}

	@VisibleForTesting
	private Optional<CheckValidator> extractAnnotation(ModelPropertyContext context) {
		// TODO Auto-generated method stub
		return annotationFromBean(context, CheckValidator.class).or(annotationFromField(context, CheckValidator.class));
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
