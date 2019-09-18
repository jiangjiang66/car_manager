package com.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.domain.Car;
import com.service.CarService;
import com.service.impl.CarServiceImpl;

/**
 * Servlet implementation class CarManagerServlet2
 */
@WebServlet("/CarManagerServlet")
public class CarManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CarManagerServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		CarService carservice = new CarServiceImpl();
		
		if(action.equals("")) {
			
			
		}else if(action.equals("toedit")) {
			try {
				int cid  = Integer.parseInt(request.getParameter("cid"));
				Car car = carservice.findCarById(cid);
				request.setAttribute("car", car);
				request.getRequestDispatcher("edit.jsp").forward(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			
		}else if(action.equals("editone")) {
			// 4. 修改单个汽车
			try {
				int cid = Integer.parseInt(request.getParameter("cid"));
				String color = request.getParameter("color");
				String type = request.getParameter("type");
				String size = request.getParameter("size");
				String name = request.getParameter("name");
				String borthday = request.getParameter("borthday");
				Date date= new SimpleDateFormat("yyyy-MM-dd").parse(borthday);
				int maintain = Integer.parseInt(request.getParameter("maintain"));
				int price = Integer.parseInt(request.getParameter("price"));
				
				carservice.update(new Car(cid,color, type, size, name, date, maintain, price));
				
				response.sendRedirect("CarUserServlet?action=listall");
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			
			
			
			
		}else if(action.equals("editmore")) {
			// 5. 批量修改汽车，页面的形式
			
			
		}else if(action.equals("add")) {
			// 6. 批量增加汽车，页面的形式
			try {
				String color = request.getParameter("color");
				String type = request.getParameter("type");
				String size = request.getParameter("size");
				String name = request.getParameter("name");
				String borthday = request.getParameter("borthday");
				Date date= new SimpleDateFormat("yyyy-MM-dd").parse(borthday);
				int maintain = Integer.parseInt(request.getParameter("maintain"));
				int price = Integer.parseInt(request.getParameter("price"));
				
				carservice.insert(new Car(color, type, size, name, date, maintain, price));
				
				response.sendRedirect("CarUserServlet?action=listall");
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			
		}else if(action.equals("delone")) {
			// 1. 删除单个汽车
			try {
				// 获取参数
				int cid = Integer.parseInt(request.getParameter("cid"));
				// 执行删除
				carservice.delete(cid);
				// 跳转到列表页
				response.sendRedirect("CarUserServlet?action=listall");
				}catch(SQLException e) {
					e.printStackTrace();
				}
			
			
		}else if(action.equals("delmore")) {
			// 2. 删除多个汽车
			try {
				String ids[] = request.getParameterValues("carids");
				for(String id: ids) {
					carservice.delete(Integer.parseInt(id));
					request.getRequestDispatcher("CarUserServlet?action=listall").forward(request, response);
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		
		
		
	}

}
