package com.lottecard.myd.test.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lottecard.myd.test.model.vo.COMMONCodeVO;


public interface COMMONCodeService {

	 List<COMMONCodeVO> selectList(COMMONCodeVO vo) throws Exception;
//		int mergeSfCmpnMstList(List<TMcSfCmpnMstVO> TMcSfCmpnMstVOList) throws Exception;

	List<COMMONCodeVO> selectBatchList(COMMONCodeVO vo) throws Exception;
 }
