package com.xkit.textssm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sun.org.glassfish.gmbal.ParameterNames;
import com.xkit.textssm.entity.Easybuy_user;

//�û������dao�ӿ�
public interface Easybuy_userDAO {
	public Easybuy_user get(Easybuy_user user);
	public int insert(Easybuy_user user);
	public int getCount(String zh);
	
	public List<Easybuy_user> selectName();
	
	/**
	 * ��ҳ��ѯ�����û�
	 */
	public List<Easybuy_user> selectYh(@Param("index") int index,@Param("pageSize") int pageSize,@Param("user") Easybuy_user user);
	/**
	 * ͳ���û�
	 * @param user
	 * @return
	 */
	public int count(Easybuy_user user);
	/**
	 * ɾ���û�
	 * @return
	 */
	public int delectUser(int id);

	/**
	 * ��id��ѯҪ�޸ĵ�����
	 * @param id
	 * @return
	 */
	public List<Easybuy_user> selectId(int id);

	/**
	 * �޸��û�
	 * @param user
	 * @return
	 */
	public int updateUser(Easybuy_user user);

}
