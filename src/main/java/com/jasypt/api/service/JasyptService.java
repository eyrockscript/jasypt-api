package com.jasypt.api.service;

import java.util.Map;

public interface JasyptService {

	public Map<String, String> jasyptEncrypt( String keyword, String privateData );
	
	public Map<String, String> jasyptDecrypt( String keyword, String privateData );
}