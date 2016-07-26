package com.ssm.biz.dao;

import com.ssm.biz.bean.Student;
import org.springframework.stereotype.Repository;

/**
 * Created by dd on 2016/6/23.
 */

@Repository
public interface StudentMapper {
    public Student selectStudentById(int id);
}
