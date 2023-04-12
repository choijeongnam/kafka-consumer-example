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

import org.beanio.Unmarshaller;

import com.lottecard.myd.cmn.exception.LocaException;
import com.lottecard.myd.cmn.model.ifSpec;

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

	public byte[] marshal(RequestMCIInDto inDto, String interfaceName) throws Exception {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		org.beanio.StreamFactory streamFactory = org.beanio.StreamFactory.newInstance();
		streamFactory.loadResource(ifSpec.valueOf(interfaceName).getHeaderPath()); //하드코딩 수정예정
		org.beanio.Marshaller marshaller = streamFactory.createMarshaller("request"); //하드코딩 수정예정
		String header = marshaller.marshal("commonHeader", inDto.commonHeader).toString(); //하드코딩 수정예정
		byte[] headerByteArray = header.getBytes(encoding);

		byteArrayOutputStream.write(headerByteArray);

		//본문부분 구현예정

		return byteArrayOutputStream.toByteArray();
	}

	public ResponseMCIOutDto unmarshal(byte[] response) throws Exception {
		int responseLength = response.length;
		int headerLength = 800;
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
		byte[] request = marshal(inDto, interfaceName);
		create(connectTimeOut, readTimeOut);
		outputStream.write(request);
		outputStream.flush();
		byte[] response;
		response = read();
		ResponseMCIOutDto outDto = unmarshal(response);

		return outDto;
	}
	public ResponseMCIOutDto execute(RequestMCIInDto inDto, String interfaceName, int readTimeOut) throws Exception {
		byte[] request = marshal(inDto, interfaceName);
		create(this.connectTimeOut, readTimeOut);
		outputStream.write(request);
		outputStream.flush();
		byte[] response;
		response = read();
		ResponseMCIOutDto outDto = unmarshal(response);

		return outDto;
	}
	public ResponseMCIOutDto execute(RequestMCIInDto inDto, String interfaceName) throws Exception {
		byte[] request = marshal(inDto, interfaceName);
		create(this.connectTimeOut, this.readTimeOut);
		outputStream.write(request);
		outputStream.flush();
		byte[] response;
		response = read();
		ResponseMCIOutDto outDto = unmarshal(response);

		return outDto;
	}
}
