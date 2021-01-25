package JDBC;


import javax.sql.DataSource;

import com.mchange.v2.c3p0.*;
public class DaoPool {
	//���ݿ�Դ���ã���C3P0���ݿ�Դ��һ����
	public static DataSource ds;
	//��ʼ��C3P0����Դ(static������ֱ��ִ�У�����Ҫʵ����)
	static {
		ds=new ComboPooledDataSource();
		try {
			//�����������ݿ���Ҫ���õ���Ϣ
			((AbstractComboPooledDataSource) ds).setDriverClass("com.mysql.cj.jdbc.Driver");
			((AbstractComboPooledDataSource) ds).setJdbcUrl("jdbc:mysql://localhost:3306/jdbc?serverTimezone=UTC&useSSL=false&characterEncoding=utf-8");
			((AbstractComboPooledDataSource) ds).setUser("root");
			((AbstractComboPooledDataSource) ds).setPassword("123456");
			//�������ӳز���
			((AbstractComboPooledDataSource) ds).setInitialPoolSize(5);
			((AbstractComboPooledDataSource) ds).setMaxPoolSize(80);
			System.out.println("���ݿ����ӳɹ�");
		}catch(Exception e) {
			throw new ExceptionInInitializerError(e);
		}
	}
	public static DataSource getDataSource() {
		return ds;
	}
	
}
