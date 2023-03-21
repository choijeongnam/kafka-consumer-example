package com.lottecard.test.controller;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import okhttp3.HttpUrl;
import okhttp3.Interceptor.Chain;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

@Controller
public class HomeController {

	@Autowired
	private OkHttpClient okHttpClient;

	@RequestMapping(value="/", method=RequestMethod.GET)
    public String index(){

        return "index";
    }

	@RequestMapping(value="/home", method=RequestMethod.GET)
    public String home(){

        return "home";
    }

	@RequestMapping(value="/home1", method=RequestMethod.POST)
    public void home1(@RequestParam Map<String, Object> map){

		String name = map.get("name").toString();
		//headers: {Authorization : "KakaoAK ab230ed4b4b50baa90581a2b0070290c"}

//        MediaType mediaType = MediaType.parse("application/json");
//        RequestBody body = RequestBody.create(mediaType, "{\"name\":\"John\"}");

        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme("https")
                .host("dapi.kakao.com")
                .addPathSegment("v3")
                .addPathSegment("search")
                .addPathSegment("book")
                .addQueryParameter("query", name)
                // Each addPathSegment separated add a / symbol to the final url
                // finally my Full URL is:
                // https://subdomain.apiweb.com/api/v1/students/8873?auth_token=71x23768234hgjwqguygqew
                .build();

		System.out.println("url 찍기~" + httpUrl.toString());

        Request request = new Request.Builder()
                .addHeader("Authorization", "KakaoAK ab230ed4b4b50baa90581a2b0070290c")
                .url(httpUrl)
                .build();

		try {
			Response response = okHttpClient.newCall(request).execute();
	        //System.err.println("응답 코드 찍어보자?" + response.body().string());

	        JSONObject o = new JSONObject(response.body().string());

	        System.err.println("documents값은 ? ====> " + o.get("documents").toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {

		}
    }

}
