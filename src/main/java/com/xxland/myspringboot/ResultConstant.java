package com.xxland.myspringboot;

public interface ResultConstant {
	String CODE_OK = "OK";
	String DESC_OK = "";

	String CODE_INV_PRM = "INVALID_PARAM";
	String DESC_INV_PRM = "パラメータが不正です。";

	String CODE_AUTH_ERR = "AUTH_ERROR";
	String DESC_AUTH_ERR = "要求された処理は認可されていません。";

	String CODE_NO_DATA = "NO_DATA";
	String DESC_NO_DATA = "データがありません。";

	String CODE_HAS_SAME_AUTH_ID = "HAS_SAME_AUTH_ID";
	String DESC_HAS_SAME_AUTH_ID = "権限IDがすでに存在します。";

	String CODE_HAS_SAME_AUTH_NAME = "HAS_SAME_AUTH_NAME";
	String DESC_HAS_SAME_AUTH_NAME = "権限名がすでに存在します。";

	String CODE_SYSTEM_ERR = "SYSTEM_ERROR";
	String DESC_SYSTEM_ERR = "システムエラー";

	String CODE_SYSTEM_CLS = "SYSTEM_CLOSED";
	String DESC_SYSTEM_CLS = "システム閉局";

}
