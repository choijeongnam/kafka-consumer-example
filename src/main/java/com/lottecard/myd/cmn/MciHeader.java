package com.lottecard.myd.cmn;

//@org.beanio.annotation.Record(maxOccurs = 1)
public class MciHeader {
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
    private String chnlDc;
    private String ogc;
    private String eno;
    private String usid;
    private String pagId;
    private String urSecrGdc;
    private String pagSecrGdc;
    private String mciPrbYn;
    private String exrFld1;
    private String dePcRc;
    private int dtaMaxCt;
    private int inqPcCt;
    private String psNtKey;
    private String msgDspDc;
    private String msgCn;
    private String arbitMsgDc;
    private String pgmErrInfCn;
    private String exrFld2;
    private String cdDc;
    private String choDc;
    private String incpDc;
    private String pdDc;
    private String cdno;
    private String rrno;
    private String acno;
    private String pcDc;
    private String urDfCn;
    private String exrFld3;
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
	public String getChnlDc() {
		return chnlDc;
	}
	public void setChnlDc(String chnlDc) {
		this.chnlDc = chnlDc;
	}
	public String getOgc() {
		return ogc;
	}
	public void setOgc(String ogc) {
		this.ogc = ogc;
	}
	public String getEno() {
		return eno;
	}
	public void setEno(String eno) {
		this.eno = eno;
	}
	public String getUsid() {
		return usid;
	}
	public void setUsid(String usid) {
		this.usid = usid;
	}
	public String getPagId() {
		return pagId;
	}
	public void setPagId(String pagId) {
		this.pagId = pagId;
	}
	public String getUrSecrGdc() {
		return urSecrGdc;
	}
	public void setUrSecrGdc(String urSecrGdc) {
		this.urSecrGdc = urSecrGdc;
	}
	public String getPagSecrGdc() {
		return pagSecrGdc;
	}
	public void setPagSecrGdc(String pagSecrGdc) {
		this.pagSecrGdc = pagSecrGdc;
	}
	public String getMciPrbYn() {
		return mciPrbYn;
	}
	public void setMciPrbYn(String mciPrbYn) {
		this.mciPrbYn = mciPrbYn;
	}
	public String getExrFld1() {
		return exrFld1;
	}
	public void setExrFld1(String exrFld1) {
		this.exrFld1 = exrFld1;
	}
	public String getDePcRc() {
		return dePcRc;
	}
	public void setDePcRc(String dePcRc) {
		this.dePcRc = dePcRc;
	}
	public int getDtaMaxCt() {
		return dtaMaxCt;
	}
	public void setDtaMaxCt(int dtaMaxCt) {
		this.dtaMaxCt = dtaMaxCt;
	}
	public int getInqPcCt() {
		return inqPcCt;
	}
	public void setInqPcCt(int inqPcCt) {
		this.inqPcCt = inqPcCt;
	}
	public String getPsNtKey() {
		return psNtKey;
	}
	public void setPsNtKey(String psNtKey) {
		this.psNtKey = psNtKey;
	}
	public String getMsgDspDc() {
		return msgDspDc;
	}
	public void setMsgDspDc(String msgDspDc) {
		this.msgDspDc = msgDspDc;
	}
	public String getMsgCn() {
		return msgCn;
	}
	public void setMsgCn(String msgCn) {
		this.msgCn = msgCn;
	}
	public String getArbitMsgDc() {
		return arbitMsgDc;
	}
	public void setArbitMsgDc(String arbitMsgDc) {
		this.arbitMsgDc = arbitMsgDc;
	}
	public String getPgmErrInfCn() {
		return pgmErrInfCn;
	}
	public void setPgmErrInfCn(String pgmErrInfCn) {
		this.pgmErrInfCn = pgmErrInfCn;
	}
	public String getExrFld2() {
		return exrFld2;
	}
	public void setExrFld2(String exrFld2) {
		this.exrFld2 = exrFld2;
	}
	public String getCdDc() {
		return cdDc;
	}
	public void setCdDc(String cdDc) {
		this.cdDc = cdDc;
	}
	public String getChoDc() {
		return choDc;
	}
	public void setChoDc(String choDc) {
		this.choDc = choDc;
	}
	public String getIncpDc() {
		return incpDc;
	}
	public void setIncpDc(String incpDc) {
		this.incpDc = incpDc;
	}
	public String getPdDc() {
		return pdDc;
	}
	public void setPdDc(String pdDc) {
		this.pdDc = pdDc;
	}
	public String getCdno() {
		return cdno;
	}
	public void setCdno(String cdno) {
		this.cdno = cdno;
	}
	public String getRrno() {
		return rrno;
	}
	public void setRrno(String rrno) {
		this.rrno = rrno;
	}
	public String getAcno() {
		return acno;
	}
	public void setAcno(String acno) {
		this.acno = acno;
	}
	public String getPcDc() {
		return pcDc;
	}
	public void setPcDc(String pcDc) {
		this.pcDc = pcDc;
	}
	public String getUrDfCn() {
		return urDfCn;
	}
	public void setUrDfCn(String urDfCn) {
		this.urDfCn = urDfCn;
	}
	public String getExrFld3() {
		return exrFld3;
	}
	public void setExrFld3(String exrFld3) {
		this.exrFld3 = exrFld3;
	}

	@Override
	public String toString() {
		return "MciHeader [gramLnth=" + gramLnth + ", guid=" + guid + ", gramPrgNo=" + gramPrgNo + ", gramNo=" + gramNo
				+ ", akRspDc=" + akRspDc + ", rspBizDc=" + rspBizDc + ", gramAkDtti=" + gramAkDtti + ", ipAdd=" + ipAdd
				+ ", tgtSvId=" + tgtSvId + ", deNatvNo1=" + deNatvNo1 + ", deNatvNo2=" + deNatvNo2 + ", oriGrnCn="
				+ oriGrnCn + ", smlDeYn=" + smlDeYn + ", gramRspDtti=" + gramRspDtti + ", pcRc=" + pcRc
				+ ", fstErrSysDc=" + fstErrSysDc + ", chnlHdExsYn=" + chnlHdExsYn + ", exrFld=" + exrFld + ", chnlDc="
				+ chnlDc + ", ogc=" + ogc + ", eno=" + eno + ", usid=" + usid + ", pagId=" + pagId + ", urSecrGdc="
				+ urSecrGdc + ", pagSecrGdc=" + pagSecrGdc + ", mciPrbYn=" + mciPrbYn + ", exrFld1=" + exrFld1
				+ ", dePcRc=" + dePcRc + ", dtaMaxCt=" + dtaMaxCt + ", inqPcCt=" + inqPcCt + ", psNtKey=" + psNtKey
				+ ", msgDspDc=" + msgDspDc + ", msgCn=" + msgCn + ", arbitMsgDc=" + arbitMsgDc + ", pgmErrInfCn="
				+ pgmErrInfCn + ", exrFld2=" + exrFld2 + ", cdDc=" + cdDc + ", choDc=" + choDc + ", incpDc=" + incpDc
				+ ", pdDc=" + pdDc + ", cdno=" + cdno + ", rrno=" + rrno + ", acno=" + acno + ", pcDc=" + pcDc
				+ ", urDfCn=" + urDfCn + ", exrFld3=" + exrFld3 + "]";
	}
}
