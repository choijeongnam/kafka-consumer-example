package com.lottecard.myd.cmn.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LocaException extends RuntimeException {

	private ErrorCode errorCode;
	private String apiCode;
	//private ErrorPoint erroPoint;
	private String tranId;

	public LocaException(ErrorCode errorCode) {
		super(errorCode.getMessage());
		this.errorCode = errorCode;
	}

	public LocaException(ErrorCode errorCode, String message) {
		super(errorCode.getMessage() + "_" + message);
		this.errorCode = errorCode;
	}
}
