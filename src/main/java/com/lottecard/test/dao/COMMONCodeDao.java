package com.lottecard.test.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lottecard.cmn.dao.OracleAbstractMapper;
import com.lottecard.test.dao.mapper.COMMONCodeMapper;
import com.lottecard.test.model.vo.COMMONCodeVO;


@Repository
public class COMMONCodeDao extends OracleAbstractMapper  {

	public int insertOne(COMMONCodeVO vo) {
		return getSqlSession().getMapper(COMMONCodeMapper.class).insertOne(vo);
	}

	public int updateOne(COMMONCodeVO vo) {
		return getSqlSession().getMapper(COMMONCodeMapper.class).updateOne(vo);
	}

	public int updateMany(COMMONCodeVO vo) {
		return getSqlSession().getMapper(COMMONCodeMapper.class).updateMany(vo);
	}

	public int deleteOne(COMMONCodeVO vo) {
		return getSqlSession().getMapper(COMMONCodeMapper.class).deleteOne(vo);
	}

	public int deleteMany(COMMONCodeVO vo) {
		return getSqlSession().getMapper(COMMONCodeMapper.class).deleteMany(vo);
	}

	public int mergeUpdateOne(COMMONCodeVO vo) {
		return getSqlSession().getMapper(COMMONCodeMapper.class).mergeUpdateOne(vo);
	}

	public int selectCount(COMMONCodeVO vo) {
		return getSqlSession().getMapper(COMMONCodeMapper.class).selectCount(vo);
	}

	public COMMONCodeVO selectOne(COMMONCodeVO vo) {
		return getSqlSession().getMapper(COMMONCodeMapper.class).selectOne(vo);
	}

	public List<COMMONCodeVO> selectList(COMMONCodeVO vo) {
		return getSqlSession().getMapper(COMMONCodeMapper.class).selectList(vo);
	}

 }
