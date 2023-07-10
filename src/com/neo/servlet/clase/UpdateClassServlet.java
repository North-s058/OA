package com.neo.servlet.clase;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neo.entity.Clase;
import com.neo.entity.Subject;
import com.neo.service.impl.ClaseServiceImpl;
import com.neo.service.impl.SubjectServiceImpl;

/**
 * Servlet implementation class UpdateClassServlet
 */
public class UpdateClassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String classId = request.getParameter("classId");
		String className = request.getParameter("className");
		String subjectId = request.getParameter("subjectId");
		String classCount = request.getParameter("classCount");
		String classLife = request.getParameter("classLife");
		String classAddress = request.getParameter("classAddress");
		String createTim = request.getParameter("createTime");
		Date createTime;
		try {
			createTime = new SimpleDateFormat("yyyy-MM-dd").parse(createTim);
			Subject subject = new SubjectServiceImpl().getSubject(Integer.parseInt(subjectId));
			Clase clase = new Clase(Integer.parseInt(classId) , className, Integer.parseInt(subjectId), Integer.parseInt(classCount), Integer.parseInt(classLife), classAddress, createTime,subject );
			new ClaseServiceImpl().updateClase(clase);
			response.sendRedirect("GetClaseListServlet");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
