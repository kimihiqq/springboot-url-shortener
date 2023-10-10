package me.kimihiqq.springbooturlshortener.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import me.kimihiqq.springbooturlshortener.domain.url.application.ShortUrlService;
import me.kimihiqq.springbooturlshortener.domain.url.application.dto.UrlRequest;
import me.kimihiqq.springbooturlshortener.domain.url.application.dto.UrlResponse;

@Controller
@RequestMapping("/shortener")
@RequiredArgsConstructor
public class ShortUrlViewController {

	private final ShortUrlService shortUrlService;

	@GetMapping("/form")
	public String form(Model model) {
		return "index";
	}

	@PostMapping("/form")
	public String createShortUrlFromForm(UrlRequest urlRequest, Model model) {
		UrlResponse urlResponse = shortUrlService.createShortUrl(urlRequest);
		model.addAttribute("shortUrl", urlResponse.shortUrl());
		return "index";
	}
}
