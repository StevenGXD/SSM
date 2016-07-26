package com.ssm.service.impl;

import com.ssm.base.exception.BizzException;
import com.ssm.base.format.Check;
import com.ssm.controller.dto.SearchRequest;
import com.ssm.controller.dto.SearchResponse;
import com.ssm.service.ResponseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by guxudong on 2016/7/15.
 */
@Service
public class ResponseServiceImpl implements ResponseService {
	private static final Logger LOGGER = LoggerFactory.getLogger(ResponseServiceImpl.class);

	@Override
	public SearchResponse initResponse(SearchRequest request) throws BizzException {
		SearchResponse response = new SearchResponse();
		response.setSucess("true");
		response.setErrorCode("0");

		long startTime = System.currentTimeMillis();
		try {
			Check.CheckBeanFormat(request);
			return response;
		} catch (BizzException e) {
			Map<String, Object> map = new HashMap<>();
			map.put("request", request);
			map.put("response", response);
			e.setObject(map);
			throw e;
		} catch (Exception e) {
			BizzException bizzException = new BizzException(e);
			Map<String, Object> map = new HashMap<>();
			map.put("request", request);
			map.put("response", response);
			bizzException.setObject(map);
			throw bizzException;
		} finally {
			LOGGER.debug("SeatManagerAction[ search ] Take: " + (System.currentTimeMillis() - startTime) + "ms");
		}
	}
}
