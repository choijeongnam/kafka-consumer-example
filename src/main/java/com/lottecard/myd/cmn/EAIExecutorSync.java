package com.lottecard.myd.cmn;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class EAIExecutorSync implements EAIExecutor {
	private String id;
	private String serverUrl;
	private String encoding;
	private int connectTimeOut;
	private int readTimeOut;
	private int port;
	private Socket client;
	private InputStream inputStream;
	private OutputStream outputStream;
	private final int headerLength = 200;
	
	@Override
	public RequestEAIInDto createHeader(RequestMCIInDto inDto, String interfaceName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public byte[] marshal(RequestMCIInDto inDto, String interfaceName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEAIOutDto unmarshal(byte[] response) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public byte[] read() {
//		EaiMessage reqMsg = EaiFactory.getInstance().newMessage();
//		reqMsg.setData("");
//		EaiMessage resMsg = proxy.requestReply("OLN.YL", reqMsg); // 하드 코딩 수정
		
		return null;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub

	}

}
