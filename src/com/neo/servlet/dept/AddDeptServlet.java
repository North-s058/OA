package com.neo.servlet.dept;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neo.service.DepartmentService;
import com.neo.service.impl.DeptServiceImpl;

/**
 * Servlet implementation class AddDeptServlet
 */
public class AddDeptServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DepartmentService deptService = new DeptServiceImpl();
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String deptName = request.getParameter("deptName");
		String createT = request.getParameter("createTime");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date createTime = simpleDateFormat.parse(createT);
			deptService.addDept(deptName, createTime);
			response.sendRedirect("GetDeptListServlet");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
