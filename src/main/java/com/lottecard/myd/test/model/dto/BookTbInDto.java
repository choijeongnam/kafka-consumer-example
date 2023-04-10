package com.lottecard.myd.test.model.dto;

import java.util.List;

import com.lottecard.myd.cmn.annotations.LocaValidation;

import io.swagger.annotations.ApiModel;

@ApiModel(description="북dto")
public class BookTbInDto {
	
	@LocaValidation(description="메타",  required = false)
	private Meta meta;
	
	@LocaValidation(description="도큐먼트",  required = false)
	private List<Document> documents;
	
	public Meta getMeta() {
		return meta;
	}

	public void setMeta(Meta meta) {
		this.meta = meta;
	}

	public List<Document> getDocuments() {
		return documents;
	}

	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}


	public static class Meta{
		@LocaValidation(description="토탈카운트", example="10", required = false)
		int totalCount;
		
		@LocaValidation(description="페이지카운트", example="1", required = false)
		int pageableCount;
		
		@LocaValidation(description="페이지끝여부", example="true", required = false)
		boolean isEnd;
		public int getTotalCount() {
			return totalCount;
		}
		public void setTotalCount(int totalCount) {
			this.totalCount = totalCount;
		}
		public int getPageableCount() {
			return pageableCount;
		}
		public void setPageableCount(int pageableCount) {
			this.pageableCount = pageableCount;
		}
		public boolean isEnd() {
			return isEnd;
		}
		public void setEnd(boolean isEnd) {
			this.isEnd = isEnd;
		}
	}
	
	public static class Document{
		private String title;
		private String contents;
		private String url;
		private String isbn;
		private String pubDtti;
		private String[] authors;
		private String publisher;
		private String[] translators;
		private String price;
		private String salePrice;
		private String thumbnail;
		private String status;
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getContents() {
			return contents;
		}
		public void setContents(String contents) {
			this.contents = contents;
		}
		public String getUrl() {
			return url;
		}
		public void setUrl(String url) {
			this.url = url;
		}
		public String getIsbn() {
			return isbn;
		}
		public void setIsbn(String isbn) {
			this.isbn = isbn;
		}
		public String getPubDtti() {
			return pubDtti;
		}
		public void setPubDtti(String pubDtti) {
			this.pubDtti = pubDtti;
		}
		public String[] getAuthors() {
			return authors;
		}
		public void setAuthors(String[] authors) {
			this.authors = authors;
		}
		public String getPublisher() {
			return publisher;
		}
		public void setPublisher(String publisher) {
			this.publisher = publisher;
		}
		public String[] getTranslators() {
			return translators;
		}
		public void setTranslators(String[] translators) {
			this.translators = translators;
		}
		public String getPrice() {
			return price;
		}
		public void setPrice(String price) {
			this.price = price;
		}
		public String getSalePrice() {
			return salePrice;
		}
		public void setSalePrice(String salePrice) {
			this.salePrice = salePrice;
		}
		public String getThumbnail() {
			return thumbnail;
		}
		public void setThumbnail(String thumbnail) {
			this.thumbnail = thumbnail;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
	}
	
}
