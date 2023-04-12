package com.lottecard.myd.cmn;

import org.beanio.annotation.Field;
import org.beanio.annotation.Record;
import org.beanio.builder.Align;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public abstract class CommonHeader {
	@Field(align = Align.RIGHT, type = Integer.class, length = 5, padding = '0')
	private int gramLnth;
	
	@Field(align = Align.LEFT, type = String.class, length = 31, padding = ' ')
	private String guid;
	
	@Field(align = Align.RIGHT, type = Integer.class, length = 2, padding = '0')
	private int gramPrgNo;
	
	@Field(align = Align.LEFT, type = String.class, length = 8, padding = ' ')
    private String gramNo;
	
	@Field(align = Align.LEFT, type = String.class, length = 1, padding = ' ')
    private String akRspDc;
	
	@Field(align = Align.LEFT, type = String.class, length = 2, padding = ' ')
    private String rspBizDc;
	
	@Field(align = Align.LEFT, type = String.class, length = 17, padding = ' ')
    private String gramAkDtti;
	
	@Field(align = Align.LEFT, type = String.class, length = 16, padding = ' ')
    private String ipAdd;
	
	@Field(align = Align.LEFT, type = String.class, length = 12, padding = ' ')
    private String tgtSvId;
	
	@Field(align = Align.RIGHT, type = Integer.class, length = 9, padding = '0')
    private int deNatvNo1;
    
	@Field(align = Align.RIGHT, type = Integer.class, length = 9, padding = '0')
	private int deNatvNo2;
	
	@Field(align = Align.LEFT, type = String.class, length = 20, padding = ' ')
    private String oriGrnCn;
	
	@Field(align = Align.LEFT, type = String.class, length = 1, padding = ' ')
    private String smlDeYn;
	
	@Field(align = Align.LEFT, type = String.class, length = 17, padding = ' ')
    private String gramRspDtti;
	
	@Field(align = Align.RIGHT, type = Integer.class, length = 1, padding = '0')
    private int pcRc;
	
	@Field(align = Align.LEFT, type = String.class, length = 8, padding = ' ')
    private String fstErrSysDc;
	
	@Field(align = Align.LEFT, type = String.class, length = 1, padding = ' ')
    private String chnlHdExsYn;
	
	@Field(align = Align.LEFT, type = String.class, length = 40, padding = ' ')
    private String exrFld;
}
