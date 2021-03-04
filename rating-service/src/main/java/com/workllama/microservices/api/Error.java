/**
 * 
 */
package com.workllama.microservices.api;

import com.workllama.microservices.model.ErrorCode;

/**
 * @author Vivek Shukla
 *
 */
public class Error {

	private ErrorCode code;
	private String description;

	public Error(ErrorCode code, String description) {
		super();
		this.code = code;
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public ErrorCode getCode() {
		return code;
	}
}
