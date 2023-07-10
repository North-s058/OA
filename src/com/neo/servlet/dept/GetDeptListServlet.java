package com.neo.servlet.dept;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neo.entity.Department;
import com.neo.service.DepartmentService;
import com.neo.service.impl.DeptServiceImpl;

/**
 * Servlet implementation class GetDeptList
 */
public class GetDeptListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		DepartmentService deptService = new DeptServiceImpl();
//		List<Department> deptList = deptService.getDeptList();
//		request.setAttribute("deptList", deptList);
		request.getRequestDispatcher("dept_list.jsp").forward(request, response);
		
	}

	

}
