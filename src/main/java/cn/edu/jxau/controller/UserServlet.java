package cn.edu.jxau.controller;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import cn.edu.jxau.common.User;
import cn.edu.jxau.exception.ServiceException;
import cn.edu.jxau.service.UserService;
import cn.edu.jxau.service.impl.UserServiceImpl;
import cn.edu.jxau.utils.AjaxResultHander;
import cn.edu.jxau.utils.BaseServlet;
import cn.edu.jxau.utils.CommonUtils;
import cn.edu.jxau.utils.JsonUtils;
import cn.edu.jxau.utils.postUtil;

public class UserServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService = new UserServiceImpl();
	private static final String[] trueAnsewr = { "0", "023", "01", "01234", "01234", "012", "0123", "0123", "01234",
			"012345", "1", "0", "0", "1", "0", "1", "0123", "012", "012", "012345", "012", "01234", "0", "0", "1", "02",
			"0123", "12", "2", "0123", "012", "01", "012", "0123", "012", "0123", "023", "023", "02", "012", "03",
			"013", "0123", "012", "023", "0123", "012" };
	private static final String trueAnsewr1 = "A,ACD,AB,ABCDE,ABCDE,ABC,ABCD,ABCD,ABCDE,ABCDEF,B,A,A,B,A,B,ABCD,ABC,ABC,ABCDEF,ABC,ABCDE,A,A,B,AC,ABCD,BC,C,ABCD,ABC,AB,ABC,ABCD,ABC,ABCD,ACD,ACD,AC,ABC,AD,ABD,ABCD,ABC,ABD,ABCD,ABC";
	private static final String TOKEN = "LD87er2sjsxk^ds";
	private static final String SESSION_USER = "session_user";
	/*
	 * 输入校验 1，创建一个Map,用来封装错误信息，其中key为表单字段名称，值为错误信息
	 */
	private Map<String, String> errors = new HashMap<String, String>();

	@SuppressWarnings("unused")
	public String login(HttpServletRequest req, HttpServletResponse resp) {
		// 封装表单数据到form中
		User form = CommonUtils.toBean(req.getParameterMap(), User.class);
		// 清空Map集合中的错误信息
		errors.clear();

		// 学号验证
		Integer stuNumber = form.getStudentNumber();

		if (stuNumber != null && 8 != stuNumber.toString().length()) {
			errors.put("stuNumber", "用户名错误！");
		}

		// 密码验证
		String password = form.getPassword();
		if (password == null || password.trim().isEmpty()) {
			errors.put("password", "密码不能为空！");
		} else if (password.length() != 6) {
			errors.put("password", "密码错误！");
		}

		// 判断是否存在错误信息
		if (errors.size() > 0) {
			// 1，保存错误信息
			// 2，保存表单数据
			// 3，转发到login.jsp
			req.setAttribute("errors", errors);
			req.setAttribute("form", form);
			return "f:/admin.jsp";
		}

		try {
			// 验证用户名密码是否正确
			User stu = userService.queryAdmin(form);
			if(stu.getType() != 1) {
				req.setAttribute("msg", "用户名或者密码错误！");
				return "f:/admin.jsp";
			}
			// 设置用户session
			req.setAttribute("admin", stu);
			// 使用request对象的getSession()获取session，如果session不存在则创建一个
			HttpSession session = req.getSession();
			// 将数据存储到session中
			session.setAttribute("session_admin", stu);
		} catch (ServiceException e) {
			req.setAttribute("msg", e.getMessage());
			req.setAttribute("form", form);
			return "f:/admin.jsp";
		}
		return "f:/WEB-INF/pages/checkManage.jsp";
	}

	/**
	 * 学生登录 2017年11月24日 zclong
	 * 
	 * @param req
	 * @param resp
	 * @return
	 * @throws IOException
	 * @throws NoSuchAlgorithmException
	 */
	public String userLogin(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, NoSuchAlgorithmException {
		// 封装表单数据到form中
		User form = CommonUtils.toBean(req.getParameterMap(), User.class);
		if (form.getStudentNumber() == null || form.getPassword() == null) {
			req.setAttribute("errorUser", "信息不能为空！");
			return "f:/login.jsp";
		} else {
			String code = form.getStudentNumber().toString();
			String passw = form.getPassword();
			boolean result = code.matches("[0-9]+");
			if (code.length() != 8 || result == false || passw.length() != 6) {
				req.setAttribute("errorUser", "用户名或密码错误!!");
				return "f:/login.jsp";
			}
		}

		try {
			// 使用request对象的getSession()获取session，如果session不存在则创建一个
			HttpSession session = req.getSession();
			// 先在本地数据库查找是否有用户信息，没有则去教务系统查找
			User user = userService.queryUser(form);
			if (null == user) {
				// 向教务系统发送登录请求
				Map<String, String> parameters = new HashMap<String, String>();
				String data = new Date().getTime() + "";
				String token = postUtil.EncoderByMd5(data + TOKEN);
				parameters.put("UserCode", form.getStudentNumber() + "");
				parameters.put("PassWord", form.getPassword());
				parameters.put("Time", data + "");
				parameters.put("Token", token);
				String url = "http://jwzs.jxau.edu.cn/AuthorManage/Login";
				// 发送请求
				// {"Success":true,"Message":"登录成功！",
				// "Data":{"UserCode":"20151973","UserClass":"软件工程1503","UserName":"张城龙","Department":"软件学院"}}
				// {"Success":false,"Message":"用户名或密码错误！"}
				String result = postUtil.sendPost(url, parameters);
				JSONObject objResult = JSON.parseObject(result);
				String success = (String) objResult.get("Success").toString();
				String message = (String) objResult.get("Message").toString();
				if ("false".equals(success)) {
					req.setAttribute("errorUser", message);
					return "f:/login.jsp";
				}

				// 获取用户信息
				JSONObject objData = JSON.parseObject(objResult.get("Data").toString());
				String classes = objData.getString("UserClass");
				String academy = objData.getString("Department");
				String userName = objData.getString("UserName");
				form.setClasses(classes);
				form.setAcademy(academy);
				form.setUserName(userName);
				form.setFrequency(0);

				// 用户首次登录，将用户信息插入数据库
				userService.userLogin(form);
				// 将数据存储到session中
				session.setAttribute(SESSION_USER, form);
				return "f:/WEB-INF/pages/index.jsp";
			} else if (!user.getPassword().equals(form.getPassword())) {
				req.setAttribute("errorUser", "用户名或密码错误！");
				return "f:/login.jsp";
			}

			// 将数据存储到session中
			session.setAttribute(SESSION_USER, user);
			return "f:/WEB-INF/pages/index.jsp";
		} catch (ServiceException e) {
			req.setAttribute("errorUser", e.getMessage());
			return "f:/login.jsp";
		}
	}

	/**
	 * 提交测试 2017年11月21日 zclong
	 * 
	 * @param req
	 * @param resp
	 */
	@SuppressWarnings("unused")
	public String submit(HttpServletRequest req, HttpServletResponse resp) {
		User form = (User) req.getSession().getAttribute(SESSION_USER);
		if (null == form) {
			req.setAttribute("errorUser", "请先登录!");
			return "f:/login.jsp";
		}

		// 答题次数
		int frequency = form.getFrequency();
		if (2 <= frequency) {
			req.setAttribute("quizError", "您已经答过题了");
			return "f:/quiz.jsp";
		}
		// 获取用户的答案
		String userAnswers = req.getParameter("userAnswers");
		if (null == userAnswers) {
			req.setAttribute("quizError", "请重新测试！");
			return "f:/quiz.jsp";
		}

		// 记录正确的个数
		float count = 0;
		HashMap<String, String> answer = new HashMap<String, String>();

		// 将答案变成数组
		String[] arrAnswers = userAnswers.split(",");
		if (trueAnsewr.length != arrAnswers.length) {
			req.setAttribute("quizError", "请重新测试！");
			return "f:/quiz.jsp";
		} else {
			for (int i = 0; i < arrAnswers.length; i++) {
				if (trueAnsewr[i].equals(arrAnswers[i])) {
					count++;
					answer.put(i + "", "true");
				} else {
					answer.put(i + "", "false");
				}
			}
		}
		// 计算分数
		float grade = (count / trueAnsewr.length) * 100;
		if (grade < 80) {
			form.setStatus(0);
		} else {
			form.setStatus(1);
		}
		form.setGrade((int) grade);
		// 答题次数+1
		form.setFrequency(++frequency);
		try {
			userService.submit(form);
			req.getSession().setAttribute(SESSION_USER, form);
			req.setAttribute("answer", answer);
			req.setAttribute("trueAnsewr", trueAnsewr1);
			return "f:/WEB-INF/pages/result.jsp";
		} catch (ServiceException e) {
			e.printStackTrace();
			return "f:/quiz.jsp";
		}
	}

	/**
	 * 教师查询所有学生的测评成绩 2017年11月23日 zclong
	 * 
	 * @param req
	 * @param resp
	 * @throws IOException
	 */
	public void queryUserByAcademy(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// 清空Map集合中的错误信息
		errors.clear();
		// 获取session，即登录后的用户信息
		User stu = (User) req.getSession(false).getAttribute("session_admin");
		if (null == stu) {
			errors.put("quizError", "请先登录");
		}

		String academy = req.getParameter("academy");
		List<User> listUser = userService.queryUserByAcademy(academy);
		if (0 == listUser.size()) {
			errors.put("error", "查询到0条数据");
		}
		Map<String, Object> list = new HashMap<String, Object>();
		list.put("data", listUser);
		new AjaxResultHander(req, resp).doAjax(list);
	}

	/**
	 * 注销 2017年11月23日 zclong
	 * 
	 * @param req
	 * @param resp
	 * @return
	 */
	public String quit(HttpServletRequest req, HttpServletResponse resp) {

		User form = (User) req.getSession().getAttribute(SESSION_USER);
		User admin = (User) req.getSession().getAttribute("session_admin");
		if (null != form) {
			req.getSession().removeAttribute(SESSION_USER);
			// 彻底销毁session
			req.getSession().invalidate();
			return "f:/login.jsp";
		} else if (null != admin) {
			req.getSession().removeAttribute("session_admin");
			// 彻底销毁session
			req.getSession().invalidate();
			return "f:/admin.jsp";
		}
		return "f:/login.jsp";
	}

}
