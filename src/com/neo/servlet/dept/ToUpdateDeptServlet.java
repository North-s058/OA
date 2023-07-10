package com.neo.servlet.dept;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neo.entity.Department;
import com.neo.service.impl.DeptServiceImpl;

/**
 * Servlet implementation class ToUpdateDeptServlet
 */
public class ToUpdateDeptServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String deptId = request.getParameter("deptId");
		Department dept = new DeptServiceImpl().getDept(Integer.parseInt(deptId));
		request.setAttribute("dept", dept);
		request.getRequestDispatcher("dept_update.jsp").forward(request, response);
	}

}
