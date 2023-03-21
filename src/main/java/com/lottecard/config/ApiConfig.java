package com.lottecard.config;

import java.util.concurrent.TimeUnit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;

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

}
