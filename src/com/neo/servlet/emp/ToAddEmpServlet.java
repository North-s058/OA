package com.neo.servlet.emp;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neo.entity.Department;
import com.neo.entity.Employee;
import com.neo.entity.Role;
import com.neo.service.impl.DeptServiceImpl;
import com.neo.service.impl.EmpServiceImpl;
import com.neo.service.impl.RoleServiceImpl;

/**
 * Servlet implementation class ToAddEmpServlet
 */
public class ToAddEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Department> deptList = new DeptServiceImpl().getDeptList();
		List<Role> roleList = new RoleServiceImpl().getRoleList();
		List<Employee> empList = new EmpServiceImpl().getEmpList();
		request.setAttribute("deptList", deptList);
		request.setAttribute("roleList", roleList);
		request.setAttribute("empList", empList);
		
		request.getRequestDispatcher("employee_add.jsp").forward(request, response);
	}

}
