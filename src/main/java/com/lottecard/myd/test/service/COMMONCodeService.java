package com.lottecard.myd.test.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lottecard.myd.test.model.vo.COMMONCodeEntity;


public interface COMMONCodeService {

	 List<COMMONCodeEntity> selectList(COMMONCodeEntity vo) throws Exception;
//		int mergeSfCmpnMstList(List<TMcSfCmpnMstVO> TMcSfCmpnMstVOList) throws Exception;

	List<COMMONCodeEntity> selectBatchList(COMMONCodeEntity vo) throws Exception;
 }
