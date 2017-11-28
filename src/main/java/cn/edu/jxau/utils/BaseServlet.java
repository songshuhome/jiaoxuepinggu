package cn.edu.jxau.utils;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 定义抽象类BaseServlet(为了被子类继承，为子类提供了同一的方法入口),继承HttpServlet,重写HttpServlet的service方法，
 * ->用来实现Servlet中可以有多个请求处理方法！
 * Servlet处理请求原理：HttpServlet由service方法来默认调用doGet方法或者doPost方法，只能处理一个请求
 * 客户端发送请求时，必须多给出一个参数，用来说明要调用的方法 请求处理方法的签名必须与service相同，即返回值和参数，以及声明的异常都相同！
 * 客户端必须传递名为method的参数！ BaseServlet
 * 
 * @author zclong 2017年7月27日
 */
public abstract class BaseServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 通过反射实现，先得到该类，再获取该类的方法，进而执行对应的方法，这个便可实现一个Servlet中可以有多个请求方法

		// 1，先得到客户端传递过来的方法名
		String methodName = request.getParameter("method");

		// 2，对方法名进行判断，判断是否为空,若为空，抛出异常，提示不存在该方法
		if (methodName == null || methodName.trim().isEmpty()) {
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			throw new RuntimeException("您没有传递method方法，无法确定您要调用的方法！");		}

		// 3，进行反射得到要调用该方法的类
		Class clazz = this.getClass();

		Method method;
		try {
			// 4,得到该类下对应的方法，参数为要操作的方法名和参数列表（避免方法的重载）
			method = clazz.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
		} catch (Exception e) {
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			throw new RuntimeException("您要调用的方法：" + methodName + "(HttpServletRequest,HttpServletResponse)，它不存在！");
		}

		try {
			// 执行该方法，利用invoke()方法,第一个参数为该方法所在类的实例，第二个为该方法传递的的参数值
			String result = (String) method.invoke(this, request, response);

			/*
			 * 获取请求处理方法执行后返回的字符串，它表示转发或重定向的路径！ 帮它完成转发或重定向！
			 * 如果用户返回的是字符串为null，或为""，那么我们什么也不做！
			 */

			// 方法的返回的操作有转发和重定向两种，对这两种操作进行包装，使得操作更加简单
			// 先对返回值进行判断，若转发和重定向都不做，则返回return
			if (result == null || result.trim().isEmpty()) {
				return;
			}

			/*
			 * 查看返回的字符串中是否包含冒号，如果没有，表示转发 如果有，使用冒号分割字符串，得到前缀和后缀！
			 * 其中前缀如果是f，表示转发，如果是r表示重定向，后缀就是要转发或重定向的路径了！
			 */
			if (result.contains(":")) {

				// 获取冒号的位置，使用冒号分割字符串，得到前缀和后缀
				int index = result.indexOf(":");
				// 截取result字符串的第一个字母,冒号前的字符串
				String i = result.substring(0, index);// 截取出前缀，表示操作
				// 截取冒号后的所有字符
				String path = result.substring(index + 1);// 截取出后缀，表示路径

				// 判断是转发还是重定向,f代表转发，r代表重定向
				if ("f".equalsIgnoreCase(i)) {
					request.getRequestDispatcher(path).forward(request, response);
				} else if ("r".equalsIgnoreCase(i)) {
					response.sendRedirect(request.getContentType() + path);
				} else {
					request.getRequestDispatcher("/login.jsp").forward(request, response);
					throw new RuntimeException("你指定的操作：" + i + "，当前版本还不支持！");
				}
			} else {// 没有冒号，默认为转发！
				request.getRequestDispatcher(result).forward(request, response);
			}
		} catch (Exception e) {
			System.out.println("您调用的方法：" + methodName + ",　它内部抛出了异常！");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			throw new RuntimeException(e);
		}
	}
}
