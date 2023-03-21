package com.lottecard.test.service.impl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lottecard.test.dao.BookTbDao;
import com.lottecard.test.model.dto.BookTbInDto;
import com.lottecard.test.model.vo.BookTbEntity;
import com.lottecard.test.service.BookApi;
import com.lottecard.test.service.BookTbService;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;


@Service
public class BookTbServiceImpl implements BookTbService {

	@Autowired
	private BookTbDao bookTbDao;
	
	@Autowired
	private Retrofit retrofit;

	@Override
	public void insertOne(BookTbEntity bookTbEntity) {
		// TODO Auto-generated method stub
		
		bookTbDao.insertOne(bookTbEntity);
	}

	@Override
	public BookTbEntity SelectOne(String query) throws IOException {
		BookTbEntity bookTbEntity = null;
		Call<BookTbInDto> call = retrofit.create(BookApi.class).SelectOne("KakaoAK ab230ed4b4b50baa90581a2b0070290c" ,query, 1, 1);
		Response<BookTbInDto> res = call.execute();
		if(res.isSuccessful()) {
			BookTbInDto inDto = res.body();
			bookTbEntity = inDto.getDocuments().get(0);
			System.out.println("result: "+ bookTbEntity.toString());
		}else {
			System.out.println("fail");
		}
		return null;
	}
 }
