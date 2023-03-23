package com.lottecard.myd.test.model.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "response")
public class ExampleInDto {
	@XmlElement(name = "header")
	private Header header;
	@XmlElement(name = "body")
	private Body body;
	
	public Header getHeader() {
		return header;
	}

	public void setHeader(Header header) {
		this.header = header;
	}

	
	
	@Override
	public String toString() {
		return "ExampleInDto [header=" + header + ", body=" + body + "]";
	}



	static class Header{
		@XmlElement(name = "resultCode")
		private int resultCode;
		@XmlElement(name = "resultMsg")
        private String resultMsg;
		@XmlElement(name = "pageNo")
        private int pageNo;
		@XmlElement(name = "totalPage")
        private int totalPage;
		@XmlElement(name = "totCnt")
        private int totCnt;
		public int getResultCode() {
			return resultCode;
		}
		public void setResultCode(int resultCode) {
			this.resultCode = resultCode;
		}
		public String getResultMsg() {
			return resultMsg;
		}
		public void setResultMsg(String resultMsg) {
			this.resultMsg = resultMsg;
		}
		public int getPageNo() {
			return pageNo;
		}
		public void setPageNo(int pageNo) {
			this.pageNo = pageNo;
		}
		public int getTotalPage() {
			return totalPage;
		}
		public void setTotalPage(int totalPage) {
			this.totalPage = totalPage;
		}
		public int getTotCnt() {
			return totCnt;
		}
		public void setTotCnt(int totCnt) {
			this.totCnt = totCnt;
		}
		@Override
		public String toString() {
			return "Header [resultCode=" + resultCode + ", resultMsg=" + resultMsg + ", pageNo=" + pageNo
					+ ", totalPage=" + totalPage + ", totCnt=" + totCnt + "]";
		}
		
	}
	
	static class Body{
		@XmlElement(name = "items")
		items items;

		public items getItems() {
			return items;
		}

		public void setItems(items items) {
			this.items = items;
		}

		@Override
		public String toString() {
			return "Body [items=" + items + "]";
		}
		
	}
	
	static class items{
		@XmlElement(name = "item")
		item item;

		public item getItem() {
			return item;
		}

		public void setItem(item item) {
			this.item = item;
		}

		@Override
		public String toString() {
			return "items [item=" + item + "]";
		}
		
	}
	
	static class item{
		@XmlElement(name = "lectNm")
		private String lectNm;
		@XmlElement(name = "lectToDt")
		private int lectToDt;
		@XmlElement(name = "userCnt")
		private int userCnt;
		@XmlElement(name = "compCnt")
		private int compCnt;
		@XmlElement(name = "passCnt")
		private int passCnt;
		@XmlElement(name = "compRate")
		private int compRate;
		@XmlElement(name = "passRate")
		private int passRate;
		public String getLectNm() {
			return lectNm;
		}
		public void setLectNm(String lectNm) {
			this.lectNm = lectNm;
		}
		public int getLectToDt() {
			return lectToDt;
		}
		public void setLectToDt(int lectToDt) {
			this.lectToDt = lectToDt;
		}
		public int getUserCnt() {
			return userCnt;
		}
		public void setUserCnt(int userCnt) {
			this.userCnt = userCnt;
		}
		public int getCompCnt() {
			return compCnt;
		}
		public void setCompCnt(int compCnt) {
			this.compCnt = compCnt;
		}
		public int getPassCnt() {
			return passCnt;
		}
		public void setPassCnt(int passCnt) {
			this.passCnt = passCnt;
		}
		public int getCompRate() {
			return compRate;
		}
		public void setCompRate(int compRate) {
			this.compRate = compRate;
		}
		public int getPassRate() {
			return passRate;
		}
		public void setPassRate(int passRate) {
			this.passRate = passRate;
		}
		@Override
		public String toString() {
			return "item [lectNm=" + lectNm + ", lectToDt=" + lectToDt + ", userCnt=" + userCnt + ", compCnt=" + compCnt
					+ ", passCnt=" + passCnt + ", compRate=" + compRate + ", passRate=" + passRate + "]";
		}
		
	}
}