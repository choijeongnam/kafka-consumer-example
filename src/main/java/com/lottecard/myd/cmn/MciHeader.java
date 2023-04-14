package com.lottecard.myd.cmn;

import org.beanio.annotation.Record;
import org.beanio.builder.Align;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.beanio.annotation.Field;

@Getter
@Setter
@NoArgsConstructor
@Record(name = "MciHeader", maxOccurs = 1)
public class MciHeader extends CommonHeader {
	@Field(align = Align.LEFT, type = String.class, length = 1, padding = ' ')
    private String chnlDc;
	
	@Field(align = Align.LEFT, type = String.class, length = 5, padding = ' ')
    private String ogc;
	
	@Field(align = Align.LEFT, type = String.class, length = 7, padding = ' ')
    private String eno;
	
	@Field(align = Align.LEFT, type = String.class, length = 13, padding = ' ')
    private String usid;
	
	@Field(align = Align.LEFT, type = String.class, length = 12, padding = ' ')
    private String pagId;
	
	@Field(align = Align.LEFT, type = String.class, length = 1, padding = ' ')
    private String urSecrGdc;
	
	@Field(align = Align.LEFT, type = String.class, length = 1, padding = ' ')
    private String pagSecrGdc;
	
	@Field(align = Align.LEFT, type = String.class, length = 1, padding = ' ')
    private String mciPrbYn;
	
	@Field(align = Align.LEFT, type = String.class, length = 19, padding = ' ')
    private String exrFld1;
	
	@Field(align = Align.LEFT, type = String.class, length = 1, padding = ' ')
    private String dePcRc;
	
	@Field(align = Align.RIGHT, type = Integer.class, length = 4, padding = '0')
    private int dtaMaxCt;
	
	@Field(align = Align.RIGHT, type = Integer.class, length = 4, padding = '0')
    private int inqPcCt;
	
	@Field(align = Align.LEFT, type = String.class, length = 180, padding = ' ')
    private String psNtKey;
    
	@Field(align = Align.LEFT, type = String.class, length = 1, padding = ' ')
	private String msgDspDc;
	
	@Field(align = Align.LEFT, type = String.class, length = 80, padding = ' ')
    private String msgCn;
	
	@Field(align = Align.LEFT, type = String.class, length = 8, padding = ' ')
    private String arbitMsgDc;
	
	@Field(align = Align.LEFT, type = String.class, length = 100, padding = ' ')
    private String pgmErrInfCn;
	
	@Field(align = Align.LEFT, type = String.class, length = 22, padding = ' ')
    private String exrFld2;
	
	@Field(align = Align.LEFT, type = String.class, length = 1, padding = ' ')
    private String cdDc;
	
	@Field(align = Align.LEFT, type = String.class, length = 1, padding = ' ')
    private String choDc;
	
	@Field(align = Align.LEFT, type = String.class, length = 1, padding = ' ')
	private String incpDc;
	
	@Field(align = Align.LEFT, type = String.class, length = 1, padding = ' ')
    private String pdDc;
	
	@Field(align = Align.LEFT, type = String.class, length = 16, padding = ' ')
    private String cdno;
	
	@Field(align = Align.LEFT, type = String.class, length = 13, padding = ' ')
    private String rrno;
	
	@Field(align = Align.LEFT, type = String.class, length = 20, padding = ' ')
    private String acno;
	
	@Field(align = Align.LEFT, type = String.class, length = 1, padding = ' ')
    private String pcDc;
	
	@Field(align = Align.LEFT, type = String.class, length = 80, padding = ' ')
    private String urDfCn;
	
	@Field(align = Align.LEFT, type = String.class, length = 6, padding = ' ')
    private String exrFld3;
	
}
