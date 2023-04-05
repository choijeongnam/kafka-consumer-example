package com.lottecard.myd.test.service.impl;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	@Transactional
	public void insertOne(String query) throws Exception {
		BookTbEntity bookTbEntity = new BookTbEntity();

			bookTbEntity.setTitle("한수경88");
			bookTbEntity.setContents("한수경88");
			bookTbEntity.setIsbn("ㅇㅇ88");
			bookTbDao.insertOne(bookTbEntity);
		    throw new IOException();

//		Call<BookTbInDto> call = retrofit.create(BookApi.class).SelectOne(query, 1, 1);
//		Response<BookTbInDto> response = call.execute();
//
//		if(response.isSuccessful()) {
//			BookTbInDto inDto = response.body();
//			bookTbEntity.setTitle(inDto.getDocuments().get(0).getTitle());
//			bookTbEntity.setContents(inDto.getDocuments().get(0).getContents());
//			bookTbEntity.setIsbn(inDto.getDocuments().get(0).getIsbn());
//	        int count = bookTbDao.insertOne(bookTbEntity);
//	        System.out.println("insert count: " + count);
//		} else {
//			System.out.println("Failure");
//		}
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
			System.err.println("headers" + call.request().headers());
			System.out.println("result: "+ bookTbEntity.toString());
		} else {
			System.out.println("fail");
		}

		return bookTbEntity;
	}
 }
