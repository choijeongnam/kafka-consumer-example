package com.lottecard.myd.test.dao.mapper;

import java.util.List;

import com.lottecard.myd.test.model.vo.COMMONCodeEntity;

public interface COMMONCodeMapper {

	public int insertOne(COMMONCodeEntity vo);

	public int updateOne(COMMONCodeEntity vo);

	public int updateMany(COMMONCodeEntity vo);

	public int deleteOne(COMMONCodeEntity vo);

	public int deleteMany(COMMONCodeEntity vo);

	public int selectCount(COMMONCodeEntity vo);

	public COMMONCodeEntity selectOne(COMMONCodeEntity vo);

	public List<COMMONCodeEntity> selectList(COMMONCodeEntity vo);

	public int mergeUpdateOne(COMMONCodeEntity vo);

}