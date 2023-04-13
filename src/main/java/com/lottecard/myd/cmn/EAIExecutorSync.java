package com.lottecard.myd.cmn;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

import org.beanio.StreamFactory;
import org.beanio.builder.StreamBuilder;
import org.beanio.builder.FixedLengthParserBuilder;
import org.beanio.Marshaller;
import org.beanio.Unmarshaller;

public class EAIExecutorSync implements EAIExecutor {
	private String id;
	private String serverUrl;
	private String encoding;
	private int connectTimeOut;
	private int readTimeOut;
	private int port;
	private final int headerLength = 200;
	private final String format = "fixedlength";
	
	@Override
	public EaiHeader createHeader(String interfaceName) {
		EaiHeader eaiHeader = new EaiHeader();
		eaiHeader.setGramLnth(headerLength); // + data 길이 더 해줘야함
		eaiHeader.setGuid(""); // 롯데카드 헤더값
		eaiHeader.setGramPrgNo(0);
		eaiHeader.setGramNo(""); //enum
		eaiHeader.setAkRspDc(""); //요청응답값
		eaiHeader.setRspBizDc(""); //target 업구구분코드
		eaiHeader.setGramAkDtti(""); //전문요청일시
		eaiHeader.setIpAdd(""); //IP주소
		eaiHeader.setTgtSvId(""); //target 서비스 ID
		//eaiHeader.setDeNatvNo1(""); //거래고유번호1
		//eaiHeader.setDeNatvNo2(""); //거래고유번호1
		eaiHeader.setOriGrnCn("");
		eaiHeader.setSmlDeYn("N");
		eaiHeader.setChnlHdExsYn("N");
		
		return eaiHeader;
	}

	@Override
	public byte[] marshal(Object object, String interfaceName) throws UnsupportedEncodingException {
		StreamFactory streamFactory = StreamFactory.newInstance();
		StreamBuilder builder = new StreamBuilder(interfaceName)
								        .format(format)
								        .strict()
								        .parser(new FixedLengthParserBuilder())
								        .addRecord(interfaceName.getClass());
	    streamFactory.define(builder);
		streamFactory.loadResource(interfaceName);
		Marshaller marshaller = streamFactory.createMarshaller(interfaceName);
		String result = marshaller.marshal(interfaceName, interfaceName.getClass()).toString();
		byte[] byteArray = result.getBytes(encoding);

		return byteArray;
	}

	@Override
	public Object unmarshal(byte[] response, String interfaceName) throws UnsupportedEncodingException {
		String responseStr = new String(response, encoding);
		
		StreamFactory streamFactory = StreamFactory.newInstance();
		StreamBuilder builder = new StreamBuilder("") // enum으로 바꿔야 함
								        .format(format)
								        .strict()
								        .parser(new FixedLengthParserBuilder())
								        .addRecord(interfaceName.getClass());
	    streamFactory.define(builder);
		streamFactory.loadResource(interfaceName);
		Unmarshaller unmarshaller = streamFactory.createUnmarshaller("stream명"); // enum으로 바꿔야 함
		Object result = unmarshaller.unmarshal(responseStr);
		
		return result;
	}

	@Override
	public byte[] read(byte[] request) {
//		EaiMessage reqMsg = EaiFactory.getInstance().newMessage();
//		reqMsg.setData("");
//		EaiMessage resMsg = proxy.requestReply("OLN.YL", reqMsg); // 하드 코딩 수정
//		return resMsg.getData();
		
		return null;
	}

	@Override
	public ResponseEAIOutDto execute(RequestEAIInDto inDto, String interfaceName) throws Exception {
		ResponseEAIOutDto outDto = null;
		
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		
		EaiHeader header = createHeader(interfaceName);
		
		inDto.setRequestHeader(header);
		
		byte[] marshalHeader = marshal(inDto.getRequestHeader(), interfaceName);
		byte[] marshalData = marshal(inDto.getRequestData(), interfaceName);
		
		byteArrayOutputStream.write(marshalHeader);
		byteArrayOutputStream.write(marshalData);
		
		byte[] request = byteArrayOutputStream.toByteArray();
		
		byte[] response = read(request);
		
		byteArrayOutputStream.flush();
		byteArrayOutputStream.close();
		
		byte headerStr[] = new byte[headerLength];
		byte dataStr[] = new byte[response.length - headerLength];
		
		headerStr = Arrays.copyOf(response, headerLength);
		dataStr = Arrays.copyOfRange(response, headerLength, response.length);
		
		Object resHeader = unmarshal(headerStr, interfaceName);
		Object resData = unmarshal(dataStr, interfaceName);

		//캐스팅 처리 해줘야함
		
//		outDto.setResponseHeader(resHeader);
//		outDto.setResponseData(resData);
		
		return outDto;
	}

}
