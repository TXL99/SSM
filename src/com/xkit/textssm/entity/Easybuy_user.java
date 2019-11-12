package com.xkit.textssm.entity;

import org.hibernate.validator.constraints.NotEmpty;

import com.xkit.textssm.validator.AddUser;
import com.xkit.textssm.validator.AdminLogin;
import com.xkit.textssm.validator.AdminRegist;

public class Easybuy_user {
	private Integer id;
	@NotEmpty(groups={AdminLogin.class,AdminRegist.class,AddUser.class},message="�˺Ų���Ϊ��")
	private String loginName;
	@NotEmpty(groups={AdminRegist.class,AddUser.class},message="��������Ϊ��")
	private String userName;
	@NotEmpty(groups={AdminLogin.class,AdminRegist.class,AddUser.class},message="���벻��Ϊ��")
	private String password;
	@NotEmpty(groups={AdminRegist.class},message="ȷ�����벻��Ϊ��")
	private String password2;

	private Integer sex;
	@NotEmpty(groups={AdminRegist.class,AddUser.class},message="���֤����Ϊ��")
	private String identityCode;
	@NotEmpty(groups={AdminRegist.class,AddUser.class},message="���䲻��Ϊ��")
	private String email;
	@NotEmpty(groups={AdminRegist.class,AddUser.class},message="�ֻ��Ų���Ϊ��")
	private String mobile;
	private Integer type;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
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
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public String getIdentityCode() {
		return identityCode;
	}
	public void setIdentityCode(String identityCode) {
		this.identityCode = identityCode;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getPassword2() {
		return password2;
	}
	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	
	
	
	
}
