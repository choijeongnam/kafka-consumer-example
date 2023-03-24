package com.lottecard;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;

import com.lottecard.myd.test.model.dto.BookTbInDto;
import com.lottecard.myd.test.model.dto.ExampleInDto;
import com.lottecard.myd.test.service.ExampleApi;

import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;
import retrofit2.converter.jaxb.JaxbConverterFactory;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class ApiTest {
	@Test
	void test() throws IOException {

		//http://apis.data.go.kr/B490007/qfcRateInfo/getRateList?serviceKey=X9F7%2Bo0WyblCTdZFHalJFOeC6et6ebT9W%2F5OSka2CJG5lELVpBoL%2BBzI6B35T0szlU%2BXTtFaEGcq5HuVXq8pfA%3D%3D&pageNo=1&numOfRows=1
		OkHttpClient client = new OkHttpClient()
				.newBuilder()
				.callTimeout(60, TimeUnit.SECONDS)
				.connectionPool(new ConnectionPool())
			.build();

		Retrofit retrofit = new Retrofit
				.Builder()
				.baseUrl("http://apis.data.go.kr")
				.client(client)
				.addConverterFactory(JaxbConverterFactory.create())
				//.addConverterFactory(GsonConverterFactory.create())
			.build();

		Call<ExampleInDto> call = retrofit.create(ExampleApi.class).SelectOne("X9F7+o0WyblCTdZFHalJFOeC6et6ebT9W/5OSka2CJG5lELVpBoL+BzI6B35T0szlU+XTtFaEGcq5HuVXq8pfA==", 1, 1);
		Response<ExampleInDto> response = call.execute();
		if(response.isSuccessful()) {
	        ExampleInDto dto = response.body();
	        System.out.println(dto.toString());
		} else {
			System.out.println("Failure");
		}
	}
}
