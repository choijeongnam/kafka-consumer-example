package com.lottecard.myd.cmn;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EaiIfSpec {
	YLS00006("", "S", "YLS00006", 170, "S", "LP", "", "", CommonData.class, null);
	
	private String replyGramNo;
	private String bizTc;
	private String serviceId;
	private int gramLnth;
	private String akRspDc;
	private String rspBizDc;
	private String tgtSvId;
	private String exrFld;
	private Class<?> requestData;
	private Class<?> responseData;
}
