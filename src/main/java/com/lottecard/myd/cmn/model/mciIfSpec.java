package com.lottecard.myd.cmn.model;

public enum mciIfSpec{

	CMS00630("CMS00630", "", "", 0, "", "", "", ""),
	CommonData("CommonData", "", "", 0, "", "", "", "");

	private String replyGramNo;
	private String bizTc;
	private String serviceId;
	private int gramLnth;
	private String akRspDc;
	private String rspBizDc;
	private String tgtSvId;
	private String exrFld;

	public String getReplyGramNo() {
		return replyGramNo;
	}
	public void setReplyGramNo(String replyGramNo) {
		this.replyGramNo = replyGramNo;
	}
	public String getBizTc() {
		return bizTc;
	}
	public void setBizTc(String bizTc) {
		this.bizTc = bizTc;
	}
	public String getServiceId() {
		return serviceId;
	}
	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}
	public int getGramLnth() {
		return gramLnth;
	}
	public void setGramLnth(int gramLnth) {
		this.gramLnth = gramLnth;
	}
	public String getAkRspDc() {
		return akRspDc;
	}
	public void setAkRspDc(String akRspDc) {
		this.akRspDc = akRspDc;
	}
	public String getRspBizDc() {
		return rspBizDc;
	}
	public void setRspBizDc(String rspBizDc) {
		this.rspBizDc = rspBizDc;
	}
	public String getTgtSvId() {
		return tgtSvId;
	}
	public void setTgtSvId(String tgtSvId) {
		this.tgtSvId = tgtSvId;
	}
	public String getExrFld() {
		return exrFld;
	}
	public void setExrFld(String exrFld) {
		this.exrFld = exrFld;
	}

	private mciIfSpec(String replyGramNo, String bizTc, String serviceId, int gramLnth, String akRspDc, String rspBizDc,
			String tgtSvId, String exrFld) {
		this.replyGramNo = replyGramNo;
		this.bizTc = bizTc;
		this.serviceId = serviceId;
		this.gramLnth = gramLnth;
		this.akRspDc = akRspDc;
		this.rspBizDc = rspBizDc;
		this.tgtSvId = tgtSvId;
		this.exrFld = exrFld;
	}
}
