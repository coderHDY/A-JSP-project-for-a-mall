package JDBC;


import javax.sql.DataSource;

import com.mchange.v2.c3p0.*;
public class DaoPool {
	//数据库源设置（和C3P0数据库源不一样）
	public static DataSource ds;
	//初始化C3P0数据源(static代码块会直接执行，不需要实例化)
	static {
		ds=new ComboPooledDataSource();
		try {
			//设置连接数据库需要配置的信息
			((AbstractComboPooledDataSource) ds).setDriverClass("com.mysql.cj.jdbc.Driver");
			((AbstractComboPooledDataSource) ds).setJdbcUrl("jdbc:mysql://localhost:3306/jdbc?serverTimezone=UTC&useSSL=false&characterEncoding=utf-8");
			((AbstractComboPooledDataSource) ds).setUser("root");
			((AbstractComboPooledDataSource) ds).setPassword("123456");
			//设置连接池参数
			((AbstractComboPooledDataSource) ds).setInitialPoolSize(5);
			((AbstractComboPooledDataSource) ds).setMaxPoolSize(80);
			System.out.println("数据库连接成功");
		}catch(Exception e) {
			throw new ExceptionInInitializerError(e);
		}
	}
	public static DataSource getDataSource() {
		return ds;
	}
	
}
