package com.lottecard.myd.test.model.dto;

import com.lottecard.myd.cmn.annotations.LocaValidation;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class TestDTO {
	
	@LocaValidation(example="'20230401'", required = true, description = "name 필드에 대한 설명", pattern = "yyyyMMdd") 
	private String name;
	
	@LocaValidation(example="100", required = true, description = "value 필드에 대한 설명")
	private Long value;
	
	@LocaValidation(example="true", required = true, description = "flag 필드에 대한 설명")
	private boolean flag;

}
