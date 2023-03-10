package com.lottecard.dto;

import com.lottecard.CheckValidator;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class TestDTO {
	
	@CheckValidator(name="test", example="이건 낫널로 줄래요", required = true)
	private String name;
	
	@CheckValidator(example = "test12222")
	private String value;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	

	
}
