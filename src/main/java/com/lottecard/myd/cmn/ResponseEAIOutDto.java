package com.lottecard.myd.cmn;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ResponseEAIOutDto {
	private EaiHeader responseHeader;
	private Object responseData;
}
