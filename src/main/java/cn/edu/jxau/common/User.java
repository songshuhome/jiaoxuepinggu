package cn.edu.jxau.common;

import java.util.Date;

/**
 * 用户表
 * @author zclong
 * 2017年11月20日
 */
public class User {
	private Integer userId;

	//姓名
    private String userName;
    
    private String password;

    //院系
    private String academy;
    
    //班级
    private String classes;

    //学号
    private Integer studentNumber;

    //分数
    private Integer grade;

    //是否通过测试
    private Integer status;
    
    //答题次数
    private Integer frequency;
    
    //是否是管理员
    private Integer type;
    
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAcademy() {
		return academy;
	}

	public void setAcademy(String academy) {
		this.academy = academy;
	}

	public String getClasses() {
		return classes;
	}

	public void setClasses(String classes) {
		this.classes = classes;
	}

	public Integer getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(Integer studentNumber) {
		this.studentNumber = studentNumber;
	}

	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}


	public Integer getFrequency() {
		return frequency;
	}

	public void setFrequency(Integer frequency) {
		this.frequency = frequency;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", academy=" + academy
				+ ", classes=" + classes + ", studentNumber=" + studentNumber + ", grade=" + grade + ", status="
				+ status + ", frequency=" + frequency + ", type=" + type + "]";
	}

}
