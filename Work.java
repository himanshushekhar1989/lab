package com.him;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.zip.CRC32;

public class Work {
	public static void main(String[] args) {
		final String currentTimeInSeconds = String.valueOf(System.currentTimeMillis() / 1000);
		System.out.println("currentTimeInSeconds : " + currentTimeInSeconds);
		final String hash = md5(
				"027698F677B74901AB103FC77D3060E8" + "26B981FFFAB24608A861264E01B29A35" + "https://api-1.lynda.com/courses?limit=2" + currentTimeInSeconds);
		System.out.println("Request Hash : " + hash);
	}

	public static String md5(final String content) {
		String result=null;
		try {
			result = checksum(content, "MD5");
		} catch (final NoSuchAlgorithmException e) {

		}
		return result;
	}
	public static String checksum(final String content, final String algorithm) throws NoSuchAlgorithmException {
		if (content == null)
			return null;
		final byte[] bytes = content.getBytes(Charset.forName("UTF-8"));
		return checksum(bytes, algorithm);
	}

	public static String checksum(final byte[] content, final String algorithm) throws NoSuchAlgorithmException {
		if (content == null)
			return null;

		String checksum;
		if ("CRC32".equalsIgnoreCase(algorithm)) {
			final CRC32 crc = new CRC32();
			crc.update(content);
			checksum = Long.toHexString(crc.getValue());
		} else {
			final MessageDigest digest = MessageDigest.getInstance(algorithm);
			digest.update(content);
			final byte[] digestBytes = digest.digest();
			checksum = encode(digestBytes);
		}

		return checksum;
	}

	public static String encode(final byte bytes[]) {
		if (bytes == null)
			return null;

		final StringBuffer sb = new StringBuffer(bytes.length * 2);
		final char[] hexChars = getHexChars();
		for (int i = 0; i < bytes.length; i++) {
			sb.append(hexChars[(bytes[i] & 0xf0) >>> 4]); // look up high nibble char
			sb.append(hexChars[bytes[i] & 0x0f]); // look up low nibble char
		}
		return sb.toString();
	}

	static char[] getHexChars() {
		final char[] hexChar = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'A', 'B', 'C', 'D', 'E', 'F' };
		return hexChar;
	}
}
