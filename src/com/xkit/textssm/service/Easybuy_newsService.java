package com.xkit.textssm.service;

import com.xkit.textssm.entity.Easybuy_news;

import java.util.List;

/**
 * ClassName:Easybuy_newsService
 * Package:com.xkit.textssm.service.impl
 * Description:
 *
 * @Date:2019/11/11 21:41
 * @Author:TXL@qq.com
 */
public interface Easybuy_newsService {
    /**
     * ��ҳ��ѯ�����û�
     */
    public List<Easybuy_news> selectXW(int index, int pageSize, Easybuy_news news);
    /**
     * ͳ���û�
     * @param news
     * @return
     */
    public int count(Easybuy_news news);
}
