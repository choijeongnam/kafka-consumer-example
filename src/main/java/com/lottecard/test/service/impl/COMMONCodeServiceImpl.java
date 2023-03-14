package com.lottecard.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lottecard.test.dao.COMMONCodeDao;
import com.lottecard.test.model.vo.COMMONCodeVO;
import com.lottecard.test.service.COMMONCodeService;


@Service
public class COMMONCodeServiceImpl implements COMMONCodeService {

//	@Resource(name = "COMMONCodeDao")
	@Autowired
	private COMMONCodeDao cOMMONCodeDao;

	@Override
//	@Transactional(value="txManagerOra", rollbackFor={Exception.class})
	@Transactional(rollbackFor={Exception.class})
    public List<COMMONCodeVO> selectList(COMMONCodeVO vo) throws Exception{
		return cOMMONCodeDao.selectList(vo);
    }
	
//	@Override
////	@Transactional(value="txManagerOra", rollbackFor={Exception.class})
//	@Transactional(rollbackFor={Exception.class})
//    public int mergeSfCmpnMstList(List<TMcSfCmpnMstVO> TMcSfCmpnMstVOList) throws Exception {
//		
//		int cnt = 0;
//		try {
//			System.out.println("요청 개수 : " + TMcSfCmpnMstVOList.size());
//			for(TMcSfCmpnMstVO vo: TMcSfCmpnMstVOList){
//				
//				int result = tMcSfCmpnMstDao.mergeSfCmpnMstOne(vo);
//				System.out.println(result);
//				cnt++;
//				
//			}
//			
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//			
//		}
////		logger.debug("SFMCBatchUpdateServiceImpl - getGaHistByVisitnumber");
//		
//		System.out.println("완료 개수 : " + cnt);
//        return cnt;
//    }

 }
