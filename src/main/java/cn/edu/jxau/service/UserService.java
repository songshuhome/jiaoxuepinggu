package cn.edu.jxau.service;

import java.util.List;

import cn.edu.jxau.common.User;
import cn.edu.jxau.exception.ServiceException;

public interface UserService {

	public User queryUser(User user) throws ServiceException;
	
	public User queryAdmin(User user) throws ServiceException;
	
	public void submit(User user) throws ServiceException;
	
	/**
	 * 根据院系查询所有的学生测评信息
	 * 2017年11月22日
	 * zclong
	 * @param academy
	 * @return
	 */
	public List<User> queryUserByAcademy(String academy);
	
	public void userLogin(User user) throws ServiceException;
}
