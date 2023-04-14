package com.xxland.myspringboot.controller;


import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xxland.myspringboot.common.LogUtils;
import com.xxland.myspringboot.common.exception.BadRequestException;
import com.xxland.myspringboot.common.response.ApiResponseBase;
import com.xxland.myspringboot.common.service.ApiServiceBase;

import jakarta.servlet.http.HttpServletResponse;


@RestController
public class ApiController {
	@Autowired
	ApplicationContext applicationContext;
	@Autowired
	ObjectMapper objectMapper;
//	@AUTOWIRED
//	COMMONAUTHSERVICE COMMONAUTHSERVICE;

//	@Autowired
//	LoginAPI loginAPI;
	
//	static {
//	org.apache.ibatis.logging.LogFactory.useLog4J2Logging();
//	}
//private static Logger logger = LogManager.getLogger(ApiController.class);

	@RequestMapping("api/{apiName}")
	public ApiResponseBase apiExecute(@PathVariable("apiName") String apiName, @RequestBody(required = false) String requestBody,
			@RequestHeader(name = "user", required = false) String userId,
			@RequestHeader(name = "groups", required = false) String groups,
			@RequestHeader(name = "password", required = false) String loginPassword,
			HttpServletResponse response)
			throws Exception {

		if(ObjectUtils.isEmpty(requestBody)) {
			response.sendError(HttpServletResponse.SC_FORBIDDEN);
			return null;
		}

		if(loginPassword != null && loginPassword != "") {
			// ログインパスワードが設定されている場合

			// パスワードのチェックを行う
//			int result = loginAPI.apiExecute(loginPassword);
//
//			if(result == 0) {
//				// 認証に失敗した場合
//
//				// 不正リクエストとして処理する。
//				throw new BadRequestException(
//						new Object() {
//						}.getClass().getEnclosingClass().getSimpleName(),
//						new Object() {
//						}.getClass().getEnclosingMethod().getName(),
//						0,
//						"不正なリクエストです。");
//			}else {
//				// 認証に成功した場合
//
//				// 処理なし
//			}
		}

		var logger = (LogUtils) applicationContext.getBean("apiLogger");

		logger.initialize(userId, userId, "APIService", "APIサービス");

		logger.debug("処理開始：API実行");
		logger.info("APIController userID:" + userId + " groups:" + groups);

		if(groups != null) {
			// グループIDがnullでない場合
			// ダブルクォーテーションを取り除く
			groups = groups.replaceAll("\"", "");
		}

//		commonAuthService.initialize(userId, groups);
		ApiServiceBase service = null;
		try {
			service = (ApiServiceBase) applicationContext.getBean(apiName.toLowerCase() + "_service");
		} catch (ClassCastException | NoSuchBeanDefinitionException e) {
			// 不正リクエストとして処理する。
			throw new BadRequestException(
					new Object() {
					}.getClass().getEnclosingClass().getSimpleName(),
					new Object() {
					}.getClass().getEnclosingMethod().getName(),
					0,
					"不正なリクエストです。",
					e);
		}
		logger.debug("処理終了：API実行");
		return service.Execute(requestBody);
	}
}

