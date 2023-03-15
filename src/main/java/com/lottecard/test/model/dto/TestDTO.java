package com.lottecard.test.model.dto;

import com.lottecard.annotations.LocaValidation;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class TestDTO {
	
	@LocaValidation(name="AP01", example="AP01", required = true)
	private String name;
	
	@LocaValidation(name="LC01", example="1000", required = true)
	private Long value;
	
	@LocaValidation(name="LC02", example="true", required = true)
	private boolean flag;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getValue() {
		return value;
	}
	public void setValue(Long value) {
		this.value = value;
	}
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}

}
