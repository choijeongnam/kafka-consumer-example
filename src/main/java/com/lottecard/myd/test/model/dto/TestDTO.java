package com.lottecard.myd.test.model.dto;

import com.lottecard.myd.annotations.LocaValidation;

import io.swagger.annotations.ApiModelProperty;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class TestDTO {
	
	@LocaValidation(example="'20320101'", required = true, description = "이름", pattern = "yyyyMMdd") 
	private String name;
	
	@LocaValidation(example="1000", required = true, description = "밸류")
	private Long value;
	
	@LocaValidation(example="true", required = true, description = "플래그값")
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
