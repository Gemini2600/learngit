package com.neusoft.dao;

import java.util.List;

import com.neusoft.entity.Consumer;
import com.neusoft.entity.PageModel;

public interface ConsumerDao {
	//查询全部会员
	public List<Consumer> getConsumerList();
	//添加买家
	public boolean addConsumer(Consumer consumer) throws DaoException;
	//删除买家
	public boolean deleteConsumer(Integer id) throws DaoException;
	//修改买家
	public boolean updateConsumer(Consumer consumer) throws DaoException;
	//查询买家
	public Consumer getConsumer(Integer id) throws DaoException;
	//分页
	public PageModel<Consumer> getPageModel(int pageNo,int pageSize) throws DaoException;
}
