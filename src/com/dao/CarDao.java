package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.domain.Car;

public interface CarDao {
int PAGE_SIZE = 5; //一页显示多少条记录
	
	/**
	 * 查询当页的汽车数据
	 * @param currentPage
	 * @return
	 * @throws SQLException
	 */
	List<Car> findCarByPage(int currentPage) throws SQLException ;
	
	/**
	 * 查询所有汽车
	 * @return  List<Car>
	 */
	List<Car> findAll()  throws SQLException ;
	
	/**
	 * 根据ID查询单个汽车对象
	 * @param sid
	 * @return
	 * @throws SQLException
	 */
	Car findCarById(int sid)  throws SQLException ;

	/**
	 * 模糊查询， 根据姓名或者根据性别，或者两者兼有。 
	 * @param sname
	 * @param sgender
	 * @return 集合
	 * @throws SQLException
	 */
	List<Car> searchCar(String sname , String sgender)  throws SQLException ;

	/**
	 * 添加汽车
	 * @param Car 需要添加到数据库的汽车对象
	 * @throws SQLException
	 */
	void insert(Car Car) throws SQLException ;
	
	/**
	 * 根据id删除汽车
	 * @param sid
	 * @throws SQLException
	 */
	void delete(int sid) throws SQLException ;
	
	/**
	 * 更新汽车信息
	 * @param Car 需要更新的汽车数据
	 * @throws SQLException
	 */
	void update (Car Car )throws SQLException ;
	
	
	/**
	 * 查询总的汽车记录数
	 * @return
	 * @throws SQLException
	 */
	int findCount()throws SQLException ;
	

}
