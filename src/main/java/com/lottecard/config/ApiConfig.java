package com.lottecard.config;

import java.util.concurrent.TimeUnit;

import org.mapstruct.BeanMapping;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Configuration
public class ApiConfig {

	@Bean
	OkHttpClient okHttpClient() {
		return new OkHttpClient()
				.newBuilder()
					.callTimeout(60, TimeUnit.SECONDS)
					.connectionPool(new ConnectionPool())
				.build();
	}
	
	@Bean
	public Retrofit retrofit() {
		return new Retrofit
				.Builder()
					.baseUrl("https://dapi.kakao.com")
					.client(okHttpClient())
					.addConverterFactory(GsonConverterFactory.create())
				.build();
	}

}
