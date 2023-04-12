package com.lottecard.myd.cmn;

import java.util.List;

import org.beanio.annotation.Field;
import org.beanio.annotation.Record;
import org.beanio.annotation.Segment;
import org.beanio.builder.Align;

@Record(name = "CommonData", maxOccurs = 1)
public class CommonData {
	@Field(name="cno", length=22, align=Align.LEFT, type=String.class)
    private String cno;
	@Field(name="rcvDenyChnlRgIzCnt", length=3, align=Align.RIGHT, padding = '0', type=Integer.class)
    private int rcvDenyChnlRgIzCnt;
	@Segment(minOccurs=0, collection=List.class)
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



//	public String getCno() {
//		return cno;
//	}
//	public void setCno(String cno) {
//		this.cno = cno;
//	}
//	public int getRcvDenyChnlRgIzCnt() {
//		return rcvDenyChnlRgIzCnt;
//	}
//	public void setRcvDenyChnlRgIzCnt(int rcvDenyChnlRgIzCnt) {
//		this.rcvDenyChnlRgIzCnt = rcvDenyChnlRgIzCnt;
//	}
//	public List<RcvDenyChnlRgIz> getRcvDenyChnlRgIz() {
//		return rcvDenyChnlRgIz;
//	}
//	public void setRcvDenyChnlRgIz(List<RcvDenyChnlRgIz> rcvDenyChnlRgIz) {
//		this.rcvDenyChnlRgIz = rcvDenyChnlRgIz;
//	}
//	@Override
//	public String toString() {
//		return "CommonData [cno=" + cno + ", rcvDenyChnlRgIzCnt=" + rcvDenyChnlRgIzCnt + ", rcvDenyChnlRgIz="
//				+ rcvDenyChnlRgIz + "]";
//	}
}
