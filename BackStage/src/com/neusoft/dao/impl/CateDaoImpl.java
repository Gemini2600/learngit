package com.neusoft.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.neusoft.dao.CateDao;
import com.neusoft.dao.DaoException;
import com.neusoft.entity.Cate;
import com.neusoft.entity.PageModel;
import com.neusoft.utils.ConnectionFactory;



public class CateDaoImpl implements CateDao {
	Connection conn=null;
	QueryRunner qr=new QueryRunner();
	Cate cate=null;
	PreparedStatement pstmt = null;
	Statement stmt=null;
    ResultSet rs = null;
    List<Cate> cateList=new ArrayList<Cate>();
    List<Cate>  childList=null;
    
  //��ѯ�����ϣ���������Ϊ(����cid,����cname,(����cid,�����cname,�����pid))
	@Override
	public List<Cate> checkCateList() {
		try {
			conn=ConnectionFactory.getConnection();
			String sql="select cid,cname,pid from cate where pid is null";
			ResultSetHandler<List<Cate>> rsh=new BeanListHandler<Cate>(Cate.class);
			cateList=qr.query(conn, sql,rsh);
			for (int i=0;i<cateList.size();i++) {
				String sql_c="select cid,cname,pid from cate where pid=?";
				ResultSetHandler<List<Cate>> rsh_c=new BeanListHandler<Cate>(Cate.class);
				childList=qr.query(conn, sql_c, rsh_c,cateList.get(i).getCid());
				
				cateList.get(i).setChildList(childList);
			
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("��ѯ��������");
		}finally{
			DbUtils.closeQuietly(conn);
		}
		
		return cateList;
	}
	
	@Override
	public PageModel<Cate> getPageModel(int pageNo, int pageSize) {

		PageModel<Cate> model=null;
		try {
			conn=ConnectionFactory.getConnection();
		
		//׼��sql
		String totalcount_sql="select count(cid) from cate";
		//��ѯ�ܵļ�¼ ScalarHandler:��һ�е�һ�е�ֵ
		ResultSetHandler<Long> rsh=new ScalarHandler<>();
		
		Integer totalcount=qr.query(conn, totalcount_sql, rsh).intValue();
		if(totalcount>0){
			model=new PageModel<Cate>();
			model.setTotalcount(totalcount);
			//��ҳ��ѯ
			String sql="select cid,cname,pid from cate order by cid desc limit ?,?";
			Object[] params={(pageNo-1)*pageSize,pageSize};
			List<Cate> cates=qr.query(conn, sql, new BeanListHandler<Cate>(Cate.class),params);
			model.setDatas(cates);
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DaoException("��ҳ��ѯ����",e);
		}finally{
			DbUtils.closeQuietly(conn);
		}
		return model;
	
	}
	//���
	@Override
	public boolean addCate(Cate cate) {
		try {
			conn=ConnectionFactory.getConnection();
			String sql="insert into cate(cname,pid) values(?,?)";
			int	count=qr.update(conn, sql,cate.getCname(),cate.getPid() );
			if(count>0){
				return true;
			}
		}catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("��ӷ����������");
		}finally{
			DbUtils.closeQuietly(conn);
		}
		return false;
	}

	@Override
	public boolean updateCate(Cate cate) {
		try {
			conn=ConnectionFactory.getConnection();
			String sql="update cate set cname=?,pid=? where cid=?";
			int count=qr.update(conn, sql,cate.getCname(),cate.getPid(),cate.getCid());
			if(count>0){
				return true;
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DbUtils.closeQuietly(conn);
		}
		return false;
	}

	@Override
	public void deleteCate(int cid) {
		// TODO Auto-generated method stub
		
	}

	
	//ɾ������
	@Override
	public Cate rearchId(int cid) {
		try {
			conn =ConnectionFactory.getConnection();
			String sql = "select * from cate where cid =?";
			ResultSetHandler<Cate> rs = new BeanHandler<>(Cate.class);
			Cate tb = null;
				tb = qr.query(conn, sql, rs, cid);
				if(tb!=null)
				{
					return tb;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally
			{
				DbUtils.closeQuietly(conn);
			}
		return null;
	}
	//ɾ��������
	@Override
	public void delRegion(Integer cid) {
		try
		{
			conn = ConnectionFactory.getConnection();
			//ConnectionFactory.beginTransaction(conn);
			Cate currentNode = rearchId(cid);
			recursionDelNode(conn,cid);
			//������ڵ���û���ӽڵ�
			if(currentNode.getPid()==0)
			{
				currentNode.setPid(0);
			}
			//�ύ����
			//ConnectionFactory.commitTransaction(conn);
		}catch(Exception e)
		{
			e.printStackTrace();
			//ConnectionFactory.rollbackTransaction(conn);
		}finally
		{
			//ConnectionFactory.resetConnection(conn);
			DbUtils.closeQuietly(conn);
		}
	}
	/**
	 * �ݹ�ɾ��
	 * @param conn
	 * @param cid
	 */
	private void recursionDelNode(Connection conn, Integer cid)throws SQLException {
		String sql ="select cid,cname,pid from cate where pid = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			conn =  ConnectionFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cid);
			rs = pstmt.executeQuery();
			while(rs.next()){
				if(0==rs.getInt("pid")){
					recursionDelNode(conn, rs.getInt("cid"));
				}
				delNode(conn,rs.getInt("cid"));
			}
			//ɾ������
			delNode(conn,cid);
		
		}finally{
			DbUtils.closeQuietly(rs);
			DbUtils.closeQuietly(pstmt);
		}
		
	}
	/**
	 * ɾ���ڵ�
	 * @param conn
	 * @param int1
	 */
	private void delNode(Connection conn, int cid)throws SQLException {
		String sql ="delete from cate where cid=?";
		PreparedStatement pstmt  = null;
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cid);
			pstmt.executeUpdate();
		}finally{
			DbUtils.closeQuietly(pstmt);
		}
	}

	@Override
	public List<Cate> getTop() {
		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.createStatement();
			String sql = "select * from cate where pid is null";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				cateList.add(new Cate(rs.getInt("cid"),rs.getString("cname"),rs.getInt("pid")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DbUtils.closeQuietly(conn, stmt, rs);
		}
		return cateList;
	}

	@Override
	public List<Cate> getTopByname(String name) {
		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.createStatement();
			String sql = "select * from cate where pid =(select cid from cate where cname = '"+ name +"')";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				cateList.add(new Cate(rs.getInt("cid"),rs.getString("cname"),rs.getInt("pid")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DbUtils.closeQuietly(conn, stmt, rs);
		}
		return cateList;
	}
	
	
}
