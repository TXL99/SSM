package com.xkit.textssm.dao;

import java.util.List;

import com.xkit.textssm.entity.Easybuy_user_address;

public interface Easybuy_user_addressDAO {
	public int add(Easybuy_user_address eua);
	public List<Easybuy_user_address> selectTime();
}
