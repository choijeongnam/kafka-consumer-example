package com.lottecard.myd.cmn;


public interface EAIExecutor {
	public RequestEAIInDto createHeader(RequestMCIInDto inDto, String interfaceName);
	
	public byte[] marshal(RequestMCIInDto inDto, String interfaceName);

	public ResponseEAIOutDto unmarshal(byte[] response);

	public byte[] read();

	public void execute();
	
}
