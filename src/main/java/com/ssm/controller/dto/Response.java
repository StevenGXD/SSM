package com.ssm.controller.dto;

/**
 * Created by guxudong on 2016/6/25.
 */

/**
 * 接口返回类型
 */
public class Response {

	String id;
	String ksid;
	boolean success;      // 查询是否成功
	Integer errorCode;
	String msg;              // 错误信息，查询成功则为空

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getKsid() {
		return ksid;
	}

	public void setKsid(String ksid) {
		this.ksid = ksid;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
