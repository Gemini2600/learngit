package com.neusoft.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.DataSources;

/**
 * 获取数据库连接
 * 连接池
 * */
public class ConnectionFactory {

	//使用c3p0连接数据库
	static DataSource ds=null;
	static Properties ps=new Properties();
	
	static{
		InputStream is=Thread.currentThread().getContextClassLoader().getResourceAsStream("jdbc.properties");
		try {
			ps.load(is);
			Class.forName(ps.getProperty("driver"));
			DataSource dataSource=DataSources.unpooledDataSource(ps.getProperty("url"), ps.getProperty("user"), ps.getProperty("psw"));
			ds=DataSources.pooledDataSource(dataSource);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException{
		Connection 	conn=ds.getConnection();
		return conn;
	}

}
