package com.exception;
/**
 * 自定义异常
 * @author 沫凌
 *
 */
public class CustomException extends Exception {
	private String message;

	public CustomException(String message) {
		super(message);
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
