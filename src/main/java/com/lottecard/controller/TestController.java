package com.lottecard.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@PostMapping(value = "/test")
	public Object test() {
		return null;
	}
}
