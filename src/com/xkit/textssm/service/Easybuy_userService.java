package com.xkit.textssm.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xkit.textssm.entity.Easybuy_user;

//用户表操作service接口
public interface Easybuy_userService {
	public Easybuy_user UserLogin(Easybuy_user user) throws Exception;
	public boolean UserRegist(Easybuy_user user) throws Exception;
	public boolean checkLoginUsed(String zh) throws Exception;
	
	/**
	 * 查询用户
	 * @return
	 */
	public List<Easybuy_user> selectName();
	
	/**
	 * 分页查询所有用户
	 */
	public List<Easybuy_user> selectYh(int index,int pageSize,Easybuy_user user);
	/**
	 * 统计用户
	 * @param user
	 * @return
	 */
	public int count(Easybuy_user user);
	
	/**
	 * 删除用户
	 * @param id
	 * @return
	 */
	public boolean UserDelect(int id);
	/**
	 * 以id查询要修改的数据
	 * @param id
	 * @return
	 */
	public List<Easybuy_user> selectUpdate(int id);

	/**
	 * 修改用户
	 * @return
	 */
	public boolean updateUser(Easybuy_user user);
	
}
