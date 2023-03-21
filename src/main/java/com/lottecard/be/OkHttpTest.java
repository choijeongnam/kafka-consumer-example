package com.lottecard.be;

import java.io.IOException;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OkHttpTest {

	static String reqUrl = "http://localhost:8000/home1";

	@Autowired
	private OkHttpClient client;

	@Test
	public void main() throws IOException {

		try {
	        MediaType mediaType = MediaType.parse("application/json");
	        RequestBody body = RequestBody.create(mediaType, "{\"name\":\"John\"}");
	        Request request = new Request.Builder()
	                .url(reqUrl)
	                .method("POST", body)
	                .addHeader("Content-Type", "application/json")
	                .build();
	        Response response = client.newCall(request).execute();

	        System.err.println("응답 코드 찍어보자?" + response.body().string());

		} catch (Exception e){
			System.err.println(e.toString());
		}


		//reqPostSample();
	}

//	public static void reqPostSample() {
//
//		System.err.println("호출되는 시점?");
//		try {
//			RequestBody formBody = new FormBody.Builder().add("user", "tester").build(); //FormBody사용시 content-type는 application/x-www-form-urlencoded
//			Request request = new Request.Builder().addHeader("X-ReqSvcCd", "TESTER").url(reqUrl).post(formBody).build();
//
//			Response response = client.newCall(request).execute();
//			responseProcess(response);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	public static void responseProcess(Response response) throws IOException {
//
//		if (response.isSuccessful()) {
//			String rtnMsg = response.body().string();
//			System.out.println(String.format("성공 => '%s", rtnMsg));
//		} else {
//			System.out.println(String.format("실패 =>:'%s'\n errMsg:'%s'", response.code(), response.body().string()));
//		}
//
//		System.out.println("\n");
//	}
}
