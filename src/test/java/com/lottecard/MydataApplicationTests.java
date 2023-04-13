package com.lottecard;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.beanio.Marshaller;
import org.beanio.StreamFactory;
import org.beanio.Unmarshaller;
import org.beanio.builder.FixedLengthParserBuilder;
import org.beanio.builder.StreamBuilder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.FixedWidth;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.lottecard.myd.MydataApplication;
import com.lottecard.myd.cmn.CommonData;
import com.lottecard.myd.cmn.CommonHeader;
import com.lottecard.myd.cmn.EAIExecutorSync;
import com.lottecard.myd.cmn.EaiHeader;
import com.lottecard.myd.cmn.EaiIfSpec;
import com.lottecard.myd.cmn.MciHeader;
import com.lottecard.myd.cmn.RcvDenyChnlRgIz;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = MydataApplication.class)
@AutoConfigureMockMvc
class MydataApplicationTests {
//
//	@Autowired
//	private BeanIOUtils beanIOUtils;
//
//	@Test
//	void marshal() {
//		// given
//		BeanIODto dto = new BeanIODto();
//
//		Map<String, Object> header = new HashMap<>();
//		header.put("TX_CODE", "a12");
//		header.put("GUID", UUID.randomUUID().toString());
//		header.put("LENGTH", 45);
//		dto.setHeader(header);
//
//		Map<String, Object> body = new HashMap<>();
//		body.put("MESSAGE", "HI !!");
//		body.put("TO", "010-1234-5678");
//		dto.setBody(body);
//
//		// when
//		String result = beanIOUtils.marshal(dto);
//
//		// then
//		assertThat(result).hasSize(79);
//		//log.info("result: {}", result); // result: a12 70affc50-46fd-4145-a2a1-d495f73200045HI !! 010-1234-5678 @@
//	}
//
//	@Test
//	void unmarshal() {
//		// given
//		String record = "a12            b1ef6fcf-6371-4459-9ecb-b7e1d48a00045HI !!     010-1234-5678  @@";
//
//		// when
//		BeanIODto dto = beanIOUtils.unmarshal(record);
//
//		// then
//		assertAll(() -> assertThat(dto).isNotNull(), () -> assertThat(dto.getHeader()).hasSize(3),
//				() -> assertThat(dto.getBody()).hasSize(2), () -> assertThat(dto.getEnd()).isEqualTo("@@"));
//		//log.info("dto: {}", dto); // dto: BeanIODto(header={LENGTH=45, TX_CODE=a12,
//									// GUID=b1ef6fcf-6371-4459-9ecb-b7e1d48a}, body={MESSAGE=HI !!,
//									// TO=010-1234-5678}, end=@@)
//	}

	@Test
	void contextLoads() throws IOException {
//		EAIExecutorSync executor = new EAIExecutorSync();
//		EaiHeader
//		executor.marshal(, interfaceName)

//		RcvDenyChnlRgIz rcvDenyChnlRgIz = new RcvDenyChnlRgIz();
//		rcvDenyChnlRgIz.setRcvDenyYn("y");
//		rcvDenyChnlRgIz.setRgDt("f");
//		rcvDenyChnlRgIz.setRgrEno("f");
//		rcvDenyChnlRgIz.setRgrNm("f");
//		rcvDenyChnlRgIz.setChnlKndc("a");
//		rcvDenyChnlRgIz.setRcvDenyCnC("dsd");
//		List<RcvDenyChnlRgIz> list = new ArrayList();
//		list.add(rcvDenyChnlRgIz);
//
//		cd.setCno("fsdfdf");
//		//cd.setRcvDenyChnlRgIz(list);
//		cd.setRcvDenyChnlRgIzCnt(12);
//
//				String fixed2 = new String(byteArray, "MS949");

//		CommonHeader ch = new CommonHeader();
//		ch.setGramLnth(123);
//		ch.setGuid("20230411CMS0523");
//		ch.setGramPrgNo(1);
//		ch.setGramNo("CMS03001");
//		ch.setAkRspDc("S");
//		ch.setRspBizDc("AU");
//		Marshaller marshaller = streamFactory.createMarshaller("request"); //stream name
//		String fixed = marshaller.marshal("commonHeader", ch).toString();
//		byte[] byteArray = fixed.getBytes("MS949");
//
//		String fixed2 = new String(byteArray, "MS949");
//
//		Unmarshaller unmarshaller = streamFactory.createUnmarshaller("request");
//		CommonHeader cc = (CommonHeader) unmarshaller.unmarshal(fixed2);
//		System.out.println(cc.toString());
//
//		CommonData cd = new CommonData();
//		RcvDenyChnlRgIz rcvDenyChnlRgIz = new RcvDenyChnlRgIz();
//		rcvDenyChnlRgIz.setRcvDenyYn("y");
//		rcvDenyChnlRgIz.setRgDt("f");
//		rcvDenyChnlRgIz.setRgrEno("f");
//		rcvDenyChnlRgIz.setRgrNm("f");
//		rcvDenyChnlRgIz.setChnlKndc("a");
//		rcvDenyChnlRgIz.setRcvDenyCnC("dsd");
//		List<RcvDenyChnlRgIz> list = new ArrayList();
//		list.add(rcvDenyChnlRgIz);
//
//		cd.setCno("fsdfdf");
//		cd.setRcvDenyChnlRgIz(list);
//		cd.setRcvDenyChnlRgIzCnt(12);
//
//
//		Marshaller marshallerData = streamFactory.createMarshaller("requestData"); //stream name
//		String fixedData = marshallerData.marshal("commonData", cd).toString();
//		System.out.println(fixedData.toString());
		CommonData c = new CommonData();
		c.setCno("1");
		
		StreamFactory streamFactory = StreamFactory.newInstance();
		StreamBuilder builder = new StreamBuilder(EaiIfSpec.YLS00006.getServiceId())
								        .format("fixedlength")
								        .strict()
								        .parser(new FixedLengthParserBuilder())
								        .addRecord(EaiIfSpec.YLS00006.getRequestData());
	    streamFactory.define(builder);
		Marshaller marshaller = streamFactory.createMarshaller(EaiIfSpec.YLS00006.getServiceId());
		String result = marshaller.marshal(EaiIfSpec.YLS00006.getServiceId(), c).toString();
		System.out.println(result);
		byte[] byteArray = result.getBytes("MS949");

		
	}

}
