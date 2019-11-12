package com.xkit.textssm.service;

import java.util.List;

import com.xkit.textssm.entity.Easybuy_user;
import com.xkit.textssm.entity.Easybuy_user_address;

public interface Easybuy_user_addressService {
	
	public boolean add(Easybuy_user_address eua);
	public List<Easybuy_user_address> selectTime();

}
