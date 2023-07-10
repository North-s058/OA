package com.neo.servlet.clase;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neo.service.impl.ClaseServiceImpl;

/**
 * Servlet implementation class addClassServlet
 */
public class addClassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String className = request.getParameter("className");
		String subjectId = request.getParameter("subjectId");
		String classCount = request.getParameter("classCount");
		String classLife = request.getParameter("classLife");
		String classAddress = request.getParameter("classAddress");
		String createTim = request.getParameter("createTime");
		Date createTime;
		try {
			createTime = new SimpleDateFormat("yyyy-MM-dd").parse(createTim);
			new ClaseServiceImpl().addClase(className, Integer.parseInt(subjectId), Integer.parseInt(classCount), Integer.parseInt(classLife), classAddress, createTime);
			response.sendRedirect("GetClaseListServlet");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


}
