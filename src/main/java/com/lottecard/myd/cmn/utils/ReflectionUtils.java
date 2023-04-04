package com.lottecard.myd.cmn.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionUtils {
	public static Object invokeSetter(Object obj, String methodName, Object param) throws Exception {
        try {
        	Method exMethod = obj.getClass().getMethod(methodName, param.getClass());

			if (exMethod.getReturnType().getName().equals("void")) {
				exMethod.invoke(obj, param);
			} else {
				return exMethod.invoke(obj, param);
			}
		} catch (IllegalAccessException lae) {
			throw lae;
		} catch (InvocationTargetException ite) {
			throw ite;
		}
        return null;
	}


	public static Object invoke(Object obj, String methodName, Object[] objList) throws Exception {
        Method[] methods = obj.getClass().getMethods();

		for (int i = 0; i < methods.length; i++) {
			if (methods[i].getName().equals(methodName)) {
				try {
					if (methods[i].getReturnType().getName().equals("void")) {
						methods[i].invoke(obj, objList);
					} else {
						return methods[i].invoke(obj, objList);
					}
				} catch (IllegalAccessException lae) {
					//System.out.println("LAE : " + lae.getMessage());
					throw lae;
				} catch (InvocationTargetException ite) {
					//System.out.println("ITE : " + ite.getMessage());
					throw ite;
				}
			}
		}
        return null;
	}

	public static boolean isExistMethod(Object obj, String methodName) throws Exception {
		boolean result = true;
		try{
			obj.getClass().getMethod(methodName, new Class<?>[0]);
		} catch(NoSuchMethodException ne) {
			result = false;
		}
        return result;
	}

	public static Object invokeGetter(Object obj, String methodName) throws Exception {
        Method method = obj.getClass().getMethod(methodName, new Class<?>[0]);
        return method.invoke(obj, new Object[0]);
	}
}
