package com.lottecard.myd.cmn;

import java.util.List;

import org.beanio.builder.Align;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@org.beanio.annotation.Record(name = "CommonData", maxOccurs = 1)
public class CommonData {
	@org.beanio.annotation.Field(name="cno", length=22, align=Align.LEFT, type=String.class)
    private String cno;
	@org.beanio.annotation.Field(name="rcvDenyChnlRgIzCnt", length=3, align=Align.RIGHT, padding = '0', type=Integer.class)
    private int rcvDenyChnlRgIzCnt;
//    private List<RcvDenyChnlRgIz> rcvDenyChnlRgIz;
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
