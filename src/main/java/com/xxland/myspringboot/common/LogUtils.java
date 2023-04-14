package com.xxland.myspringboot.common;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.net.InetAddress;
import java.text.MessageFormat;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;

/**
 * ログ出力部品
 * @author Fukushima
 */
public class LogUtils {
	
	private static LogUtils instance;
	private Logger logger;

	/**
	 * ロガー定義
	 * @param <T> クラス
	 * @param clazz クラス
	 */
	private <T> LogUtils(Class<T> clazz) {

		this.logger = LogManager.getLogger(clazz);

		ThreadContext.clearMap();

		ThreadContext.put("pid", getPID());
		ThreadContext.put("machineName", getHostName());
	}

	/**
	 * 初期化処理
	 * @param userId 実行ユーザーID
	 * @param userName 実行ユーザー名
	 * @param programId プログラムID
	 * @param programName プログラム名
	 */
	public void initialize(
			String userId
			,String userName
			,String programId
			,String programName
			) {
			ThreadContext.put("userId", userId);
			ThreadContext.put("userName", userName);
			ThreadContext.put("programId", programId);
			ThreadContext.put("programName", programName);
	}

	/**
	 * LogUtils生成
	 * @param <T> クラス
	 * @param clazz クラス
	 * @return LogUtils
	 */
	public static <T> LogUtils getInstance(Class<T> clazz) {
		if (instance == null) {
            instance = new LogUtils(clazz);
        }
		return instance;
	}
//	/**
//	 * LogUtils生成
//	 * @param <T> クラス
//	 * @param clazz クラス
//	 * @return LogUtils
//	 */
//	public static <T> LogUtils () {
//		   return new LogUtils();
//	}
	/**
	 *	debugログ出力
	 *	@param message メッセージ
	 */
	public void debug(String message) {
		setNameClass();
		this.logger.debug(message);
	}
	/**
	 *	debugログ出力(Exception)
	 *	@param message メッセージ
	 *	@param ex Exception
	 */
	public void debug(String message,Exception ex) {
		setNameClass();
		this.logger.debug(message,ex);
	}
	/**
	 *	debugログ出力
	 *	@param message メッセージ
	 *	@param params 置換パラメータ
	 */
	public void debug(String message,Object... params) {
		setNameClass();
		this.logger.debug(MessageFormat.format(message,params));
	}
	/**
	 *	debugログ出力
	 *  @param ex エクセプション
	 *	@param message メッセージ
	 *	@param params 置換パラメータ
	 */
	public void debug(Exception ex,String message,Object... params) {
		setNameClass();
		this.logger.debug(MessageFormat.format(message,params),ex);

	}
	/**
	 *	infoログ出力
	 *	@param message メッセージ
	 */
	public void info(String message) {
		setNameClass();
		this.logger.info(message);
	}
	/**
	 *	infoログ出力(Exception)
	 *	@param message メッセージ
	 *	@param ex Exception
	 */
	public void info(String message,Exception ex) {
		this.logger.info(message,ex);
	}
	/**
	 *	infoログ出力
	 *	@param message メッセージ
	 *	@param params 置換パラメータ
	 */
	public void info(String message,Object... params) {
		setNameClass();
		this.logger.info(MessageFormat.format(message,params));
	}
	/**
	 *	infoログ出力(Exception)
	 *  @param ex エクセプション
	 *	@param message メッセージ
	 *	@param params 置換パラメータ
	 */
	public void info(Exception ex,String message,Object... params) {
		setNameClass();
		this.logger.info(MessageFormat.format(message,params),ex);
	}
	/**
	 *	warnログ出力
	 *	@param message メッセージ
	 */
	public void warn(String message) {
		this.logger.warn(message);
	}
	/**
	 *	warnログ出力(Exception)
	 *	@param message メッセージ
	 *	@param ex Exception
	 */
	public void warn(String message,Exception ex) {
		this.logger.warn(message,ex);
	}
	/**
	 *	warnログ出力
	 *	@param message メッセージ
	 *	@param params 置換パラメータ
	 */
	public void warn(String message,Object... params) {
		setNameClass();
		this.logger.warn(MessageFormat.format(message,params));
	}
	/**
	 *	warnログ出力(Exception)
	 *  @param ex エクセプション
	 *	@param message メッセージ
	 *	@param params 置換パラメータ
	 */
	public void warn(Exception ex,String message,Object... params) {
		setNameClass();
		this.logger.warn(MessageFormat.format(message,params),ex);
	}
	/**
	 *	errorログ出力
	 *	@param message メッセージ
	 */
	public void error(String message) {
		this.logger.error(message);
	}
	/**
	 *	errorログ出力(Exception)
	 *	@param message メッセージ
	 *	@param ex Exception
	 */
	public void error(String message,Exception ex) {
		this.logger.error(message,ex);
	}
	/**
	 *	errorログ出力
	 *	@param message メッセージ
	 *	@param params 置換パラメータ
	 */
	public void error(String message,Object... params) {
		setNameClass();
		this.logger.error(MessageFormat.format(message,params));
	}
	/**
	 *	errorログ出力(Exception)
	 *  @param ex エクセプション
	 *	@param message メッセージ
	 *	@param params 置換パラメータ
	 */
	public void error(Exception ex,String message,Object... params) {
		setNameClass();
		this.logger.error(MessageFormat.format(message,params),ex);
	}

	/**
	 * 実行しているマシンのホスト名取得
	 * @return ホスト名
	 */
	public static String getHostName() {
	    try {
	        return InetAddress.getLocalHost().getHostName();
	    }catch (Exception e) {
	        e.printStackTrace();
	    }
	    return "UnknownHost";
	}

	/**
	 * 名前空間～クラス名、メソッド名設定
	 */
	public void setNameClass() {

		// スタックトレースより名前空間～クラス取得し「.」で分割
		String[] nameClass = getClassName().split("\\.");

		// 名前空間～クラス名が存在する場合、パッケージ名とクラス名の分割
		StringBuilder pakcageName = new StringBuilder();
		if(nameClass.length != 0) {
			for (int i = 0 ; i < nameClass.length - 1 ; i++) {
				pakcageName.append(nameClass[i]);
				if(!(i == nameClass.length - 2)) {
					pakcageName.append(".");
				}
			}
			ThreadContext.put("packageName", pakcageName.toString());
			ThreadContext.put("className", nameClass[nameClass.length - 1]);
			ThreadContext.put("methodName", getMethodName());
		}else {
			ThreadContext.put("packageName", "");
			ThreadContext.put("className", "");
			ThreadContext.put("methodName", "");
		}
	}

    /**
     * 実行中の名前空間～クラス名取得
     * @return 名前空間～クラス名
     */
    public static String getClassName() {
        return Thread.currentThread().getStackTrace()[4].getClassName();
    }
    /**
     * 実行中のメソッド名取得
     * @return メソッド名
     */
    public static String getMethodName() {
        return Thread.currentThread().getStackTrace()[4].getMethodName();
    }
    /**
     * プロセスID取得
     * @return プロセスID
     */
    public static String getPID() {
    	RuntimeMXBean rt = ManagementFactory.getRuntimeMXBean();
        return rt.getName().split("@")[0];
    }
}

