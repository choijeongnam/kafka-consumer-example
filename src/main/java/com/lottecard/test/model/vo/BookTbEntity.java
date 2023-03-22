package com.lottecard.test.model.vo;

import com.lottecard.cmn.model.vo.AbstractVO;

public class BookTbEntity extends AbstractVO {

	private String title;
	private String contents;
	private String url;
	private String isbn;
	private String pubDtti;
	//private String authors;
	private String publisher;
	private String[] translators;
	private String price;
	private String salePrice;
	private String thumbnail;
	private String status;
	private String fstCrtUsid;
	private String fstCrtDtti;
	private String ltChUsid;
	private String ltChDtti;
	private String[] authors;

	public String getTitle() {
		return title;
	}

	public String getContents() {
		return contents;
	}

	public String getUrl() {
		return url;
	}

	public String getIsbn() {
		return isbn;
	}

	public String getPubDtti() {
		return pubDtti;
	}

	public String getPublisher() {
		return publisher;
	}

	public String[] getTranslators() {
		return translators;
	}

	public String getPrice() {
		return price;
	}

	public String getSalePrice() {
		return salePrice;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public String getStatus() {
		return status;
	}

	public String getFstCrtUsid() {
		return fstCrtUsid;
	}

	public String getFstCrtDtti() {
		return fstCrtDtti;
	}

	public String getLtChUsid() {
		return ltChUsid;
	}

	public String getLtChDtti() {
		return ltChDtti;
	}

	public String[] getAuthors() {
		return authors;
	}

	public void setTitle(String title) {
		addAssignParameters("title");
		this.title = title;
	}

	public void setContents(String contents) {
		addAssignParameters("contents");
		this.contents = contents;
	}

	public void setUrl(String url) {
		addAssignParameters("url");
		this.url = url;
	}

	public void setIsbn(String isbn) {
		addAssignParameters("isbn");
		this.isbn = isbn;
	}

	public void setPubDtti(String pubDtti) {
		addAssignParameters("pubDtti");
		this.pubDtti = pubDtti;
	}

	public void setAuthors(String[] authors) {
		this.authors = authors;
	}

	public void setPublisher(String publisher) {
		addAssignParameters("publisher");
		this.publisher = publisher;
	}

	public void setTranslators(String[] translators) {
		addAssignParameters("translators");
		this.translators = translators;
	}

	public void setPrice(String price) {
		addAssignParameters("price");
		this.price = price;
	}

	public void setSalePrice(String salePrice) {
		addAssignParameters("salePrice");
		this.salePrice = salePrice;
	}

	public void setThumbnail(String thumbnail) {
		addAssignParameters("thumbnail");
		this.thumbnail = thumbnail;
	}

	public void setStatus(String status) {
		addAssignParameters("status");
		this.status = status;
	}

	public void setFstCrtUsid(String fstCrtUsid) {
		addAssignParameters("fstCrtUsid");
		this.fstCrtUsid = fstCrtUsid;
	}

	public void setFstCrtDtti(String fstCrtDtti) {
		addAssignParameters("fstCrtDtti");
		this.fstCrtDtti = fstCrtDtti;
	}

	public void setLtChUsid(String ltChUsid) {
		addAssignParameters("ltChUsid");
		this.ltChUsid = ltChUsid;
	}

	public void setLtChDtti(String ltChDtti) {
		addAssignParameters("ltChDtti");
		this.ltChDtti = ltChDtti;
	}
}
