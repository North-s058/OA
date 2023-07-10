package com.neo.servlet.emp;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neo.entity.Employee;
import com.neo.service.impl.EmpServiceImpl;

/**
 * Servlet implementation class GetEmpListServlet
 */
public class GetEmpListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		List<Employee> empList = new EmpServiceImpl().getEmpList();
//		request.setAttribute("empList", empList);
//		System.out.println(empList);
		request.getRequestDispatcher("employee_list.jsp").forward(request, response);
	}


}
