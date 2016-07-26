package com.ssm.controller.dto;

import com.ssm.base.format.ICheck;

/**
 * Created by guxudong on 2016/7/15.
 */
public class SearchRequest {
	@ICheck
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
