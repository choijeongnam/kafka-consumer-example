package com.lottecard.myd.cmn;

import java.util.List;

//@org.beanio.annotation.Record(maxOccurs = 1)
public class CommonData {
	//@org.beanio.annotation.Field(align = Align.RIGHT, type = Integer.class, length = 5, padding = 0)
    private String cno;
    private int rcvDenyChnlRgIzCnt;
    private List<RcvDenyChnlRgIz> rcvDenyChnlRgIz;
	public String getCno() {
		return cno;
	}
	public void setCno(String cno) {
		this.cno = cno;
	}
	public int getRcvDenyChnlRgIzCnt() {
		return rcvDenyChnlRgIzCnt;
	}
	public void setRcvDenyChnlRgIzCnt(int rcvDenyChnlRgIzCnt) {
		this.rcvDenyChnlRgIzCnt = rcvDenyChnlRgIzCnt;
	}
	public List<RcvDenyChnlRgIz> getRcvDenyChnlRgIz() {
		return rcvDenyChnlRgIz;
	}
	public void setRcvDenyChnlRgIz(List<RcvDenyChnlRgIz> rcvDenyChnlRgIz) {
		this.rcvDenyChnlRgIz = rcvDenyChnlRgIz;
	}
	@Override
	public String toString() {
		return "CommonData [cno=" + cno + ", rcvDenyChnlRgIzCnt=" + rcvDenyChnlRgIzCnt + ", rcvDenyChnlRgIz="
				+ rcvDenyChnlRgIz + "]";
	}
}
