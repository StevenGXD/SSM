package com.ssm.controller;

import com.ssm.base.exception.BizzException;
import com.ssm.biz.bean.Student;
import com.ssm.controller.dto.SearchRequest;
import com.ssm.controller.dto.SearchResponse;
import com.ssm.service.ResponseService;
import com.ssm.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * Created by dd on 2016/6/23.
 */
@Controller
@RequestMapping("/search")
public class StudentController {

	@Resource
	private StudentService studentService;

	@Resource
	private ResponseService responseService;

	@RequestMapping(value = "/searchStudent", method = RequestMethod.POST)
	@ResponseBody
	public String searchStudent(SearchRequest request) throws BizzException {
		SearchResponse response = responseService.initResponse(request);
		Student student = studentService.queryStudent(request.getId());
		if (student == null) {
			response.setErrorCode("111");
			response.setSucess("false");
			response.setMsg("null");
			return response.toString();
		}
		response.setMsg(student.toString());
		return response.toString();
	}

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView test() throws BizzException {
		ModelAndView mv = new ModelAndView("hello");

		return mv;
	}

}
