package com.xkit.textssm.tool;

import java.util.List;

import com.xkit.textssm.entity.Easybuy_user;

public class PageBean {
     private int index;//��ǰ�±�
     private int pageSize;//ҳ������
     private int countPage;//��ҳ��
     private  List lists;

	public List getLists() {
		return lists;
	}
	public void setLists(List lists) {
		this.lists = lists;
	}

	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getCountPage() {
		return countPage;
	}
	public void setCountPage(int countPage) {
		this.countPage = countPage;
	}
     
     
     
}
