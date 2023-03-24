package com.lottecard;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.lottecard.myd.test.service.BookTbService;

import okhttp3.OkHttpClient;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class MydataApplicationTests {
	@Autowired
	private BookTbService bookTbService;

	@Test
	void contextLoads() throws IOException {
		bookTbService.SelectOne("별이빛나는밤에");
	}

}
