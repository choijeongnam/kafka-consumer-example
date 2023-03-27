package com.lottecard.myd.config;

import java.util.concurrent.TimeUnit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.jaxb.JaxbConverterFactory;

@Configuration
public class ApiConfig {

	@Bean
	OkHttpClient okHttpClient() {
		return new OkHttpClient()
				.newBuilder()
					.callTimeout(60, TimeUnit.SECONDS)
					.connectionPool(new ConnectionPool())
					// 인터셉터 추가
		            .addInterceptor(chain -> {
		                Request request = chain.request().newBuilder().addHeader("Authorization", "KakaoAK ab230ed4b4b50baa90581a2b0070290c").build();
		                return chain.proceed(request);
		            })
				.build();
	}

	@Bean
	public Retrofit retrofit() {
		return new Retrofit
				.Builder()
					.baseUrl("https://dapi.kakao.com")
					.client(okHttpClient())
					.addConverterFactory(new TestConverterFactory())
				.build();
	}

}
