package com.xxland.myspringboot.common.service;

import com.xxland.myspringboot.common.response.ApiResponseBase;

public abstract class ApiServiceBase {
	public abstract ApiResponseBase Execute(String requestBody) throws Exception;
}
