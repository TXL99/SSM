package com.xkit.textssm.controller;

import com.xkit.textssm.entity.Easybuy_news;
import com.xkit.textssm.service.Easybuy_newsService;
import com.xkit.textssm.tool.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * ClassName:Easybuy_newsController
 * Package:com.xkit.textssm.controller
 * Description:
 *
 * @Date:2019/11/11 21:59
 * @Author:TXL@qq.com
 */
@Controller
public class Easybuy_newsController {
    @Autowired
    private Easybuy_newsService ens;
    @RequestMapping("/Easybuy_newsList")
    public String UserList(Easybuy_news news, HttpServletRequest request, Model mo){
        int countNews= ens.count(news);//总数量
        int index=1;//当前下标
        int pageSize=3;//页面容量
        int countPage=countNews%pageSize==0?countNews/pageSize:countNews/pageSize+1;

        if(request.getParameter("page")!=null&&!"".equals(request.getParameter("page"))){
            index=Integer.parseInt(request.getParameter("page"));
        }
        if(index<1||index>countPage){
            index=1;
        }

        List<Easybuy_news> list=ens.selectXW((index-1)*pageSize, pageSize, news);
        PageBean pb=new PageBean();
        pb.setIndex(index);
        pb.setPageSize(pageSize);
        pb.setCountPage(countPage);
        pb.setLists(list);

        mo.addAttribute("pagebean", pb);
        return "WEB-INF/pages/manage/newsList";
    }

}
