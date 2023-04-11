package com.lottecard.myd.cmn;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
//@org.beanio.annotation.Record(maxOccurs = 1)
public class CommonHeader {
	//@org.beanio.annotation.Field(align = Align.RIGHT, type = Integer.class, length = 5, padding = 0)
	private int gramLnth;
    private String guid;
    private int gramPrgNo;
    private String gramNo;
    private String akRspDc;
    private String rspBizDc;
}
