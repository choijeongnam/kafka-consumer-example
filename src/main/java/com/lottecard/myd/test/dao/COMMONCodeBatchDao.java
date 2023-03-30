package com.lottecard.myd.test.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lottecard.myd.cmn.dao.OracleBatchAbstractMapper;
import com.lottecard.myd.test.dao.mapper.COMMONCodeMapper;
import com.lottecard.myd.test.model.vo.COMMONCodeEntity;


@Repository
public class COMMONCodeBatchDao extends OracleBatchAbstractMapper  {

	public int insertOne(COMMONCodeEntity vo) {
		return getSqlSession().getMapper(COMMONCodeMapper.class).insertOne(vo);
	}

	public int updateOne(COMMONCodeEntity vo) {
		return getSqlSession().getMapper(COMMONCodeMapper.class).updateOne(vo);
	}

	public int updateMany(COMMONCodeEntity vo) {
		return getSqlSession().getMapper(COMMONCodeMapper.class).updateMany(vo);
	}

	public int deleteOne(COMMONCodeEntity vo) {
		return getSqlSession().getMapper(COMMONCodeMapper.class).deleteOne(vo);
	}

	public int deleteMany(COMMONCodeEntity vo) {
		return getSqlSession().getMapper(COMMONCodeMapper.class).deleteMany(vo);
	}

	public int mergeUpdateOne(COMMONCodeEntity vo) {
		return getSqlSession().getMapper(COMMONCodeMapper.class).mergeUpdateOne(vo);
	}

	public int selectCount(COMMONCodeEntity vo) {
		return getSqlSession().getMapper(COMMONCodeMapper.class).selectCount(vo);
	}

	public COMMONCodeEntity selectOne(COMMONCodeEntity vo) {
		return getSqlSession().getMapper(COMMONCodeMapper.class).selectOne(vo);
	}

	public List<COMMONCodeEntity> selectList(COMMONCodeEntity vo) {
		return getSqlSession().getMapper(COMMONCodeMapper.class).selectList(vo);
	}

 }
