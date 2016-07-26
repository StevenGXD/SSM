package com.ssm.base.exception;


/**
 * Created by guxudong on 2016/7/15.
 */
public class BizzException extends Exception {
	private String errorCode = "0";

	private String messageInfo = null;
	
	private Object object = null;

	public BizzException(String errorCode, String messageInfo) {
		super(messageInfo);
		this.messageInfo = messageInfo;
		this.errorCode = errorCode;
	}

	/**
	 * 用于从已存在的错误继承错误代码和错误信息自定义
	 *
	 * @param error
	 */
	public BizzException(BizzException error) {
		this(error.getErrorCode(), error.getMessageInfo());
	}

	/**
	 * 用于从已存在的错误继承错误代码和错误信息自定义
	 *
	 * @param error
	 */
	public BizzException(Throwable error) {
		super(error);
		this.errorCode = "890004";
		this.messageInfo = "system error";
	}

	/**
	 * 用于从存在的异常中生成信息不同的错误
	 *
	 * @param error
	 * @param msg
	 */
	public BizzException(BizzException error, String msg) {
		this(error.getErrorCode(), msg == null ? error.getMessageInfo() : msg);
	}

	/**
	 * 用于自定义context
	 *
	 * @param error
	 * @param object
	 */
	public BizzException(BizzException error, Object object) {
		this(error.getErrorCode(), error.getMessageInfo());
		this.object = object;
	}

	public BizzException(BizzException error, String msg, Object object) {
		this(error.getErrorCode(), msg);
		this.object = object;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getMessageInfo() {
		return messageInfo;
	}

	public void setMessageInfo(String messageInfo) {
		this.messageInfo = messageInfo;
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}
	
}
