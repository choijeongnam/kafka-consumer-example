package com.lottecard.test.dao;

import org.springframework.stereotype.Repository;

import com.lottecard.cmn.dao.OracleAbstractMapper;
import com.lottecard.test.dao.mapper.BookTbMapper;
import com.lottecard.test.model.vo.BookTbEntity;

@Repository
public class BookTbDao extends OracleAbstractMapper {

	public int insertOne(BookTbEntity entity) {
		return getSqlSession().getMapper(BookTbMapper.class).insertOne(entity);
	}

	public int updateOne(BookTbEntity entity) {
		return getSqlSession().getMapper(BookTbMapper.class).updateOne(entity);
	}

	public int deleteOne(BookTbEntity entity) {
		return getSqlSession().getMapper(BookTbMapper.class).deleteOne(entity);
	}

	public int deleteMulti(BookTbEntity entity) {
		return getSqlSession().getMapper(BookTbMapper.class).deleteMulti(entity);
	}

	public int mergeUpdateOne(BookTbEntity entity) {
		return getSqlSession().getMapper(BookTbMapper.class).mergeUpdateOne(entity);
	}

	public int selectCount(BookTbEntity entity) {
		return getSqlSession().getMapper(BookTbMapper.class).selectCount(entity);
	}

	public BookTbEntity selectOne(BookTbEntity entity) {
		return getSqlSession().getMapper(BookTbMapper.class).selectOne(entity);
	}

 }
