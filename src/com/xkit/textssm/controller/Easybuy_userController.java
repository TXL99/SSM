package com.xkit.textssm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xkit.textssm.entity.Easybuy_user;
import com.xkit.textssm.service.Easybuy_userService;
import com.xkit.textssm.tool.PageBean;
import com.xkit.textssm.validator.AddUser;

@Controller
public class Easybuy_userController {
	@Autowired
    private Easybuy_userService eus;
	@RequestMapping("/list")
	public String UserList(Easybuy_user user,HttpServletRequest request,Model mo){
		   int countUser= eus.count(user);//������
		   int index=1;//��ǰ�±�
		   int pageSize=5;//ҳ������
		   int countPage=countUser%pageSize==0?countUser/pageSize:countUser/pageSize+1;
		   
		    if(request.getParameter("page")!=null&&!"".equals(request.getParameter("page"))){
		    	index=Integer.parseInt(request.getParameter("page"));
		    }
		   if(index<1||index>countPage){
			   index=1;
		   }
		   
		   List<Easybuy_user> list=eus.selectYh((index-1)*pageSize, pageSize, user);
		   PageBean pb=new PageBean();
		   pb.setIndex(index);
		   pb.setPageSize(pageSize);
		   pb.setCountPage(countPage);
		   pb.setLists(list);
		   
		   mo.addAttribute("pagebean", pb);
		return "/WEB-INF/pages/manage/list";
	}
	
	@RequestMapping("/UserDelete")
	public String UserDel(int id,Model mo){
		boolean bo= eus.UserDelect(id);
		if(bo){
			mo.addAttribute("ts", "ɾ���ɹ�");
			return "forward:/list";
		}else{
			mo.addAttribute("ts", "ɾ��ʧ��");
			return "forward:/list";
		}
	}

	//�û�����ҳ��
	@RequestMapping("/userAdd")
	public String addUser(){
		return "/WEB-INF/pages/manage/userAdd";
	}
	//�û�����
	@RequestMapping("/UserAdds")
	public String addUser2(@Validated(value={AddUser.class}) Easybuy_user user, BindingResult r, Model mo) throws Exception{
		if(r.hasFieldErrors()){
			return "regist";
		}else{
			boolean isok=eus.UserRegist(user);
			if(isok){
				mo.addAttribute("ts","�����ɹ�");
				return "forward:/list ";
			}else{
				mo.addAttribute("ts","����ʧ��");
				return "/WEB-INF/pages/manage/userAdd";
			}
		}

	}
	//�û��޸�
	@RequestMapping("/UserUpdate")
	public String UserUpdate(int id,Model mo){
		List<Easybuy_user> list=eus.selectUpdate(id);
		mo.addAttribute("list", list);
		return "WEB-INF/pages/manage/userUpdate";

	}

	//�û��޸��ύ
	@RequestMapping("/UserUpdate2")
	public String updateUser(Easybuy_user user,Model mo){
             boolean bool= eus.updateUser(user);
             if (bool){
             	mo.addAttribute("ts","�޸ĳɹ���");
             	return "/WEB-INF/pages/manage/list";
			 }else{
             	mo.addAttribute("ts","�޸�ʧ��!!!");
				 return "WEB-INF/pages/manage/userUpdate";
			 }
	}

	
}
