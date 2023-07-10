package com.neo.servlet.emp;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neo.service.impl.EmpServiceImpl;

/**
 * Servlet implementation class AddEmpServlet
 */
public class AddEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String empName = request.getParameter("empName");
		String deptId = request.getParameter("deptId");
		String roleId = request.getParameter("roleId");
		String genderString = request.getParameter("gender");
		int gender = genderString =="ÄÐ"?1:0;
		String managerId = request.getParameter("managerId");
		String phone = request.getParameter("phone");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String hireTim = request.getParameter("hireTime");
		try {
			Date hireTime = new SimpleDateFormat("yyyy-MM-dd").parse(hireTim);
			new EmpServiceImpl().addEmp(empName, Integer.parseInt(deptId), Integer.parseInt(roleId), gender, Integer.parseInt(managerId), phone, password, email, hireTime);
			response.sendRedirect("GetEmpListServlet");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
