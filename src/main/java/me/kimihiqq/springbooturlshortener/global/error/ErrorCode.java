package me.kimihiqq.springbooturlshortener.global.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

	NOT_FOUND_SHORT_URL("F001", "존재하지 않는 SHORT URL 입니다.");

	private final String code;
	private final String message;
}
