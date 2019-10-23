package com.jasypt.api.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.jasypt.util.text.BasicTextEncryptor;
import org.springframework.stereotype.Service;

import com.jasypt.api.service.JasyptService;
import com.jasypt.api.util.Constants;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class JasyptServiceImpl implements JasyptService {

	@Override
	public Map<String, String> jasyptEncrypt( String keyword, String privateData ) {
		Map<String, String> data = new HashMap<>();
		String encrypted = "";
		log.info( "keyword: {}", keyword );
		log.info( "privateData: {}", privateData );

		try {
			BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
			textEncryptor.setPassword(keyword);
	    	encrypted = textEncryptor.encrypt(privateData);
	    	log.info( encrypted );
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		
		data.put( Constants.RESPONSE ,  encrypted );

    	return data;
	}

	@Override
	public Map<String, String> jasyptDecrypt( String keyword, String privateData ) {
		Map<String, String> data = new HashMap<>();
		String decrypted = "";
		log.info( "keyword: {}", keyword );
		log.info( "privateData: {}", privateData );

		try {
			BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
	    	textEncryptor.setPassword(keyword);
	    	decrypted = textEncryptor.decrypt(privateData);
	    	log.info( decrypted );
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		
		data.put( Constants.RESPONSE,  decrypted );
    	
    	return data;
	}

}
