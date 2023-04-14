//package com.xxland.myspringboot.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Scope;
//import org.springframework.stereotype.Service;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.xxland.api.common.ResultConstant;
//import com.xxland.api.request.LoginRequest;
//import com.xxland.api.response.ApiResponseBase;
//import com.xxland.api.response.LoginResponse;
//import com.xxland.api.service.logic.LoginAPI;
//import com.xxland.common.LogUtils;
//
//@Service("login_service")
//@Scope("prototype")
//public class LoginService extends ApiServiceBase implements ResultConstant{
//
//	@Autowired
//	ObjectMapper objectMapper;
//
//	@Autowired
//	LogUtils apiLogger;
//
//	@Autowired
//	LoginAPI loginAPI;
//
//	private static final String LOG_START = "処理開始：ログインサービス";
//	private static final String LOG_END = "処理終了：ログインサービス";
//
//	@Override
//	@Transactional(rollbackFor = Exception.class)
//	public ApiResponseBase Execute(String requestBody) throws Exception {
//
//		try {
//			// 処理開始ログ出力
//			apiLogger.info(LOG_START);
//
//			// リクエスト Jsonデジリアライズ
//			LoginRequest requestParam =
//					objectMapper.readValue(requestBody, LoginRequest.class);
//
//			// レスポンスを生成する
//			LoginResponse response = new LoginResponse();
//
//			// リクエスト情報取得
//			String password = requestParam.password;
//
//			// パターンチェック
//			if(password == null || password.isEmpty()) {
//				// パスワードがnull or パスワードが空の場合
//
//				// パラメータ異常レスポンス設定
//				response.resultCode = ResultConstant.CODE_INV_PRM;
//				response.resultDesc = ResultConstant.DESC_INV_PRM;
//
//				return response;
//			}
//
//			// ログインAPIの実行
//			int result = loginAPI.apiExecute(password);
////			int result = 1;
//			// 取得結果チェック
//			if(result == 0) {
//				// 取得結果が0件の場合
//
//				// データ無しレスポンス設定
//				response.resultCode = ResultConstant.CODE_NO_DATA;
//				response.resultDesc = ResultConstant.DESC_NO_DATA;
//				return response;
//			}
//
//			// 処理成功レスポンス設定
//			response.resultCode = ResultConstant.CODE_OK;
//			response.resultDesc = ResultConstant.DESC_OK;
//
//			return response;
//
//		}finally {
//
//			// 処理終了ログ出力
//			apiLogger.info(LOG_END);
//		}
//	}
//
//}
//
