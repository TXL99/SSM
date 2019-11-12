package com.xkit.textssm.dao;

import com.xkit.textssm.entity.Easybuy_news;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * ClassName:Easybuy_newsDao
 * Package:com.xkit.textssm.dao
 * Description:
 *
 * @Date:2019/11/11 21:19
 * @Author:TXL@qq.com
 */
public interface Easybuy_newsDao {
    /**
     * ͳ������
     * @param news
     * @return
     */
    public int count(Easybuy_news news);
    /**
     * ��ҳ��ѯ��������
     */
    public List<Easybuy_news> selectXW(@Param("index") int index, @Param("pageSize") int pageSize, @Param("news") Easybuy_news news);
}
