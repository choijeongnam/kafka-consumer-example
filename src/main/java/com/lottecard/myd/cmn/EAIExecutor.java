package com.lottecard.myd.cmn;

import org.springframework.context.annotation.PropertySource;

@PropertySource("url-${spring.profiles.active:local}.properties")
public class EAIExecutor {
	public void execute() {
		
	}
	
	
}
