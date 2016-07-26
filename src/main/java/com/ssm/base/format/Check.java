package com.ssm.base.format;

import com.ssm.base.exception.BizzException;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by guxudong on 2016/7/15.
 */
public class Check {
	public static void CheckBeanFormat(Object obj) throws BizzException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
		Class<?> clazz = obj.getClass();
		Field[] declaredFields = clazz.getDeclaredFields();
		for (Field field : declaredFields) {
			ICheck checker = field.getAnnotation(ICheck.class);
			if (checker == null) {
				continue;
			}
			String fieldName = field.getName();
			Method declaredMethod = clazz.getDeclaredMethod("get" + fieldName.toUpperCase().charAt(0) + fieldName.substring(1));
			Object invoke = declaredMethod.invoke(obj);
			if (invoke == null) {
				throw new BizzException("1111", "[" + fieldName + "] Missed");
			}
		}
	}
}
