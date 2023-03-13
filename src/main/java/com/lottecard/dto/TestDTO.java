package com.lottecard.dto;

import com.lottecard.LocaValidation;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class TestDTO {
	
	@LocaValidation(name="AP01", example="AP01", required = true)
	private String name;
	
	@LocaValidation(name="LC01", example="1000", required = true)
	private Long value;
	
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

}
