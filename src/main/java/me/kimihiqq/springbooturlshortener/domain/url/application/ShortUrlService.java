package me.kimihiqq.springbooturlshortener.domain.url.application;

import static me.kimihiqq.springbooturlshortener.global.error.ErrorCode.NOT_FOUND_SHORT_URL;

import java.util.Optional;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import me.kimihiqq.springbooturlshortener.domain.algorithm.UrlShorteningAlgorithm;
import me.kimihiqq.springbooturlshortener.domain.url.domain.ShortUrl;
import me.kimihiqq.springbooturlshortener.domain.url.application.dto.UrlRequest;
import me.kimihiqq.springbooturlshortener.domain.url.application.dto.UrlResponse;
import me.kimihiqq.springbooturlshortener.domain.url.domain.ShortUrlRepository;
import me.kimihiqq.springbooturlshortener.global.error.exception.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class ShortUrlService {

	private final ShortUrlRepository shortUrlRepository;
	private final UrlShorteningAlgorithm urlShorteningAlgorithm;

	private String generateShortenedUrl(String shortId) {
		return urlShorteningAlgorithm.shorten(shortId);
	}

	@Transactional
	public UrlResponse createShortUrl(UrlRequest urlRequest) {

		Optional<ShortUrl> optionalShortUrl = shortUrlRepository.findByOriginalUrl(urlRequest.originalUrl());

		if (optionalShortUrl.isPresent()) {
			ShortUrl shortUrl = optionalShortUrl.get();
			shortUrl.updateView();
			return UrlResponse.from(shortUrl);
		}

		ShortUrl shortUrl =urlRequest.toEntity();
		shortUrlRepository.save(shortUrl);

		String shortenedUrl = generateShortenedUrl(shortUrl.getShortId().toString());

		shortUrl.updateShortUrl(shortenedUrl);

		return UrlResponse.from(shortUrl);
	}

	@Transactional
	public String getOriginalUrl(String shortUrl) {
		ShortUrl foundShortUrl = shortUrlRepository.findByShortUrl(shortUrl)
			.orElseThrow(() -> new EntityNotFoundException(NOT_FOUND_SHORT_URL));

		foundShortUrl.updateView();
		shortUrlRepository.save(foundShortUrl);

		return foundShortUrl.getOriginalUrl();
	}
}
