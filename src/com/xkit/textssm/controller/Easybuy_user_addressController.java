package com.xkit.textssm.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xkit.textssm.entity.Easybuy_user;
import com.xkit.textssm.entity.Easybuy_user_address;
import com.xkit.textssm.service.Easybuy_userService;
import com.xkit.textssm.service.Easybuy_user_addressService;

@Controller
public class Easybuy_user_addressController {

    @Autowired
	private Easybuy_userService userService;
    @Autowired
	private Easybuy_user_addressService addressService;
    
   /* RESTful֧��*/
    @RequestMapping("/delectAddress/{abc}/{bcd}")
    public String delAddress(@PathVariable("abc") Integer id,@PathVariable("bcd") Integer userId){
    	System.out.println(id+":"+userId);
    	return "addressList";
    }
    
    
   /* ֻҪ���������ͻ������������ͬʱ�ѷ���ֵ������������*/
	/**
	 * ��ѯ�û�
	 * @return
	 */
    @ModelAttribute("userlist")
    public List<Easybuy_user> getUsers(){
    	List<Easybuy_user> list=userService.selectName();
    	return list;
    }
    
    @RequestMapping("/initAddAddress")
    public String initAddAddress(){
    	return "WEB-INF/pages/addAddress";
    }
    
    @RequestMapping("/addAddress.action")
    public String addAddress(Easybuy_user_address address,Model m){
    	
    	if(address.getIsDefault()==null){
    		address.setIsDefault(0);
    	}
    	boolean isok=addressService.add(address);
    	if(isok){
    		m.addAttribute("msg","������ַ�ɹ�");
    	}else{
    		m.addAttribute("msg", "������ַʧ��");
    	}
		return "WEB-INF/pages/addAddress";
    	
    }
    
  //����Ͱ��ṩ����Ϣת����
  	@RequestMapping("/showAddressList.action")
  	public @ResponseBody List<Easybuy_user_address> showUserList(){
  		List<Easybuy_user_address> list=addressService.selectTime();
  		return list;
  	}
    
    
    
    
    
}
