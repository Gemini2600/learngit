package com.neusoft.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.DataSources;

/**
 * π§æﬂ¿‡
 * */
public class DbUtil {

	static Properties ps=new Properties();
	static{
		InputStream is=Thread.currentThread().getContextClassLoader().getResourceAsStream("dao.properties");
		try {
			ps.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static <T>  T getInstance(String daoName,Class<T> cls){
		T t=null;
		String className=ps.getProperty(daoName);
		
		if(className==null||className.equals("")){
			return t;
		}
		
		try {
			Class<?> clz=Class.forName(className);
			 t=(T)clz.newInstance();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return t;
	}
	

	
}
