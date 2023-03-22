package com.lottecard.myd.test.dao.mapper;

import java.util.List;

import com.lottecard.myd.test.model.vo.COMMONCodeVO;

public interface COMMONCodeMapper {

	public int insertOne(COMMONCodeVO vo);

	public int updateOne(COMMONCodeVO vo);

	public int updateMany(COMMONCodeVO vo);

	public int deleteOne(COMMONCodeVO vo);

	public int deleteMany(COMMONCodeVO vo);

	public int selectCount(COMMONCodeVO vo);

	public COMMONCodeVO selectOne(COMMONCodeVO vo);

	public List<COMMONCodeVO> selectList(COMMONCodeVO vo);

	public int mergeUpdateOne(COMMONCodeVO vo);

}