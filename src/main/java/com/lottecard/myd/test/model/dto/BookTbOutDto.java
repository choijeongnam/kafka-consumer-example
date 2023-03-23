package com.lottecard.myd.test.model.dto;

public class BookTbOutDto {
	private String title;
	private String contents;
	private String url;
	private String isbn;

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
