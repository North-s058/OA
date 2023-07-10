package com.neo.servlet.dept;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neo.service.impl.DeptServiceImpl;

/**
 * Servlet implementation class UpdateDeptServlet
 */
public class UpdateDeptServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String deptId = request.getParameter("deptId");
		String deptName = request.getParameter("deptName");
		String createTim = request.getParameter("createTime");
		Date createTime;
		try {
			createTime = new SimpleDateFormat("yyyy-MM-dd").parse(createTim);
			new DeptServiceImpl().updateDept(deptName, createTime, Integer.parseInt(deptId));
			response.sendRedirect("GetDeptListServlet");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
