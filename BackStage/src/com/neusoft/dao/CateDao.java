package com.neusoft.dao;

import java.util.List;

import com.neusoft.entity.Cate;
import com.neusoft.entity.PageModel;

public interface CateDao {
	
	/**
	 * ��ѯ��һ��Cate����ļ���List<Cate> childList  ����cid,cname,pid
	 */
	public List<Cate> checkCateList();
	/**
	 * ��ҳ��ѯ��Ʒ����
	 */
	public PageModel<Cate> getPageModel(int pageNo,int pageSize);
	/**
	 * �����Ʒ����
	 */
	public boolean addCate(Cate cate);
	/**
	 * �޸���Ʒ����
	 */
	public boolean updateCate(Cate cate);
	/**
	 * ɾ����Ʒ����
	 */
	public void deleteCate(int cid);
	
	//ɾ������
	public Cate rearchId(int cid);
	//ɾ��������
	public void delRegion(Integer cid);
	//�����ϼ������ѯ�¼�
	public List<Cate> getTop();
	//ͨ�������ϼ����ֲ�����е��¼��ķ���
	public List<Cate> getTopByname(String name);
	
}
