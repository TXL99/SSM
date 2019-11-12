package com.xkit.textssm.service.impl;


import com.xkit.textssm.dao.Easybuy_newsDao;
import com.xkit.textssm.entity.Easybuy_news;
import com.xkit.textssm.service.Easybuy_newsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ClassName:Easybuy_newsServiceImpl
 * Package:com.xkit.textssm.service.impl
 * Description:
 *
 * @Date:2019/11/11 21:46
 * @Author:TXL@qq.com
 */
@Service
public class Easybuy_newsServiceImpl implements Easybuy_newsService {
    @Autowired
    private Easybuy_newsDao dao;

    /**
     *查询分布新闻
     * @param index
     * @param pageSize
     * @param news
     * @return
     */
    @Override
    public List<Easybuy_news> selectXW(int index, int pageSize, Easybuy_news news) {
        return dao.selectXW(index,pageSize,news);
    }

    /**
     * 统计新闻
     * @param news
     * @return
     */
    @Override
    public int count(Easybuy_news news) {
        return dao.count(news);
    }
}
