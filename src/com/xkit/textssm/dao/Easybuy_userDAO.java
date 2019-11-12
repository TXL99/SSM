package com.xkit.textssm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sun.org.glassfish.gmbal.ParameterNames;
import com.xkit.textssm.entity.Easybuy_user;

//用户表操作dao接口
public interface Easybuy_userDAO {
	public Easybuy_user get(Easybuy_user user);
	public int insert(Easybuy_user user);
	public int getCount(String zh);
	
	public List<Easybuy_user> selectName();
	
	/**
	 * 分页查询所有用户
	 */
	public List<Easybuy_user> selectYh(@Param("index") int index,@Param("pageSize") int pageSize,@Param("user") Easybuy_user user);
	/**
	 * 统计用户
	 * @param user
	 * @return
	 */
	public int count(Easybuy_user user);
	/**
	 * 删除用户
	 * @return
	 */
	public int delectUser(int id);

	/**
	 * 以id查询要修改的数据
	 * @param id
	 * @return
	 */
	public List<Easybuy_user> selectId(int id);

	/**
	 * 修改用户
	 * @param user
	 * @return
	 */
	public int updateUser(Easybuy_user user);

}
