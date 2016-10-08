package me.vrekt.fh.hash;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class HashHelper {

	public static String sha1(String text) throws NoSuchAlgorithmException, UnsupportedEncodingException {

		MessageDigest crypt = MessageDigest.getInstance("SHA-1");
		crypt.reset();
		crypt.update(text.getBytes("UTF-8"));

		return new BigInteger(1, crypt.digest()).toString(16);
	}

	public static String md5(String text) throws NoSuchAlgorithmException, UnsupportedEncodingException {

		MessageDigest digest = MessageDigest.getInstance("MD5");
		digest.update(text.getBytes(), 0, text.length());
		return new BigInteger(1, digest.digest()).toString(16);

	}

	public static String sha256(String text) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest digest = MessageDigest.getInstance("SHA-256");
		digest.update(text.getBytes());
		byte[] md = digest.digest();

		return Base64.getEncoder().encodeToString(md);
	}

}
