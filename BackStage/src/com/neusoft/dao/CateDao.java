package com.neusoft.dao;

import java.util.List;

import com.neusoft.entity.Cate;
import com.neusoft.entity.PageModel;

public interface CateDao {
	
	/**
	 * 查询出一个Cate子类的集合List<Cate> childList  包括cid,cname,pid
	 */
	public List<Cate> checkCateList();
	/**
	 * 分页查询商品分类
	 */
	public PageModel<Cate> getPageModel(int pageNo,int pageSize);
	/**
	 * 添加商品分类
	 */
	public boolean addCate(Cate cate);
	/**
	 * 修改商品分类
	 */
	public boolean updateCate(Cate cate);
	/**
	 * 删除商品分类
	 */
	public void deleteCate(int cid);
	
	//删除方法
	public Cate rearchId(int cid);
	//删除主方法
	public void delRegion(Integer cid);
	//根据上级分类查询下级
	public List<Cate> getTop();
	//通过传的上级名字查出所有的下级的方法
	public List<Cate> getTopByname(String name);
	
}
