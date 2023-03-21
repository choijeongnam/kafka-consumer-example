package com.lottecard.test.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lottecard.test.dao.BookTbDao;
import com.lottecard.test.model.vo.BookTbEntity;
import com.lottecard.test.service.BookTbService;


@Service
public class BookTbServiceImpl implements BookTbService {

	@Autowired
	private BookTbDao bookTbDao;

	@Override
	public void insertOne(BookTbEntity bookTbEntity) {
		// TODO Auto-generated method stub
		bookTbDao.insertOne(bookTbEntity);
	}
 }
