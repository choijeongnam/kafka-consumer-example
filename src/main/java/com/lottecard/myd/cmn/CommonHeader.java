package com.lottecard.myd.cmn;

//@org.beanio.annotation.Record(maxOccurs = 1)
public class CommonHeader {
	//@org.beanio.annotation.Field(align = Align.RIGHT, type = Integer.class, length = 5, padding = 0)
	private int gramLnth;
    private String guid;
    private int gramPrgNo;
    private String gramNo;
    private String akRspDc;
    private String rspBizDc;
	public int getGramLnth() {
		return gramLnth;
	}
	public void setGramLnth(int gramLnth) {
		this.gramLnth = gramLnth;
	}
	public String getGuid() {
		return guid;
	}
	public void setGuid(String guid) {
		this.guid = guid;
	}
	public int getGramPrgNo() {
		return gramPrgNo;
	}
	public void setGramPrgNo(int gramPrgNo) {
		this.gramPrgNo = gramPrgNo;
	}
	public String getGramNo() {
		return gramNo;
	}
	public void setGramNo(String gramNo) {
		this.gramNo = gramNo;
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
	@Override
	public String toString() {
		return "CommonHeader [gramLnth=" + gramLnth + ", guid=" + guid + ", gramPrgNo=" + gramPrgNo + ", gramNo="
				+ gramNo + ", akRspDc=" + akRspDc + ", rspBizDc=" + rspBizDc + "]";
	}
}
