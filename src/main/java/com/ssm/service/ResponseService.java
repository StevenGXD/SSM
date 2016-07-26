package com.ssm.service;

import com.ssm.base.exception.BizzException;
import com.ssm.controller.dto.SearchRequest;
import com.ssm.controller.dto.SearchResponse;

/**
 * Created by guxudong on 2016/7/15.
 */
public interface ResponseService {
	public SearchResponse initResponse(SearchRequest request) throws BizzException;
}
