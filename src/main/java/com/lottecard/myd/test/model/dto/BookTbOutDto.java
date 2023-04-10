package com.lottecard.myd.test.model.dto;

import com.lottecard.myd.cmn.annotations.LocaValidation;

public class BookTbOutDto {
	
	@LocaValidation(description="타이틀", example="10")
	private String title;
	
	@LocaValidation(description="컨텐츠 내용", example="10")
	private String contents;
	
	@LocaValidation(description="주소", example="10")
	private String url;
	
	@LocaValidation(description="아이에스비엔", example="10")
	private String isbn;
	
	@LocaValidation(description="테스트 아웃불", example="true")
	private Boolean testbool;

	public void setTitle(String title) {
		this.title = title;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
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
}
