package com.winston.utils;


import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

public class PasswordHelper {
	private String algorithmName = "md5";
	private int hashIterations = 2;
	private String salt = "lkjLKSJ887J";

	/**
	 * 加密加盐
	 * @param username
	 * @param password
	 */
	public String encryptPassword(String username, String password) {
		String newPassword = new SimpleHash(algorithmName, password,  ByteSource.Util.bytes(username), hashIterations).toHex();
		return newPassword;
	}

	public String encryptPasswordSalt(String password, String salt) {
		String newPassword = new SimpleHash(algorithmName, password,  ByteSource.Util.bytes(salt), hashIterations).toHex();
		return newPassword;
	}

	public String encryptString(String arg){
		return new SimpleHash(algorithmName, arg,  ByteSource.Util.bytes(this.salt), hashIterations).toHex();
	}

}
