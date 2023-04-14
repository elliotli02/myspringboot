package com.xxland.myspringboot.common.response;

/**
 * APIレスポンス ベースクラス
 * @author masuo
 *
 */
public abstract class ApiResponseBase {
	/**
	 * 結果コード
	 */
	public String resultCode;
	/**
	 * 結果説明
	 */
	public String resultDesc;
}