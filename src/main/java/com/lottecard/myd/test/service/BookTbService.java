package com.lottecard.myd.test.service;

import java.io.IOException;

import com.lottecard.myd.test.model.vo.BookTbEntity;


public interface BookTbService {

	public void insertOne(String query) throws Exception;

	public BookTbEntity SelectOne(String query) throws IOException;
 }
