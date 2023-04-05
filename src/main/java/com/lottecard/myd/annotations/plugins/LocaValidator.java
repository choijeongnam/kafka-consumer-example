package com.lottecard.myd.annotations.plugins;


import static springfox.bean.validators.plugins.Validators.annotationFromBean;
import static springfox.bean.validators.plugins.Validators.annotationFromField;

import java.net.BindException;
import java.text.ParseException;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Optional;
import com.lottecard.myd.annotations.LocaValidation;

import springfox.bean.validators.plugins.Validators;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.schema.ModelPropertyBuilderPlugin;
import springfox.documentation.spi.schema.contexts.ModelPropertyContext;


@Component
@Order(Validators.BEAN_VALIDATOR_PLUGIN_ORDER)
public class LocaValidator implements ModelPropertyBuilderPlugin, ConstraintValidator<LocaValidation, Object>{
	
	private boolean required;
	private String pattern;
	String[] parsePatterns = {"yyyyMMdd", "yyyy.MM.dd", "yyyy-MM-dd"};
	
	@Override
	public boolean supports(DocumentationType delimiter) {
		// TODO Auto-generated method stub
		return true;
	}
	
	@Override
	public void apply(ModelPropertyContext context) {
		Optional<LocaValidation> locaValidation = extractAnnotation(context);

		if(locaValidation.isPresent()) {
			context.getBuilder()
				.pattern(locaValidation.get().pattern())
				.required(locaValidation.get().required())
				.example((Object)locaValidation.get().example())
				.description(locaValidation.get().description())
			.build();
		}
	}

	@VisibleForTesting
	private Optional<LocaValidation> extractAnnotation(ModelPropertyContext context) {
		return annotationFromBean(context, LocaValidation.class).or(annotationFromField(context, LocaValidation.class));
	}
	
	public void initialize(LocaValidation constraintAnnotation) {
		this.required = constraintAnnotation.required();
		this.pattern = constraintAnnotation.pattern();
		System.out.println(this.pattern);
	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		if(required) {
			if(value == null) return false;
		}
		
		if(pattern == "yyyyMMdd") {
			try {
				DateUtils.parseDate((String) value, parsePatterns);
			} catch (ParseException e) {
				return false;
			}
		}
		
		return true;
	}
	
}
