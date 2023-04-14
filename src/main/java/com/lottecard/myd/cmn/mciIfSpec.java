package com.lottecard.myd.cmn;

import lombok.AllArgsConstructor;
import lombok.Getter;
@Getter
@AllArgsConstructor
public enum mciIfSpec{

	CMS00630("CMS00630", "", "", 0, "", "", "", "", null),
	CommonData("CommonData", "", "", 0, "", "", "", "", CommonData.class);

	private String replyGramNo;
	private String bizTc;
	private String serviceId;
	private int gramLnth;
	private String akRspDc;
	private String rspBizDc;
	private String tgtSvId;
	private String exrFld;
	private Class<?> cls ;

}
