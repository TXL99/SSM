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
 * �ļ��ϴ�
 * @author asus
 *
 */
@Controller
public class FileUploadController {
	
	@RequestMapping("/fileUpload.action")
     public String handleFormUpload(String name,@RequestParam("uploadfile") List<MultipartFile> uploadfile,HttpServletRequest req,Model m){
		 //�ж��ļ��Ƿ�Ϊ��
		if(!uploadfile.isEmpty() && uploadfile.size()>0){
		//ѭ������ϴ����ļ�
		for (MultipartFile file : uploadfile) {
			//��ȡ�ϴ��ļ���ԭʼ����
			String filename=file.getOriginalFilename();
			//�����ϴ��ļ��ı����ַĿ¼
			String dirPath=req.getSession().getServletContext().getRealPath("filepath/");
			File filePath=new File(dirPath,filename);
			//��������ļ��ĵ�ַ�����ڣ����ȴ���Ŀ¼
			if(!filePath.exists()){
				filePath.mkdirs();
			}
			
			try {
				file.transferTo(filePath);//�ļ��ϴ�
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		m.addAttribute("ts", "�ļ��ϴ��ɹ�!!!");
		m.addAttribute("tss", name);
		return "tips";
		}else{
			m.addAttribute("ts", "�ļ��ϴ�ʧ��!!!");
			return "tips";
		}
    	 
     }
	
	   @RequestMapping("/filepath.action")
	    public String initAddAddress(){
	    	return "WEB-INF/pages/fileUpload";
	    }
	
}
