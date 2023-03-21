package com.lottecard.test.service;

import com.lottecard.test.model.dto.BookTbInDto;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface BookApi {
	@GET("/v3/search/book")
	public Call<BookTbInDto> SelectOne(@Header("Authorization") String authorization, @Query("query") String query, @Query("page") int page, @Query("size") int size);
}
