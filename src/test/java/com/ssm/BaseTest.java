package com.ssm;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

/**
 * Created by dd on 2016/6/24.
 */

@ContextConfiguration({"classpath:/config/spring/*.xml"})
public class BaseTest extends AbstractJUnit4SpringContextTests {
}
