package me.kimihiqq.springbooturlshortener.domain.algorithm;

import java.math.BigInteger;

public class Base62Algorithm implements UrlShorteningAlgorithm {
	private static final String BASE62 = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

	@Override
	public String shorten(String id) {
		BigInteger bigIntegerId = new BigInteger(id);
		StringBuilder sb = new StringBuilder();

		while (bigIntegerId.compareTo(BigInteger.ZERO) > 0) {
			sb.insert(0, BASE62.charAt(bigIntegerId.mod(BigInteger.valueOf(62)).intValue()));
			bigIntegerId = bigIntegerId.divide(BigInteger.valueOf(62));
		}

		return sb.toString();
	}

}
