package com.lottecard.myd.cmn;

import org.beanio.annotation.Field;
import org.beanio.builder.Align;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
}
