package com.xkit.textssm.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.xkit.textssm.dao.Easybuy_userDAO;
import com.xkit.textssm.entity.Easybuy_user;
import com.xkit.textssm.service.Easybuy_userService;

//�û������service�ӿ�ʵ����
@Service
public class Easybuy_userServiceImpl implements Easybuy_userService {
	@Autowired
	private Easybuy_userDAO dao;
	
	public Easybuy_user UserLogin(Easybuy_user user) throws Exception{
		Easybuy_user user2=dao.get(user);
		return user2;
	}
	//�û�ע�ᣬ����true����ע��ɹ���false����ע��ʧ��
	public boolean UserRegist(Easybuy_user user) throws Exception{
		int count=dao.insert(user);
		if (count==1) {
			return true;
		}
		return false;
	}
	
	public boolean checkLoginUsed(String zh) throws Exception{
		return dao.getCount(zh)==0;
	}
	
	public Easybuy_userDAO getDao() {
		return dao;
	}
	public void setDao(Easybuy_userDAO dao) {
		this.dao = dao;
	}
	/**
	 * ��ѯ�û�
	 * @return
	 */
	public List<Easybuy_user> selectName() {
		List<Easybuy_user> user=dao.selectName();
		return user;
	}
	
	/**
	 * ��ҳ��ѯ�����û�
	 */
	public List<Easybuy_user> selectYh(int index, int pageSize,
			Easybuy_user user) {
          
		return  dao.selectYh(index, pageSize, user);
	}
	/**
	 * ͳ���û�
	 * @param user
	 * @return
	 */
	public int count(Easybuy_user user) {

		return dao.count(user);
	}
	/**
	 * ɾ���û�
	 */
	public boolean UserDelect(int id) {
		   
		return dao.delectUser(id)>=1;
	}
	/**
	 * ��id��ѯҪ�޸ĵ�����
	 */
	public List<Easybuy_user> selectUpdate(int id) {
		List<Easybuy_user> list=dao.selectId(id);
		return list;
	}

	@Override
	public boolean updateUser(Easybuy_user user) {
		int result=dao.updateUser(user);
		return result>=1;
	}


}
