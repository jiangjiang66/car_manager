package com.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.domain.Car;
import com.domain.PageBean;
import com.service.CarService;
import com.service.impl.CarServiceImpl;

/**
 * Servlet implementation class CarManagerServlet
 */
@WebServlet("/CarUserServlet")
public class CarUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CarUserServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		CarService carservice = new CarServiceImpl();
		
		if(action.equals("listpage")) {
			try {
				//1. 获取需要显示的页码数
				int currentPage =Integer.parseInt( request.getParameter("currentPage"));
				
				//2. 根据指定的页数，去获取该页的数据回来
				//List<Student> --- list.jsp
				
				PageBean pageBean= carservice.findCarByPage(currentPage);
				request.setAttribute("pageBean", pageBean);
				//3. 跳转界面。
				request.getRequestDispatcher("list_page.jsp").forward(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
		}else if(action.equals("listall")) {
			// 3. 获取所有的汽车
			try {
				// 查询所有汽车
				List<Car> cars = carservice.findAll();
				// 保存数据
				request.setAttribute("cars", cars);
				// 跳转页面
				request.getRequestDispatcher("list.jsp").forward(request, response);
				}catch(SQLException e) {
					e.printStackTrace();
				}
			

		}else if(action.equals("search")) {
			try {
				String name = request.getParameter("name");
				String type = request.getParameter("type");

				List<Car> list = carservice.searchCar(name, type);
				
				request.setAttribute("cars", list);
				
				request.getRequestDispatcher("list.jsp").forward(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			
			
			
		} 
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
