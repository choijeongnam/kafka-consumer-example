package com.lottecard.myd.test.service;


import com.lottecard.myd.test.model.dto.ExampleInDto;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ExampleApi {
	@GET("/B490007/qfcRateInfo/getRateList")
	public Call<ExampleInDto> SelectOne(@Query("serviceKey") String serviceKey, @Query("pageNo") int pageNo, @Query("numOfRows") int numOfRows);
}
