package com.lottecard.myd.cmn.config;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.jaxb.JaxbConverterFactory;

public class TypeConverterFactory extends Converter.Factory {
	@Override
	public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
		if (type instanceof Class && ((Class<?>) type).isAnnotationPresent(XmlRootElement.class)) {
			return JaxbConverterFactory.create().responseBodyConverter(type, annotations, retrofit);
		}
		return GsonConverterFactory.create().responseBodyConverter(type, annotations, retrofit);
	}
}
