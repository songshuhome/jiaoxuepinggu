package cn.edu.jxau.utils;

import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.log4j.Logger;

/**
 * JavaBean工具类 
 * BeanUtils
 * @author zclong 2017年8月21日
 */
public class BeanUtils {
	private static Logger logger = Logger.getLogger(BeanUtils.class);

	public static Class<?> forName(String className) {
		if (StringUtil.isBlank(className)) {
			return null;
		}
		try {
			return Class.forName(className);
		} catch (ClassNotFoundException e) {
			logger.error(e.getMessage(), e);
			throw new RuntimeException(e);
		}
	}

	public static Object getBean(String className) {
		return getBean(forName(className));
	}

	public static <T> Object getBean(Class<T> clazz) {
		try {
			return clazz.newInstance();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new RuntimeException(e);
		}
	}

	/**
	 * 将javaBean对象转为Map
	 * @param bean
	 * @return
	 */
	public static Map<String, Object> beanToMap(Object bean) {
		try {
			return PropertyUtils.describe(bean);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new RuntimeException(e);
		}
	}

	/**
	 * 把Map转换成指定类型的javabean对象
	 * @param map
	 * @param clazz
	 * @return
	 */
	public static <T> T mapToBean(Map<String, ?> map, Class<T> clazz) {
		try {
			// 1.创建指定类型的javabean对象
			T bean = clazz.newInstance();
			// 2.把数据分装到bean中
			org.apache.commons.beanutils.BeanUtils.populate(bean, map);
			// 返回bean对象
			return bean;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new RuntimeException(e);
		}
	}

}
