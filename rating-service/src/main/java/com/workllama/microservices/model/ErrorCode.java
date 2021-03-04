package com.workllama.microservices.model;

public enum ErrorCode {
	BAD_REQUEST("BAD_REQUEST"), OTHER_FAILURE("OTHER_FAILURE"), NO_RECORD("NO_RECORD");

	private String value;

	private ErrorCode(String value) {
		this.value = value;
	}
}
