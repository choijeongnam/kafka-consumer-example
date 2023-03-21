package com.lottecard;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import okhttp3.OkHttpClient;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class MydataApplicationTests {
	@Autowired
	private OkHttpClient okHttpClient;
	
	@Test
	void contextLoads() {
		System.out.println("test 빈 들어오나"+ okHttpClient);
	}

}
