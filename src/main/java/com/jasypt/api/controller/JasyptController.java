package com.jasypt.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jasypt.api.dto.in.JasyptDTO;
import com.jasypt.api.service.JasyptService;

@RestController
@RequestMapping(value="/jasypt")
public class JasyptController {
	
	@Autowired
	JasyptService service;
	
	@PostMapping(value = "encrypt", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Object> encrypt( @RequestBody JasyptDTO request ) {
		return ResponseEntity.ok( service.jasyptEncrypt(request.getKeyword(), request.getPrivateData()) );
	}
	
	@PostMapping(value = "decrypt", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Object> decrypt( @RequestBody JasyptDTO request ) {
		return ResponseEntity.ok( service.jasyptDecrypt(request.getKeyword(), request.getPrivateData()) );
	}

}