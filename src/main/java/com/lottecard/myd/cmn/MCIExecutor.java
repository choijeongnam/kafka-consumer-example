package com.lottecard.myd.cmn;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.beanio.Unmarshaller;
import org.beanio.builder.StreamBuilder;

import com.lottecard.myd.cmn.model.mciIfSpec;

public class MCIExecutor {
	private String id;
	private String serverUrl;
	private String encoding;
	private int connectTimeOut;
	private int readTimeOut;
	private int port;
	private Socket client;
	private InputStream inputStream;
	private OutputStream outputStream;
	private final int headerLength = 800;

	public RequestMCIInDto createHeader(RequestMCIInDto inDto, String interfaceName) {
		MciHeader mciHeader = new MciHeader();

		mciHeader.setGramLnth(headerLength); // + data 길이 더 해줘야함
		mciHeader.setGuid(""); // 롯데카드 헤더값
		mciHeader.setGramPrgNo(0);
		mciHeader.setGramNo(""); //enum
		mciHeader.setAkRspDc(""); //요청응답값

		//추가 header값 set

		return null;
	}

	public byte[] marshal(Object inDto, String interfaceName) throws Exception {

		org.beanio.StreamFactory streamFactory = org.beanio.StreamFactory.newInstance();

		String recordName = mciIfSpec.valueOf(interfaceName).getReplyGramNo(); //명칭도 나중에 수정해야함
		org.beanio.builder.StreamBuilder builder = new StreamBuilder(recordName) //enum 정의
		        .format("fixedlength") //enum 정의
		        .strict()
		        .parser(new org.beanio.builder.FixedLengthParserBuilder())
		        .addRecord(interfaceName.getClass());
	    streamFactory.define(builder);

		streamFactory.loadResource(recordName);
		org.beanio.Marshaller marshaller = streamFactory.createMarshaller(recordName);
		String mciDto = marshaller.marshal(recordName, inDto).toString();
		byte[] byteArray = mciDto.getBytes(encoding);
		//ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		//byteArrayOutputStream.write(byteArray);
		return byteArray;
	}

	public ResponseMCIOutDto unmarshal(byte[] response) throws Exception {
		int responseLength = response.length;
		int dataLength = responseLength - headerLength;
		byte[] responseHeader = new byte[headerLength];
		byte[] responseData = new byte[dataLength];

		responseHeader = Arrays.copyOf(response, headerLength);
		responseData = Arrays.copyOfRange(response, headerLength, responseLength);

		String header = new String(responseHeader, encoding);
		org.beanio.StreamFactory streamFactory = org.beanio.StreamFactory.newInstance();
		streamFactory.loadResource("beanIO/commonHeader.xml"); //하드코딩 수정예정
		Unmarshaller unmarshaller = streamFactory.createUnmarshaller("request"); //하드코딩 수정예정
		CommonHeader cc = (CommonHeader) unmarshaller.unmarshal(header); //하드코딩 수정예정

		//본문 부분

		return null;
	}

	public void create(int connectTimeOut, int readTimeOut) throws UnknownHostException, IOException {
		SocketAddress socketAddress = new InetSocketAddress(serverUrl, port);
		client.connect(socketAddress, connectTimeOut);
		client.setSoTimeout(readTimeOut);
		client.setTcpNoDelay(true);
		client.setKeepAlive(true);
		outputStream = client.getOutputStream();
		inputStream = client.getInputStream();
	}

	public byte[] read() throws IOException {
		int value;
		byte readBytes[];
		int sizeLength;
		int buffSize;
		int len;
		byte rtnValue[];
		ByteArrayOutputStream out;
		value = 0;
		readBytes = new byte[5];
		value = inputStream.read(readBytes, 0, 5);
		sizeLength = 0;
		sizeLength = Integer.parseInt((new String(readBytes).trim()));
		buffSize = 2048;
		len = sizeLength - 5;
		if(len < buffSize)
			buffSize = len;
		rtnValue = null;
		out = null;

		try {
			out = new ByteArrayOutputStream(buffSize);
			out.write(readBytes, 0, value);
			value = 0;
			int read_bytes;
			for(read_bytes = 0; read_bytes < len; read_bytes += value) {
				int remained = len - read_bytes;
				if(buffSize > remained)	buffSize = remained;

				byte buffer[] = new byte[buffSize];
				value = inputStream.read(buffer, 0, buffer.length);

				if(value == -1) {
					//throw exception 예정
				}

				out.write(buffer, 0, value);
			}

			rtnValue = out.toByteArray();
			if(read_bytes + 5 < sizeLength) {
				Arrays.fill(rtnValue, read_bytes, sizeLength, (byte)32);
			}

		}catch(IOException ie) {
			//catch 구현 예정
		}finally {
			//소켓 close 예정
		}
		return rtnValue;
	}

	public ResponseMCIOutDto execute(RequestMCIInDto inDto, String interfaceName, int connectTimeOut, int readTimeOut) throws Exception {
		createHeader(inDto, interfaceName);

		byte[] requestHeader = marshal(inDto.getCommonHeader(), interfaceName);
		byte[] requestData = marshal(inDto.getRequestData(), interfaceName);

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		baos.write(requestHeader);
		baos.write(requestData);

		byte[] request = baos.toByteArray();

		create(connectTimeOut, readTimeOut);
		outputStream.write(request);
		outputStream.flush();


		byte[] response;
		response = read();
		ResponseMCIOutDto outDto = unmarshal(response);

		return outDto;
	}
	public ResponseMCIOutDto execute(RequestMCIInDto inDto, String interfaceName, int readTimeOut) throws Exception {

		return execute(inDto, interfaceName, this.connectTimeOut, readTimeOut);
	}
	public ResponseMCIOutDto execute(RequestMCIInDto inDto, String interfaceName) throws Exception {

		return execute(inDto, interfaceName, this.connectTimeOut, this.readTimeOut);
	}
}
