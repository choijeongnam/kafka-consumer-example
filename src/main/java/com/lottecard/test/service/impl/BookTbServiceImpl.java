package com.lottecard.test.service.impl;

import java.io.IOException;

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
	public void insertOne(String query) throws IOException {
		BookTbEntity bookTbEntity = new BookTbEntity();

		Call<BookTbInDto> call = retrofit.create(BookApi.class).SelectOne(query, 1, 1);
		Response<BookTbInDto> response = call.execute();
		if(response.isSuccessful()) {

				BookTbInDto inDto = response.body();
				bookTbEntity = inDto.getDocuments().get(0);
				bookTbEntity.setTitle(bookTbEntity.getTitle());
				bookTbEntity.setContents(bookTbEntity.getContents());
				bookTbEntity.setIsbn(bookTbEntity.getIsbn());
		        bookTbDao.insertOne(bookTbEntity);

		        System.out.println("insert 성공");

		} else {
			System.out.println("insert 실패");
		}
	}

	@Override
	public BookTbEntity SelectOne(String query) throws IOException {
		BookTbEntity bookTbEntity = null;
		Call<BookTbInDto> call = retrofit.create(BookApi.class).SelectOne(query, 1, 1);
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
