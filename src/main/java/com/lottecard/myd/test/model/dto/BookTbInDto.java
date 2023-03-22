package com.lottecard.myd.test.model.dto;

import java.util.List;

import com.lottecard.myd.test.model.vo.BookTbEntity;

public class BookTbInDto {
	private Meta meta;
	private List<BookTbEntity> documents;
	
	public Meta getMeta() {
		return meta;
	}

	public void setMeta(Meta meta) {
		this.meta = meta;
	}

	public List<BookTbEntity> getDocuments() {
		return documents;
	}

	public void setDocuments(List<BookTbEntity> documents) {
		this.documents = documents;
	}


	public static class Meta{
		int totalCount;
		int pageableCount;
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
	
}
