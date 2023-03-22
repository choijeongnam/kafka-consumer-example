package com.lottecard.test.service;

import java.io.IOException;

import com.lottecard.test.model.vo.BookTbEntity;


public interface BookTbService {

	public void insertOne(String query) throws IOException;

	public BookTbEntity SelectOne(String query) throws IOException;
 }
