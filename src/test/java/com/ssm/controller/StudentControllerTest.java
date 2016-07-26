package com.ssm.controller;

import com.ssm.BaseTest;
import com.ssm.biz.bean.Student;
import com.ssm.service.StudentService;
import org.junit.Before;
import org.junit.Test;

import javax.annotation.Resource;


public class StudentControllerTest extends BaseTest {

	@Resource
	private StudentService studentService;

	@Before
	public void setUp() throws Exception {
		System.out.println("test begin...");
	}

	@Test
	public void getStudentTest() {
        Student student = studentService.queryStudent(1);
        System.out.println(student);

	}
}