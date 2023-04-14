package com.xxland.myspringboot.common.exception;

public class ApplicationException extends RuntimeException{

	private String className;
	private String methodName;
	protected int errorCode;
	protected String detailMessage;

	/**
	 * コンストラクタ
	 * @param className クラス名
	 * @param methodName メソッド名
	 * @param errorCode エラーコード
	 * @param detailMessage 詳細メッセージ
	 * @param t 例外オブジェクト
	 */
	public ApplicationException(String className, String methodName, int errorCode, String detailMessage, Throwable t) {

		super(t);
		this.className = className;
		this.methodName = methodName;
		this.errorCode = errorCode;
		this.detailMessage = detailMessage;

	}

	/**
	 * コンストラクタ
	 * @param className クラス名
	 * @param methodName メソッド名
	 * @param detailMessage 詳細メッセージ
	 * @param t 例外オブジェクト
	 */
	public ApplicationException(String className, String methodName, String detailMessage, Throwable t) {

		super(t);
		this.className = className;
		this.methodName = methodName;
		this.detailMessage = detailMessage;

	}

	/**
	 * コンストラクタ
	 * @param className クラス名
	 * @param methodName メソッド名
	 * @param t 例外オブジェクト
	 */
	public ApplicationException(String className, String methodName, Throwable t) {

		super(t);
		this.className = className;

	}

	/**
	 * コンストラクタ
	 * @param className クラス名
	 * @param methodName メソッド名
	 * @param errorCode エラーコード
	 * @param detailMessage 詳細メッセージ
	 */
	public ApplicationException(String className, String methodName, int errorCode, String detailMessage) {

		this.className = className;
		this.methodName = methodName;
		this.errorCode = errorCode;
		this.detailMessage = detailMessage;

	}

	/**
	 * コンストラクタ
	 * @param className クラス名
	 * @param methodName メソッド名
	 * @param detailMessage 詳細メッセージ
	 */
	public ApplicationException(String className, String methodName, String detailMessage) {

		this.className = className;
		this.methodName = methodName;
		this.detailMessage = detailMessage;

	}

	/**
	 * コンストラクタ
	 * @param className クラス名
	 * @param methodName メソッド名
	 */
	public ApplicationException(String className, String methodName) {

		this.className = className;
		this.methodName = methodName;

	}

	public String getClassName() {
		return className;
	}

	public String getMethodName() {
		return methodName;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public String getDetailMessage() {
		return detailMessage;
	}

}
