package com.lottecard.myd.test.service.impl;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lottecard.myd.test.dao.BookTbDao;
import com.lottecard.myd.test.model.dto.BookTbInDto;
import com.lottecard.myd.test.model.vo.BookTbEntity;
import com.lottecard.myd.test.service.BookApi;
import com.lottecard.myd.test.service.BookTbService;

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
	public void insertOne(String query) throws IOException {
		BookTbEntity bookTbEntity = new BookTbEntity();

		Call<BookTbInDto> call = retrofit.create(BookApi.class).SelectOne(query, 1, 1);
		Response<BookTbInDto> response = call.execute();

		if(response.isSuccessful()) {
			BookTbInDto inDto = response.body();
			bookTbEntity.setTitle(inDto.getDocuments().get(0).getTitle());
			bookTbEntity.setContents(inDto.getDocuments().get(0).getContents());
			bookTbEntity.setIsbn(inDto.getDocuments().get(0).getIsbn());
	        int count = bookTbDao.insertOne(bookTbEntity);
	        System.out.println("insert count: " + count);
		} else {
			System.out.println("Failure");
		}
	}

	@Override
	public BookTbEntity SelectOne(String query) throws IOException {
		BookTbEntity bookTbEntity = new BookTbEntity();

		Call<BookTbInDto> call = retrofit.create(BookApi.class).SelectOne(query, 1, 1);
		Response<BookTbInDto> res = call.execute();

		if(res.isSuccessful()) {
			BookTbInDto inDto = res.body();
			bookTbEntity.setTitle(inDto.getDocuments().get(0).getTitle());
			bookTbEntity.setContents(inDto.getDocuments().get(0).getContents());
			bookTbEntity.setIsbn(inDto.getDocuments().get(0).getIsbn());
			System.out.println("result: "+ inDto.toString());
		} else {
			System.out.println("fail");
		}

		return bookTbEntity;
	}
 }
