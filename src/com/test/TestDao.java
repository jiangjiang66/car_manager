package com.test;

import java.util.List;

import org.junit.Test;

import com.dao.impl.CarDaoImpl;
import com.domain.Car;

public class TestDao {
	@Test
	public void test01() throws Exception {
		List<Car> cars = new CarDaoImpl().searchCar("吉普", null);
		for(Car car:cars) {
			System.out.println(car);
		}
		
	}

}
