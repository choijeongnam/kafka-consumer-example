package com.lottecard.myd.cmn;

import java.io.UnsupportedEncodingException;

public interface EAIExecutor {
	public EaiHeader createHeader(String interfaceName);
	
	public byte[] marshal(Object object, String interfaceName) throws UnsupportedEncodingException;

	public Object unmarshal(byte[] response, String interfaceName) throws UnsupportedEncodingException;

	public byte[] read(byte[] request);

	public ResponseEAIOutDto execute(RequestEAIInDto inDto, String interfaceName) throws Exception;
	
}
