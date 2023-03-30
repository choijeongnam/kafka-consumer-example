package com.lottecard.myd.config;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.jboss.logging.MDC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import okhttp3.ConnectionPool;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;

@Configuration
public class ApiConfig {
    private static final Logger logger = LoggerFactory.getLogger(ApiConfig.class);

    private ConnectionPool okhttpConnPool = new ConnectionPool(5, 20L, TimeUnit.SECONDS);
	private static final String TRACE_ID = "traceId";

	Interceptor requestInterceptor = new Interceptor() {
		@Override
		public Response intercept(Chain chain) throws IOException {
			Request request = chain.request().newBuilder()
					.addHeader("Loca-Guid", (String) MDC.get(TRACE_ID)).build();
			return chain.proceed(request);
		}
	};

	@Bean
	OkHttpClient okHttpClient() {
		logger.debug("ConnectionPool count: {}", okhttpConnPool.connectionCount());
		return new OkHttpClient()
					.newBuilder()
					.callTimeout(60, TimeUnit.SECONDS)
					.connectionPool(okhttpConnPool)
		            .addInterceptor(requestInterceptor)
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
