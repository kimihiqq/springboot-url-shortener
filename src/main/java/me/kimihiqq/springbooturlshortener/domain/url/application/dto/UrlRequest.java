package me.kimihiqq.springbooturlshortener.domain.url.application.dto;

import jakarta.validation.constraints.NotBlank;
import me.kimihiqq.springbooturlshortener.domain.url.domain.ShortUrl;

public record UrlRequest(
	@NotBlank String originalUrl
) {

	public ShortUrl toEntity() {
		return ShortUrl.createShortUrl(originalUrl);
	}
}
