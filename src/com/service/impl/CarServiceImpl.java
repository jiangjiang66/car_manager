package com.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.domain.Car;
import com.domain.PageBean;
import com.dao.CarDao;
import com.dao.impl.CarDaoImpl;
import com.service.CarService;
//事务处理应该放在service
public class CarServiceImpl implements CarService {
	private CarDao dao = new CarDaoImpl();

	@Override
	public List<Car> findAll() throws SQLException {
		return dao.findAll();
	}

	@Override
	public void insert(Car Car) throws SQLException {
		dao.insert(Car);
	}

	@Override
	public void delete(int cid) throws SQLException {
		dao.delete(cid);
	}

	@Override
	public Car findCarById(int cid) throws SQLException {
		return dao.findCarById(cid);
	}

	@Override
	public void update(Car Car) throws SQLException {
		dao.update(Car);
		
	}

	@Override
	public List<Car> searchCar(String name, String type) throws SQLException {
		return dao.searchCar(name, type);
	}

	@Override
	public PageBean findCarByPage(int currentPage) throws SQLException {
		
		//封装分页的该页数据
		PageBean<Car> pageBean = new PageBean<Car>();
		
		int pageSize = CarDao.PAGE_SIZE ;
		pageBean.setCurrentPage(currentPage); //设置当前页
		pageBean.setPageSize(pageSize); //设置每页显示多少记录
		
		CarDao dao = new CarDaoImpl() ;
		List<Car> list =dao .findCarByPage(currentPage);
		pageBean.setList(list); //设置这一页的学生数据
		
		//总的记录数， 总的页数。
		int count = dao.findCount();
		pageBean.setTotalSize(count); //设置总的记录数
		//200 ， 10 ==20   201 ， 10 = 21   201 % 10 == 0 ?201 / 10 :201 % 10 + 1
		pageBean.setTotalPage(count % pageSize==0 ? count / pageSize : (count / pageSize) + 1); //总页数
		return pageBean;
	}

}
