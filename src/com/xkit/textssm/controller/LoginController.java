package com.xkit.textssm.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.xkit.textssm.entity.Easybuy_user;
import com.xkit.textssm.service.Easybuy_userService;
import com.xkit.textssm.validator.AdminLogin;
import com.xkit.textssm.validator.AdminRegist;

@Controller
public class LoginController {
	@Autowired
	private Easybuy_userService eus;
	
	@RequestMapping("/user/{userName}")
	public String user(@PathVariable("userName") String userName,Model mo){
		mo.addAttribute(userName);
		return "/WEB-INF/pages/manage/user";
	}
	
	@RequestMapping("/login.action")
	  public String login(@Validated(value={AdminLogin.class}) Easybuy_user user,BindingResult r,Model mo,HttpSession session) throws Exception{
	  if(r.hasFieldErrors()){
		  List<ObjectError> mes=r.getAllErrors();
		  String mes1="";
		  for (ObjectError objectError : mes) {
			 mes1=objectError.getDefaultMessage();
		}
		  mo.addAttribute("mes", mes1);
		  return "tips";
	  }
		  Easybuy_user user2 = eus.UserLogin(user);
		if(user2!=null){
			mo.addAttribute("ts", "��¼�ɹ�!!!");
			mo.addAttribute("userName", user.getLoginName());
			session.setAttribute("userSession",user);
			return "WEB-INF/pages/manage/main";
		}else{
			mo.addAttribute("ts", "��¼ʧ��!!!");
		  return "login";
		}
	  }
     //跳转到主界面
	@RequestMapping("/main")
	public String user(){

		return "WEB-INF/pages/manage/main";
	}
	
	@RequestMapping("/regist.action")
	protected String reg(@Validated(value={AdminRegist.class}) Easybuy_user user,BindingResult r,Model mo) throws Exception {
		     
		    if(r.hasFieldErrors()){
		    	return "regist";
		    }else{
		    
					boolean isok=eus.UserRegist(user);
					  if(isok){
						  mo.addAttribute("ts","ע��ɹ�");
						  return "login";
					  }else{
						  mo.addAttribute("ts","ע��ʧ��");
						  return "regist";
					  }
		   
		    	
		    }
	}
	
	
/*	@RequestMapping("/regist.action")
	protected ModelAndView reg(HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		
		Easybuy_user user=new Easybuy_user();
		user.setEmail(req.getParameter("yx"));
		user.setIdentityCode(req.getParameter("sfz"));
		user.setLoginName(req.getParameter("yhm"));
		user.setMobile(req.getParameter("sj"));
		user.setPassword(req.getParameter("mm"));
		user.setSex(Integer.parseInt(req.getParameter("xb")));
		user.setType(0);
		String xm=new String(req.getParameter("xm").getBytes("iso-8859-1"),"utf-8");
		user.setUserName(xm);
		
			boolean isok=eus.UserRegist(user);
			
			ModelAndView mav=new ModelAndView();
			if(isok){
				mav.addObject("ts", "ע��ɹ�������");
				mav.setViewName("tips");
			}else{
				mav.addObject("ts", "ע��ʧ�ܣ�����");
				mav.setViewName("regist");
			}
	
		return mav;
	}*/
	
	/*@RequestMapping(value="/zhajax.action",produces={"application/json;charset=UTF-8","text/plain;charset=UTF-8"})*/
	@RequestMapping("/zhajax.action")
	public @ResponseBody String zhajaxs(String zh) throws Exception{
	     boolean bool= eus.checkLoginUsed(zh);
	     String rs="{\"msg\":\"�û���ռ��\"}";
	     if(bool){
	    	 rs="{\"msg\":\"�û�����ʹ��\"}";
	     }
		return rs;
	}
	
	/*@RequestMapping(value="/showUserList.action",produces={"application/json;charset=UTF-8","text/plain;charset=UTF-8"})*/
/*	@RequestMapping("/showUserList.action")
	public @ResponseBody String showUserList(){
		List<Easybuy_user> list=eus.selectName();
		String rs=JSON.toJSONString(list);
		return rs;
	}*/
	
	//����Ͱ��ṩ����Ϣת����
	@RequestMapping("/showUserList.action")
	public @ResponseBody List<Easybuy_user> showUserList(){
		List<Easybuy_user> list=eus.selectName();
		return list;
	}
	
}
