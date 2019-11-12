package com.xkit.textssm.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件上传
 * @author asus
 *
 */
@Controller
public class FileUploadController {
	
	@RequestMapping("/fileUpload.action")
     public String handleFormUpload(String name,@RequestParam("uploadfile") List<MultipartFile> uploadfile,HttpServletRequest req,Model m){
		 //判断文件是否为空
		if(!uploadfile.isEmpty() && uploadfile.size()>0){
		//循环输出上传的文件
		for (MultipartFile file : uploadfile) {
			//获取上传文件的原始名称
			String filename=file.getOriginalFilename();
			//设置上传文件的保存地址目录
			String dirPath=req.getSession().getServletContext().getRealPath("filepath/");
			File filePath=new File(dirPath,filename);
			//如果保存文件的地址不存在，就先创建目录
			if(!filePath.exists()){
				filePath.mkdirs();
			}
			
			try {
				file.transferTo(filePath);//文件上传
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		m.addAttribute("ts", "文件上传成功!!!");
		m.addAttribute("tss", name);
		return "tips";
		}else{
			m.addAttribute("ts", "文件上传失败!!!");
			return "tips";
		}
    	 
     }
	
	   @RequestMapping("/filepath.action")
	    public String initAddAddress(){
	    	return "WEB-INF/pages/fileUpload";
	    }
	
}
