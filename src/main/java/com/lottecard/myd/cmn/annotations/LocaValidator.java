package com.lottecard.myd.cmn.annotations;


import static springfox.bean.validators.plugins.Validators.annotationFromBean;
import static springfox.bean.validators.plugins.Validators.annotationFromField;

import java.text.ParseException;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.time.DateUtils;
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
public class LocaValidator implements ModelPropertyBuilderPlugin, ConstraintValidator<LocaValidation, Object>{
	
	private boolean required;
	private String pattern;
	String[] parsePatterns = {"yyyyMMdd", "yyyy.MM.dd", "yyyy-MM-dd"};
	
	@Override
	public boolean supports(DocumentationType delimiter) {
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
	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		if(required) {
			if(ObjectUtils.isEmpty(value)) return false;
		}
		
		if(pattern == "yyyyMMdd" || pattern == "yyyy.MM.dd" || pattern == "yyyy-MM-dd") {
			try {
				DateUtils.parseDate((String) value, parsePatterns);
			} catch (ParseException e) {
				return false;
			}
		}
		
		return true;
	}
	
}
