package com.xkit.textssm.entity;

/**
 * ClassName:Easybuy_news
 * Package:com.xkit.textssm.entity
 * Description:
 * ����
 * @Date:2019/11/11 21:04
 * @Author:TXL@qq.com
 */
public class Easybuy_news {
    private Integer id;
    private String title;//����
    private String content;//����
    private String createTime;//����ʱ��

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
