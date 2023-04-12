package com.lottecard.myd.cmn.model;

public enum ifSpec{

	CMS00630 ("CMS00630", "", "", 0, "", "", "", "", "beanIO/mci/mciHeader.xml", "beanIO/mci/CMS00630.xml");

	private String replyGramNo;
	private String bizTc;
	private String serviceId;
	private int gramLnth;
	private String akRspDc;
	private String rspBizDc;
	private String tgtSvId;
	private String exrFld;
	private String headerPath;
	private String dataPath;

	private ifSpec(String replyGramNo, String bizTc, String serviceId, int gramLnth, String akRspDc, String rspBizDc,
			String tgtSvId, String exrFld, String headerPath, String dataPath) {
		this.replyGramNo = replyGramNo;
		this.bizTc = bizTc;
		this.serviceId = serviceId;
		this.gramLnth = gramLnth;
		this.akRspDc = akRspDc;
		this.rspBizDc = rspBizDc;
		this.tgtSvId = tgtSvId;
		this.exrFld = exrFld;
		this.headerPath = headerPath;
		this.dataPath = dataPath;
	}

	public String getReplyGramNo() {
		return replyGramNo;
	}

	public String getBizTc() {
		return bizTc;
	}

	public String getServiceId() {
		return serviceId;
	}

	public int getGramLnth() {
		return gramLnth;
	}

	public String getAkRspDc() {
		return akRspDc;
	}

	public String getRspBizDc() {
		return rspBizDc;
	}

	public String getTgtSvId() {
		return tgtSvId;
	}

	public String getExrFld() {
		return exrFld;
	}

	public String getHeaderPath() {
		return headerPath;
	}

	public String getDataPath() {
		return dataPath;
	}
}
