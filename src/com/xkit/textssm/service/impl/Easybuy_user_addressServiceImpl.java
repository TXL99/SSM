package com.xkit.textssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xkit.textssm.dao.Easybuy_user_addressDAO;
import com.xkit.textssm.entity.Easybuy_user;
import com.xkit.textssm.entity.Easybuy_user_address;
import com.xkit.textssm.service.Easybuy_user_addressService;
@Service
public class Easybuy_user_addressServiceImpl implements Easybuy_user_addressService {
    
	@Autowired
	private Easybuy_user_addressDAO eud;
	
	public List<Easybuy_user_address> selectTime() {
		return eud.selectTime();
	}

	public boolean add(Easybuy_user_address eua) {
		int eu= eud.add(eua);
		if(eu==1){
			return true;
		}else{
		return false;
		}
	}

	public Easybuy_user_addressDAO getEud() {
		return eud;
	}

	public void setEud(Easybuy_user_addressDAO eud) {
		this.eud = eud;
	}


	

}
