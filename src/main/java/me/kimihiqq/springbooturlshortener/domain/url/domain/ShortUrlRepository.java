package me.kimihiqq.springbooturlshortener.domain.url.domain;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ShortUrlRepository extends JpaRepository<ShortUrl, Long> {
	Optional<ShortUrl> findByOriginalUrl(String originUrl);
	Optional<ShortUrl> findByShortUrl(String shortUrl);
}
