package me.kimihiqq.springbooturlshortener.domain.url.presentation;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import me.kimihiqq.springbooturlshortener.domain.url.application.ShortUrlService;
import me.kimihiqq.springbooturlshortener.domain.url.application.dto.UrlRequest;
import me.kimihiqq.springbooturlshortener.domain.url.application.dto.UrlResponse;

@RequiredArgsConstructor
@RestController
@RequestMapping
public class ShortUrlController {

	private final ShortUrlService shortUrlService;

	@PostMapping("/url")
	public ResponseEntity<UrlResponse> createShortUrl(@RequestBody @Valid UrlRequest urlRequest) {
		UrlResponse urlResponse = shortUrlService.createShortUrl(urlRequest);
		return new ResponseEntity<>(urlResponse, HttpStatus.CREATED);
	}

	@GetMapping("/url/{shortUrl}")
	public ResponseEntity<Void> redirectUrl(@PathVariable(name = "shortUrl") String shortUrl, HttpServletResponse response) throws
		IOException {
		String originUrl = shortUrlService.getOriginalUrl(shortUrl);
		response.sendRedirect(originUrl);
		return new ResponseEntity<>(HttpStatus.FOUND);
	}
}
