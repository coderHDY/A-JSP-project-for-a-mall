package JDBC;

import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import JavaBean.Goods;
import JavaBean.Users;

public class GoodDao {
	//获取所有商品
	public ArrayList<Goods> getAllGoods() throws SQLException{
				QueryRunner runner=new QueryRunner(DaoPool.getDataSource());
				String sql="select * from goods";
				ArrayList<Goods> goods=(ArrayList<Goods>) runner.query(sql, new BeanListHandler(Goods.class));
				return goods;
			}
	//根据商品(id)获取商品
	public Goods getGoodById(String goodid) throws SQLException {
		//申请一个连接
		QueryRunner runner=new QueryRunner(DaoPool.getDataSource());
		//定义数据库访问语句
		String sql="select * from goods where goodsid=?";
		Goods good=(Goods)runner.query(sql, new BeanHandler(Goods.class),goodid);
		return good;
	}
	//根据(名字)获取商品(集)（模糊查询）
	public ArrayList<Goods> getGoodsByName(String name) throws SQLException{
		QueryRunner runner=new QueryRunner(DaoPool.getDataSource());
		String sql="select * from goods where name like ?";
		ArrayList<Goods> goods=(ArrayList<Goods>) runner.query(sql, new BeanListHandler(Goods.class),"%"+name+"%");
		return goods;
	}
	//根据(分类)获取商品集
	public ArrayList<Goods> getGoodsByType(String type) throws SQLException{
			QueryRunner runner=new QueryRunner(DaoPool.getDataSource());
			String sql="select * from goods where type =?";
			ArrayList<Goods> goods=(ArrayList<Goods>) runner.query(sql, new BeanListHandler(Goods.class),type);
			return goods;
		}
	//搜索所有(热门)商品
	public ArrayList<Goods> getGoodsByHot() throws SQLException{
			QueryRunner runner=new QueryRunner(DaoPool.getDataSource());
			String sql="select * from goods where hot =001";
			ArrayList<Goods> goods=(ArrayList<Goods>) runner.query(sql, new BeanListHandler(Goods.class));
			return goods;
		}
	//根据商品(名称)获取商品（单个）
	public Goods getGoodByName(String name) throws SQLException {
			//申请一个连接
			QueryRunner runner=new QueryRunner(DaoPool.getDataSource());
			//定义数据库访问语句
			String sql="select * from goods where name=?";
			Goods good=(Goods)runner.query(sql, new BeanHandler(Goods.class),name);
			return good;
		}
	//改
	public Boolean updateGood(Goods good) throws SQLException {
		QueryRunner runner=new QueryRunner(DaoPool.getDataSource());
		String sql="update goods set type=?,name=?,big=?,small=?,description=?,number=?,price=?,hot=? where goodsid=?";
		int i=runner.update(sql,new Object[] {good.getType(),good.getName(),good.getBig(),good.getSmall(),good.getDescription(),good.getNumber(),good.getPrice(),good.getHot(),good.getGoodsId()});
		if(i>0) {
			return true;
		}else {
			return false;
		}
	}
	//增
	public Boolean addGood(Goods good) throws SQLException {

		QueryRunner runner=new QueryRunner(DaoPool.getDataSource());
		String sql="insert into goods(type,name,big,small,description,number,price,hot)values(?,?,?,?,?,?,?,?)";
		int i=runner.update(sql,new Object[] {good.getType(),good.getName(),good.getBig(),good.getSmall(),good.getDescription(),good.getNumber(),good.getPrice(),good.getHot()});
		if(i>0) {
			good=null;
			return true;
		}else {
			return false;
			}
		}
	//删(id)
	public Boolean deleteGood(String goodsid) throws SQLException {
		QueryRunner runner=new QueryRunner(DaoPool.getDataSource());
		//删除本地图片
//		Goods good=getGoodById(goodsid);
//		String big=good.getBig();
//		String small=good.getSmall();
//		File b=new File("D:\\1000\\eclipse-workspace\\store1\\WebContent\\"+big);
//		File s=new File("D:\\1000\\eclipse-workspace\\store1\\WebContent\\"+small);  //小的先不用了！
//		deleteDirectory(b);
//		deleteDirectory(s);
		String sql="delete from goods where goodsid=?";
		int i=runner.update(sql,new Object[] {goodsid});
		if(i>0) {
			return true;
		}else {
			return false;
			}
		
		}
//	//删除文件方法(不好用)
//	private static void deleteDirectory(File file) {
//		if(file==null) {return;}
//		if (file.isFile()) {// 表示该文件不是文件夹
//			file.delete();
//		} else {
//			// 首先得到当前的路径
//			String[] childFilePaths = file.list();
//			for (String childFilePath : childFilePaths) {
//				File childFile = new File(file.getAbsolutePath() + "/" + childFilePath);
//				deleteDirectory(childFile);
//			}
//			file.delete();
//		}
//	}
//	public static void main(String[] args) throws SQLException {
//		GoodDao dao=new GoodDao();
//		Goods good=dao.getGoodByName("阿玛尼316");
//		
//		System.out.println(good.getPrice());
//		Goods good=new Goods();
//		good.setGoodsId("31");
//		good.setType("防晒");
//		good.setName("雅诗兰黛防晒霜");
//		good.setBig("images\\max\\goods\\kouhong/amani316/186642691.jpg");
//		good.setSmall("images\\max\\goods\\kouhong/amani316/186642691.jpg");
//		good.setDescription("这是限量款，真的是限量款！！！！");
//		good.setNumber("150");
//		good.setPrice("255");
//		good.setHot("1");
//		System.out.println(dao.updateGood(good));
//		
//		System.out.println("hello");
//		Goods good=dao.getGoodById("1");
//		System.out.println(good.getName());
//		String string=new String("阿玛尼316#");
//		String str[]=string.split("#");
//		for(int i=0;i<str.length;i++) {
//			Goods goods=dao.getGoodByName(str[i]);
//			System.out.println(goods.getName());
//			
//		}
//		for(int i=0;i<goods.size();i++) {
//			System.out.println(goods.get(i).getName());
//		}
//	}

}
