package com.lottecard.cmn.dao;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OracleBatchAbstractMapper extends SqlSessionDaoSupport  {
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
//public class EdwAbstractMapper extends CommonAbstractMapper {
	@Override
	@Resource(name = "sqlSessionOracleBatch")
	public void setSqlSessionFactory(SqlSessionFactory sqlSession) {
		super.setSqlSessionFactory(sqlSession);
	}
}

