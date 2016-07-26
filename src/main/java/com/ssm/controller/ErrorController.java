package com.ssm.controller;

import com.ssm.base.exception.BizzException;
import com.ssm.controller.dto.Response;
import com.ssm.controller.dto.SearchResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by guxudong on 2016/7/15.
 */
@ControllerAdvice
public class ErrorController {
	private static final Logger logger = LoggerFactory.getLogger(ErrorController.class);
	/**
	 * 处理已被找到的可以匹配的异常
	 *
	 * @param e 捕捉到的异常
	 * @return 响应
	 */
	@ExceptionHandler(value = BizzException.class)
	@ResponseBody
	private SearchResponse handlerKnownException(HttpServletRequest request, BizzException e) {
		Map<String, Object> map = (Map<String, Object>) e.getObject();
		Object searchRequest = map.get("request");
		SearchResponse initResponse = (SearchResponse) map.get("response");
		switch (e.getErrorCode()) {
			case "899004":
				logger.error("[接口地址:" + request.getServletPath() + "][请求:" + searchRequest + "]", e);
				break;
			default:
				break;
		}
		initResponse.setSucess("false");
		initResponse.setErrorCode(e.getErrorCode());
		initResponse.setMsg(e.getMessage());
		return initResponse;
	}

	/**
	 * 处理未被处理的异常
	 *
	 * @param e 未发现的异常
	 * @return 错误信息
	 */
	@ExceptionHandler(value = Throwable.class)
	@ResponseBody
	private Response handlerUnknownException(HttpServletRequest request, Throwable e) {
		Response response = new Response();
		response.setSuccess(false);
		if (e instanceof HttpMessageConversionException) {
			response.setErrorCode(898003);
			logger.debug("字段信息格式错误", e);
			response.setMsg("Wrong Parameter");
		} else if (e instanceof HttpRequestMethodNotSupportedException) {
			response.setErrorCode(898012);
			response.setMsg("Method not supported");
		} else {
			response.setErrorCode(898004);
			response.setMsg(e.getMessage());
			logger.error("[紧急][未修复错误信息]", e);
		}
		return response;
	}

}
