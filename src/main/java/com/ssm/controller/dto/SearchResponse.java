package com.ssm.controller.dto;

/**
 * Created by guxudong on 2016/7/15.
 */
public class SearchResponse {
	private String sucess;
	private String errorCode;
	private String msg;

	public String getSucess() {
		return sucess;
	}

	public void setSucess(String sucess) {
		this.sucess = sucess;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "SearchResponse{" +
				"sucess='" + sucess + '\'' +
				", errorCode='" + errorCode + '\'' +
				", msg='" + msg + '\'' +
				'}';
	}
}
