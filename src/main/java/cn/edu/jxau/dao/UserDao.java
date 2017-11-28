package cn.edu.jxau.dao;

import java.util.List;

import cn.edu.jxau.common.User;

public interface UserDao {

	/**
	 * 学生登录
	 * 2017年11月24日
	 * zclong
	 * @param user
	 * @return
	 */
	public int userLogin(User user);
	
	/**
	 * 根据学号，密码查询用户
	 * 2017年11月20日
	 * zclong
	 * @param user
	 * @return
	 */
	public User queryUser(User user);
	
	public User queryAdmin(User user);
	
	/**
	 * 查询学生的分数
	 * 2017年11月20日
	 * zclong
	 * @return
	 */
	public int queryGrade(int userId);
	
	/**
	 * 保存测试信息
	 * 2017年11月21日
	 * zclong
	 * @param user
	 */
	public int submit(User user);
	
	/**
	 * 根据院系查询所有的学生测评信息
	 * 2017年11月22日
	 * zclong
	 * @param academy
	 * @return
	 */
	public List<User> queryUserByAcademy(String academy);
	
}
