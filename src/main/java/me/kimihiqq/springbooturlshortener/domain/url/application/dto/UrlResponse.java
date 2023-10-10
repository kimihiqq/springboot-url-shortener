package me.kimihiqq.springbooturlshortener.domain.url.application.dto;

import lombok.Builder;
import me.kimihiqq.springbooturlshortener.domain.url.domain.ShortUrl;

@Builder
public record UrlResponse(
	String shortUrl
) {
	public static UrlResponse from(ShortUrl shortUrl) {
		return UrlResponse.builder()
			.shortUrl(shortUrl.getShortUrl())
			.build();
	}
}
