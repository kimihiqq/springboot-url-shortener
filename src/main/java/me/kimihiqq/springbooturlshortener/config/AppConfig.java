package me.kimihiqq.springbooturlshortener.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import me.kimihiqq.springbooturlshortener.domain.algorithm.Base62Algorithm;
import me.kimihiqq.springbooturlshortener.domain.algorithm.UrlShorteningAlgorithm;

@Configuration
public class AppConfig {

	@Bean
	public UrlShorteningAlgorithm urlShorteningAlgorithm() {
		return new Base62Algorithm();
	}
}
