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

import com.lottecard.myd.cmn.aop.LogAspect;
import com.lottecard.myd.test.service.BookTbService;

import okhttp3.OkHttpClient;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class MydataApplicationTests {
	@Autowired
	private BookTbService bookTbService;

    private static final Logger logger = LoggerFactory.getLogger(MydataApplicationTests.class);

	@Test
	void contextLoads() throws IOException {
		Map<String, String> user = new HashMap<String, String>();

		user.put("email_id", "sookyeonghan@dongkuk.com");
		JSONObject userDetails = new JSONObject(user);

		logger.debug("마스킹 되냐고요!!!! JSON: {}", userDetails);

		System.err.println("마스킹 되냐고요!!!! JSON:" + userDetails);
	}

}
