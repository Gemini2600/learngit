package com.neusoft.services;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.dao.CateDao;
import com.neusoft.dao.DaoException;
import com.neusoft.dao.impl.CateDaoImpl;
import com.neusoft.entity.Cate;
import com.neusoft.entity.PageModel;
import com.neusoft.utils.DbUtil;

/**
 * 商品类别业务逻辑层
 * @author Doe
 *
 */
public class CateService {
	CateDao	cd=DbUtil.getInstance("cateDao", CateDaoImpl.class);
	
	
	
	//查询全部类别信息
	public List<Cate> checkCateList(){
		List<Cate> cateList=cd.checkCateList();
		if(cateList.size()>0){
			return cateList;
		}
		return null;
	}
	
	/**
	 *分页查询业务逻辑
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public void getCateLogin(HttpServletRequest request,HttpServletResponse response) throws DaoException,IOException,ServletException{
		
		String pageNo=request.getParameter("pageNo");
		String pageSize=request.getParameter("pageSize");
		
		int _pageNo=Integer.parseInt(pageNo);
		int _pageSize=Integer.parseInt(pageSize);

		PageModel<Cate> cates=getCateByPage(_pageNo, _pageSize);
		if(cates!=null){
			int totalPageSize=(cates.getTotalcount()%_pageSize==0 ? cates.getTotalcount()/_pageSize : cates.getTotalcount()/_pageSize+1);
			cates.setTotalPageSize(totalPageSize);
			cates.setPageNo(_pageNo);
		}
		request.setAttribute("cates", cates);
		try {
			request.getRequestDispatcher("productcate.jsp").forward(request, response);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	
	}
	//分页查询
	public PageModel<Cate> getCateByPage(int pageNo,int pageSize){
		return cd.getPageModel(pageNo, pageSize);
	}
	/**
	 * 显示reqType=2
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void disReqType2(ServletRequest request,ServletResponse response) throws ServletException, IOException{
		int _pageNo=1;
		int _pageSize=5;
		PageModel<Cate> cates=getCateByPage(_pageNo, _pageSize);
		if(cates!=null){
			int totalPageSize=(cates.getTotalcount()%_pageSize==0 ? cates.getTotalcount()/_pageSize : cates.getTotalcount()/_pageSize+1);
			cates.setTotalPageSize(totalPageSize);
			cates.setPageNo(_pageNo);
		}
		request.setAttribute("cates", cates);
		try {
			request.getRequestDispatcher("cServlet.do?reqType=2&pageNo=1&pageSize=5").forward(request, response);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 添加业务逻辑
	 */
	public void addCateLogin(HttpServletRequest request,HttpServletResponse response) throws DaoException, ServletException, IOException{
		/*String cname=request.getParameter("input_add");
		if(cname==null || cname.equals("")){
			throw new DaoException("分类名称不能为空");
		}
		String option_value=request.getParameter("add_select");
		if(option_value!=null&&!option_value.equals("")) {
			
			int pid=Integer.parseInt(option_value);
			Cate cate=new Cate(cname,pid);
			boolean flag=addCate(cate);
			List<Cate> cateList=checkCateList();
			request.setAttribute("cateList", cateList);
			if(flag){
				request.getRequestDispatcher("addclass.jsp").forward(request, response);
			}
		}*/
	}
	//添加分类
	public boolean addCate(Cate cate){
		
		return cd.addCate(cate);
	}
	//修改分类
	public boolean updateCate(Cate cate){
		return cd.updateCate(cate);
	}
	//删除分类
	public void delRegion(Integer cid){
		cd.delRegion(cid);
	}
		
}
