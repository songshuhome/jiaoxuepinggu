package cn.edu.jxau.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Json数据处理工具
 * JsonUtils
 * @author zclong 2017年8月21日
 */
public class JsonUtils {
	private static GsonBuilder builder = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").disableHtmlEscaping();
	private static Gson gson = builder.create();

	/**
	 * 获取漂亮格式化的Gson对象
	 * @param pretty 是否漂亮格式化
	 * @return
	 */
	public static Gson Gson(boolean pretty) {
		if (pretty)
			return builder.setPrettyPrinting().create();
		return gson;
	}

	@SuppressWarnings("unchecked")
	public static <T> String toJson(Object src, String className) {
		if (StringUtil.isBlank(className))
			return gson.toJson(src);
		Class<T> typeOfSrc = (Class<T>) BeanUtils.forName(className);
		return gson.toJson(src, typeOfSrc);
	}

	@SuppressWarnings("unchecked")
	public static <T> T fromJson(String json, String className) {
		Class<T> clazz = (Class<T>) BeanUtils.forName(className);
		return gson.fromJson(json, clazz);
	}
}
