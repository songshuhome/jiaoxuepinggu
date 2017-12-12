package cn.edu.jxau.dao.impl;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.edu.jxau.common.User;
import cn.edu.jxau.dao.UserDao;
import cn.edu.jxau.utils.TxQueryRunner;

public class UserDaoImpl implements UserDao{

	QueryRunner qr = new TxQueryRunner();
	// 查询不要用*，这样会降低效率
	@Override
	public User queryUser(User user) {
		try {
			String sql = "select * from user where studentNumber = ?";
			return qr.query(sql, new BeanHandler<User>(User.class), user.getStudentNumber());
		} catch (SQLException e) {
            throw new RuntimeException(e);
        }
	}
	
	@Override
	public User queryAdmin(User user) {
		try {
			String sql = "select * from user where studentNumber = ? and password=?";
			return qr.query(sql, new BeanHandler<User>(User.class), user.getStudentNumber(), user.getPassword());
		} catch (SQLException e) {
            throw new RuntimeException(e);
        }
	}
	
	@Override
	public int queryGrade(int userId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int submit(User user) {
		try {//update user set grade=?,status=?,frequency=? where userId=?
			String sql = "update user set grade=?,status=?,frequency=? where studentNumber=?";
			Object[] param = {user.getGrade(), user.getStatus(), user.getFrequency(), user.getStudentNumber()};
            int flag = qr.update(sql, param);
            return flag;
		} catch (SQLException e) {
            throw new RuntimeException(e);
        }
	}

	@Override
	public List<User> queryUserByAcademy(String academy) {
		try {
			String sql = "select * from user where academy = ?";
			return qr.query(sql, new BeanListHandler<User>(User.class), academy);
		} catch (SQLException e) {
            throw new RuntimeException(e);
        }
	}

	/**
	 * 学生登录
	 */
	@Override
	public int userLogin(User user) {
		try {
			String sql = "INSERT INTO user (`userName`, `password`, `classes`, `studentNumber`, `academy`) VALUES (?, ?, ?, ?, ?)";
			Object[] param = {user.getUserName(), user.getPassword(), user.getClasses(), user.getStudentNumber(), user.getAcademy()};
            int flag = qr.update(sql, param);
            return flag;
		} catch (SQLException e) {
            throw new RuntimeException(e);
        }
	}
}
