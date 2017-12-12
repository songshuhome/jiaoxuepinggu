package cn.edu.jxau.utils;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Ajax异步数据处理
 * @author zclong
 * 2017年12月12日
 */
public class AjaxResultHander extends ResultHander {

	public AjaxResultHander(HttpServletRequest request, HttpServletResponse response) {
		super(request, response);
	}

	public void doAjax(Map<String, Object> data) throws IOException {
		response.setContentType("application/json;charset=utf-8");
		PrintWriter writer = response.getWriter();
		String json = JsonUtils.Gson(false).toJson(data);
		if (logger.isDebugEnabled()) // json字符串比较大,降低消耗
			logger.debug("Ajax:" + json);
		writer.write(json);
	}
}
