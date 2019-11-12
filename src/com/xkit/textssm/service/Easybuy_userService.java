package com.xkit.textssm.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xkit.textssm.entity.Easybuy_user;

//�û������service�ӿ�
public interface Easybuy_userService {
	public Easybuy_user UserLogin(Easybuy_user user) throws Exception;
	public boolean UserRegist(Easybuy_user user) throws Exception;
	public boolean checkLoginUsed(String zh) throws Exception;
	
	/**
	 * ��ѯ�û�
	 * @return
	 */
	public List<Easybuy_user> selectName();
	
	/**
	 * ��ҳ��ѯ�����û�
	 */
	public List<Easybuy_user> selectYh(int index,int pageSize,Easybuy_user user);
	/**
	 * ͳ���û�
	 * @param user
	 * @return
	 */
	public int count(Easybuy_user user);
	
	/**
	 * ɾ���û�
	 * @param id
	 * @return
	 */
	public boolean UserDelect(int id);
	/**
	 * ��id��ѯҪ�޸ĵ�����
	 * @param id
	 * @return
	 */
	public List<Easybuy_user> selectUpdate(int id);

	/**
	 * �޸��û�
	 * @return
	 */
	public boolean updateUser(Easybuy_user user);
	
}
