package com.lottecard;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.lottecard.myd.MydataApplication;
import com.lottecard.myd.cmn.CommonHeader;
import com.lottecard.myd.cmn.aop.LogAspect;
import com.lottecard.myd.cmn.utils.BeanIOUtils;
import com.lottecard.myd.test.service.BookTbService;

import okhttp3.OkHttpClient;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = MydataApplication.class)
@AutoConfigureMockMvc
class MydataApplicationTests {

	@Test
	void contextLoads() throws IOException {
		org.beanio.StreamFactory streamFactory = org.beanio.StreamFactory.newInstance();
		streamFactory.loadResource("beanIO/commonHeader.xml");
		CommonHeader ch = new CommonHeader();
		ch.setGramLnth(123);
		ch.setGuid("20230411CMS0523");
		ch.setGramPrgNo(1);
		ch.setGramNo("CMS03001");
		ch.setAkRspDc("S");
		ch.setRspBizDc("AU");
		org.beanio.Marshaller marshaller = streamFactory.createMarshaller("request"); //stream name
		String fixed = marshaller.marshal("commonHeader", ch).toString();
		byte[] byteArray = fixed.getBytes("MS949");
		
		String fixed2 = new String(byteArray, "MS949"); 
		
		org.beanio.Unmarshaller unmarshaller = streamFactory.createUnmarshaller("request");
		CommonHeader cc = (CommonHeader) unmarshaller.unmarshal(fixed2);
		System.out.println(cc.toString());
	}

}
