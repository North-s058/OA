package com.neo.servlet.subject;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neo.service.impl.SubjectServiceImpl;

/**
 * Servlet implementation class UpdateSubjectServlet
 */
public class UpdateSubjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String subjectName = request.getParameter("subjectName");
		String subjectLife = request.getParameter("subjectLife");
		String createTim = request.getParameter("createTime");
		try {
			Date createTime = new SimpleDateFormat("yyyy-MM-dd").parse(createTim);
			String subjectId = request.getParameter("subjectId");
			new SubjectServiceImpl().updateSubject(Integer.parseInt(subjectId), subjectName, createTime,Integer.parseInt(subjectLife));
			response.sendRedirect("GetSubjectListServlet");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
