package com.lottecard.myd.cmn;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestMCIInDto {
	CommonHeader commonHeader;
	Object RequestData;
	String ifId;
}
