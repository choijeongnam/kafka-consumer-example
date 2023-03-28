package com.lottecard.myd.test.dao.mapper;

import com.lottecard.myd.test.model.vo.BookTbEntity;

public interface BookTbMapper {

	public int insertOne(BookTbEntity entity) throws Throwable;

	public int updateOne(BookTbEntity entity);

	public int deleteOne(BookTbEntity entity);

	public int deleteMulti(BookTbEntity entity);

	public int selectCount(BookTbEntity entity);

	public BookTbEntity selectOne(BookTbEntity entity);

	public int mergeUpdateOne(BookTbEntity entity);

}