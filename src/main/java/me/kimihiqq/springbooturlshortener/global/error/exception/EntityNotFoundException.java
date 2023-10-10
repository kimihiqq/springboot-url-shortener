package me.kimihiqq.springbooturlshortener.global.error.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import me.kimihiqq.springbooturlshortener.global.error.ErrorCode;

@Getter
@AllArgsConstructor
public class EntityNotFoundException extends RuntimeException {

	private final ErrorCode errorCode;
}
