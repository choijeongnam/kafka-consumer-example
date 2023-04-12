package com.lottecard.myd.cmn;

import org.beanio.annotation.Field;
import org.beanio.builder.Align;

import lombok.Getter;
import lombok.Setter;

public class RcvDenyChnlRgIz {
	@Field(name="rcvDenyYn", length=2, align=Align.LEFT, type=String.class, padding=' ')
    private String rcvDenyYn;
	@Field(name="rgDt", length=16, align=Align.LEFT, type=String.class, padding=' ')
    private String rgDt;
	@Field(name="rgrEno", length=14, align=Align.LEFT, type=String.class, padding=' ')
    private String rgrEno;
	@Field(name="rgrNm", length=40, align=Align.LEFT, type=String.class, padding=' ')
    private String rgrNm;
	@Field(name="chnlKndc", length=2, align=Align.LEFT, type=String.class, padding=' ')
    private String chnlKndc;
	@Field(name="rcvDenyCnC", length=4, align=Align.LEFT, type=String.class, padding=' ')
    private String rcvDenyCnC;

	public String getRcvDenyYn() {
		return rcvDenyYn;
	}
	public void setRcvDenyYn(String rcvDenyYn) {
		this.rcvDenyYn = rcvDenyYn;
	}
	public String getRgDt() {
		return rgDt;
	}
	public void setRgDt(String rgDt) {
		this.rgDt = rgDt;
	}
	public String getRgrEno() {
		return rgrEno;
	}
	public void setRgrEno(String rgrEno) {
		this.rgrEno = rgrEno;
	}
	public String getRgrNm() {
		return rgrNm;
	}
	public void setRgrNm(String rgrNm) {
		this.rgrNm = rgrNm;
	}
	public String getChnlKndc() {
		return chnlKndc;
	}
	public void setChnlKndc(String chnlKndc) {
		this.chnlKndc = chnlKndc;
	}
	public String getRcvDenyCnC() {
		return rcvDenyCnC;
	}
	public void setRcvDenyCnC(String rcvDenyCnC) {
		this.rcvDenyCnC = rcvDenyCnC;
	}


}
