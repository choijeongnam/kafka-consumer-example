package com.lottecard.myd.test.service;

import com.lottecard.myd.test.model.dto.BookTbInDto;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface BookApi {
	@GET("/v3/search/book")
	@Headers({"Authorization: KakaoAK ab230ed4b4b50baa90581a2b0070290c"})
	public Call<BookTbInDto> SelectOne(@Query("query") String query, @Query("page") int page, @Query("size") int size);
}
