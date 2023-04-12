package com.lottecard.myd.cmn;

//@org.beanio.annotation.Record(maxOccurs = 1)
public class EaiHeader {
	//@org.beanio.annotation.Field(align = Align.RIGHT, type = Integer.class, length = 5, padding = 0)
	private int gramLnth;
    private String guid;
    private int gramPrgNo;
    private String gramNo;
    private String akRspDc;
    private String rspBizDc;
    private String gramAkDtti;
    private String ipAdd;
    private String tgtSvId;
    private int deNatvNo1;
    private int deNatvNo2;
    private String oriGrnCn;
    private String smlDeYn;
    private String gramRspDtti;
    private int pcRc;
    private String fstErrSysDc;
    private String chnlHdExsYn;
    private String exrFld;

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
	public String getGramAkDtti() {
		return gramAkDtti;
	}
	public void setGramAkDtti(String gramAkDtti) {
		this.gramAkDtti = gramAkDtti;
	}
	public String getIpAdd() {
		return ipAdd;
	}
	public void setIpAdd(String ipAdd) {
		this.ipAdd = ipAdd;
	}
	public String getTgtSvId() {
		return tgtSvId;
	}
	public void setTgtSvId(String tgtSvId) {
		this.tgtSvId = tgtSvId;
	}
	public int getDeNatvNo1() {
		return deNatvNo1;
	}
	public void setDeNatvNo1(int deNatvNo1) {
		this.deNatvNo1 = deNatvNo1;
	}
	public int getDeNatvNo2() {
		return deNatvNo2;
	}
	public void setDeNatvNo2(int deNatvNo2) {
		this.deNatvNo2 = deNatvNo2;
	}
	public String getOriGrnCn() {
		return oriGrnCn;
	}
	public void setOriGrnCn(String oriGrnCn) {
		this.oriGrnCn = oriGrnCn;
	}
	public String getSmlDeYn() {
		return smlDeYn;
	}
	public void setSmlDeYn(String smlDeYn) {
		this.smlDeYn = smlDeYn;
	}
	public String getGramRspDtti() {
		return gramRspDtti;
	}
	public void setGramRspDtti(String gramRspDtti) {
		this.gramRspDtti = gramRspDtti;
	}
	public int getPcRc() {
		return pcRc;
	}
	public void setPcRc(int pcRc) {
		this.pcRc = pcRc;
	}
	public String getFstErrSysDc() {
		return fstErrSysDc;
	}
	public void setFstErrSysDc(String fstErrSysDc) {
		this.fstErrSysDc = fstErrSysDc;
	}
	public String getChnlHdExsYn() {
		return chnlHdExsYn;
	}
	public void setChnlHdExsYn(String chnlHdExsYn) {
		this.chnlHdExsYn = chnlHdExsYn;
	}
	public String getExrFld() {
		return exrFld;
	}
	public void setExrFld(String exrFld) {
		this.exrFld = exrFld;
	}

	@Override
	public String toString() {
		return "EaiHeader [gramLnth=" + gramLnth + ", guid=" + guid + ", gramPrgNo=" + gramPrgNo + ", gramNo=" + gramNo
				+ ", akRspDc=" + akRspDc + ", rspBizDc=" + rspBizDc + ", gramAkDtti=" + gramAkDtti + ", ipAdd=" + ipAdd
				+ ", tgtSvId=" + tgtSvId + ", deNatvNo1=" + deNatvNo1 + ", deNatvNo2=" + deNatvNo2 + ", oriGrnCn="
				+ oriGrnCn + ", smlDeYn=" + smlDeYn + ", gramRspDtti=" + gramRspDtti + ", pcRc=" + pcRc
				+ ", fstErrSysDc=" + fstErrSysDc + ", chnlHdExsYn=" + chnlHdExsYn + ", exrFld=" + exrFld + "]";
	}
}
