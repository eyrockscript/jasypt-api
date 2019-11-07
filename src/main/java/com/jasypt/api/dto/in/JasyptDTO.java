package com.jasypt.api.dto.in;

import java.io.Serializable;

import lombok.Data;

@Data
public class JasyptDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 19945784713093012L;
	private String keyword;
	private String privateData;
	
}
