package com.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.dao.CarDao;
import com.domain.Car;
import com.util.JDBCUtil02;
import com.util.TextUtils;

public class CarDaoImpl implements CarDao {
	private QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());

	/**
	 * 查询所有汽车
	 * @throws SQLException 
	 */
	@Override
	public List<Car> findAll() throws SQLException {
		
		return runner.query("select * from car", new BeanListHandler<Car>(Car.class));
	}

	@Override
	public void insert(Car car) throws SQLException {
		
		 runner.update("insert into car values(null , ?,?,?,?,?,?,?)" ,
				car.getColor(),
				car.getType(),
				car.getSize(),
				car.getName(),
				car.getBorthday(),
				car.getMaintain(),
				car.getPrice()
				);
	}

	@Override
	public void delete(int carid) throws SQLException {
		runner.update("delete from car where carid=?" ,carid);
	}

	@Override
	public Car findCarById(int carid) throws SQLException {
		return runner.query("select * from car where carid = ?", new BeanHandler<Car>(Car.class) ,carid);
	}

	@Override
	public void update(Car car) throws SQLException {
		
		runner.update("update car set color=? , type=? , size=? , name=? , borthday=? , maintain=? , price=?  where carid = ?", 
				car.getColor(),
				car.getType(),
				car.getSize(),
				car.getName(),
				car.getBorthday(),
				car.getMaintain(),
				car.getPrice(),
				car.getCarid()
				);
	}

	@Override
	public List<Car> searchCar(String name, String type) throws SQLException {
		System.out.println("现在要执行模糊查询了，收到的name ="+name + "==type=="+type);
		
		
		//String sql = "select * from car where sname=? or sgender=?";
		
		/*
		 * 这里要分析一下：
		 * 	如果只有姓名 ，select * from car where sname like ? ;
		 * 	如果只有性别 ， select * from car where gender = ?
		 * 
		 * 如果两个都有 select * from car where sname like ? and gender=?
		 * 
		 * 如果两个都没有就查询所有。
		 * 
		 */
		String sql = "select * from car where 1=1 ";
		List<String> list = new ArrayList<String> ();
				
		//判断有没有姓名， 如果有，就组拼到sql语句里面
		if(!TextUtils.isEmpty(name)){
			sql = sql + "  and name like ?";
			list.add("%"+name+"%");
		}
		
		//判断有没有性别，有的话，就组拼到sql语句里面。
		if(!TextUtils.isEmpty(type)){
			sql = sql + " and type = ?";
			list.add(type);
		}
		
		
		return runner.query(sql , new BeanListHandler<Car>(Car.class) ,list.toArray() );
		
	}

	@Override
	public List<Car> findCarByPage(int currentPage) throws SQLException {
		//第一个问号，代表一页返回多少条记录  ， 第二个问号， 跳过前面的多少条记录。
		//5 0 --- 第一页 (1-1)*5
		//5 5  --- 第二页 (2-1)*5
		//5 10  --- 第三页
		return runner.query("select * from car limit ? offset ?", 
				new BeanListHandler<Car>(Car.class) , PAGE_SIZE , (currentPage-1)*PAGE_SIZE);
	}

	@Override
	public int findCount() throws SQLException {
		//用于处理 平均值 、 总的个数。 
		Long  result = (Long) runner.query("SELECT COUNT(*) FROM car" , new ScalarHandler() );
		return result.intValue();
	}


}
