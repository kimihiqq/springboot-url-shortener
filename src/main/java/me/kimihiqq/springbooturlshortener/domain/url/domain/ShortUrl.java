package me.kimihiqq.springbooturlshortener.domain.url.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ShortUrl {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long shortId;

	@Column(nullable = false)
	private String originalUrl;

	@Column(unique = true)
	private String shortUrl;

	private long views;

	private ShortUrl(String originalUrl) {
		if (originalUrl == null) {
			throw new IllegalArgumentException("Origin URL must not be null");
		}
		this.originalUrl = originalUrl;
		this.views = 0;
	}

	public static ShortUrl createShortUrl(String originalUrl) {
		return new ShortUrl(originalUrl);
	}

	public void updateShortUrl(String shortenUrl) {
		if (shortenUrl == null) {
			throw new IllegalArgumentException("Origin URL must not be null");
		}
		this.shortUrl = shortenUrl;
	}

	public void updateView() {
		views++;
	}
}
