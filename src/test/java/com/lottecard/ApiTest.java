package com.lottecard;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;

import com.lottecard.myd.test.model.dto.BookTbInDto;
import com.lottecard.myd.test.service.BookApi;
import com.lottecard.myd.test.service.BookTbService;

import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiTest {

    private static final Logger logger = LoggerFactory.getLogger(ApiTest.class);

	@Autowired
	private BookTbService bookTbService;

	@Async
	public void getTestAsync() throws IOException, InterruptedException {
		bookTbService.SelectOne("별이빛나는밤에");
		logger.debug("async로 돌리나? 다다다ㅏㄷㄱ?");
	}

	@Test
	public void testConnectionPool() throws Exception {
		ConnectionPool connectionPool = new ConnectionPool(5, 1, TimeUnit.SECONDS);
		OkHttpClient client = new OkHttpClient.Builder().connectionPool(connectionPool).build();

		Retrofit retrofit = new Retrofit.Builder().baseUrl("https://dapi.kakao.com/").client(client)
				.addConverterFactory(GsonConverterFactory.create()).build();

		for (int i = 0; i < 10; i++) {
			Call<BookTbInDto> call = retrofit.create(BookApi.class).SelectOne("가", 1, 1);
			Response<BookTbInDto> response = call.execute();
			System.err.println("2초전 total connection 개 수 : " + connectionPool.connectionCount());
			System.err.println("2초전 total idleConnectionCount 개 수 : " + connectionPool.idleConnectionCount());
			Thread.sleep(2000);
			System.err.println("2초후 total connection 개 수 : " + connectionPool.connectionCount());
			System.err.println("2초후 total idleConnectionCount 개 수 : " + connectionPool.idleConnectionCount());
		}
	}
}

//		//http://apis.data.go.kr/B490007/qfcRateInfo/getRateList?serviceKey=X9F7%2Bo0WyblCTdZFHalJFOeC6et6ebT9W%2F5OSka2CJG5lELVpBoL%2BBzI6B35T0szlU%2BXTtFaEGcq5HuVXq8pfA%3D%3D&pageNo=1&numOfRows=1
//		OkHttpClient client = new OkHttpClient()
//				.newBuilder()
//				.callTimeout(60, TimeUnit.SECONDS)
//				.connectionPool(new ConnectionPool())
//			.build();
//
//		Retrofit retrofit = new Retrofit
//				.Builder()
//				.baseUrl("http://apis.data.go.kr")
//				.client(client)
//				.addConverterFactory(JaxbConverterFactory.create())
//				//.addConverterFactory(GsonConverterFactory.create())
//			.build();
//
//		Call<ExampleInDto> call = retrofit.create(ExampleApi.class).SelectOne("X9F7+o0WyblCTdZFHalJFOeC6et6ebT9W/5OSka2CJG5lELVpBoL+BzI6B35T0szlU+XTtFaEGcq5HuVXq8pfA==", 1, 1);
//		Response<ExampleInDto> response = call.execute();
//		if(response.isSuccessful()) {
//	        ExampleInDto dto = response.body();
//	        System.out.println(dto.toString());
//		} else {
//			System.out.println("Failure");
//		}
//	}
