package cn.edu.jxau.service.impl;

import java.util.List;
import java.util.logging.Logger;

import cn.edu.jxau.common.User;
import cn.edu.jxau.dao.UserDao;
import cn.edu.jxau.dao.impl.UserDaoImpl;
import cn.edu.jxau.exception.ServiceException;
import cn.edu.jxau.service.UserService;

public class UserServiceImpl implements UserService {

	private UserDao userDao = new UserDaoImpl();
	private Logger logger = Logger.getLogger("jaxu");

	public User queryUser(User form) throws ServiceException {
		User user = userDao.queryUser(form);
		return user;
	}
	

	public User queryAdmin(User form) throws ServiceException {
		User user = userDao.queryAdmin(form);
		if (user == null) {
			throw new ServiceException("用户名，密码错误!");
		}
		return user;
	}

	/**
	 * 用户提交测试，保存测试结果
	 */

	public void submit(User user) throws ServiceException {
		int flag = userDao.submit(user);
		if(flag == 0) {
			logger.warning(user.toString()+": "+"提交失败!");
			throw new ServiceException("提交失败!");
		}
	}


	public List<User> queryUserByAcademy(String academy) {
		List<User> listUser = userDao.queryUserByAcademy(academy);
		return listUser;
	}


	public void userLogin(User user) throws ServiceException {
		int flag = userDao.userLogin(user);
		if(flag != 1) {
			logger.warning(user.toString()+": "+"登录失败!");
			throw new ServiceException("登录失败!");
		}
	}
}
