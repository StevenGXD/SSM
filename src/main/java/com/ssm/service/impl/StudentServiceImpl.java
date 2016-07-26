package com.ssm.service.impl;

import com.ssm.biz.bean.Student;
import com.ssm.biz.dao.StudentMapper;
import com.ssm.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.SQLException;

/**
 * Created by dd on 2016/6/23.
 */

@Service
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentMapper studentMapper;

    @Override
    public Student queryStudent(int id) {
        Student student = null;
        try {
            student = studentMapper.selectStudentById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return student;
    }
}
