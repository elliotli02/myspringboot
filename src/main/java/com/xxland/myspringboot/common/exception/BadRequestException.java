package com.xxland.myspringboot.common.exception;


public class BadRequestException extends ApplicationException{

	public BadRequestException(String className, String methodName, int errorCode, String detailMessage, Throwable t) {
		super(className, methodName, errorCode, detailMessage, t);
	}

	public BadRequestException(String className, String methodName, int errorCode, String detailMessage) {
		super(className, methodName, errorCode, detailMessage);
	}

	public BadRequestException(String className, String methodName) {
		super(className, methodName);
	}
}
