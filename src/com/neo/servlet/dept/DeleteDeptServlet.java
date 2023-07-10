package com.neo.servlet.dept;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neo.service.DepartmentService;
import com.neo.service.impl.DeptServiceImpl;

/**
 * Servlet implementation class DeleteDeptServlet
 */
public class DeleteDeptServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DepartmentService deptService = new DeptServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String deptId = request.getParameter("deptId");
		deptService.deleteDept(Integer.parseInt(deptId));
		response.sendRedirect("GetDeptListServlet");
	}

}
