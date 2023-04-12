package com.lottecard.myd.cmn.model;

public enum mciEnum {

	CMS00630("CMS00630", "mciHeader.xml", "CMS00630.xml");

	private String ifId;
	private String mciHeaderXml;
	private String mciDataXml;

	private mciEnum(String ifId, String mciHeaderXml, String mciDataXml) {
		this.ifId = ifId;
		this.mciHeaderXml = mciHeaderXml;
		this.mciDataXml = mciDataXml;
	}
}
