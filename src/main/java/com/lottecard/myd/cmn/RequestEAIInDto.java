package com.lottecard.myd.cmn;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class RequestEAIInDto {
	private EaiHeader requestHeader;
	private Object requestData;
	private String ifId;
}
