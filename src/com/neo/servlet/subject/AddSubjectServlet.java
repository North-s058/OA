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
 * Servlet implementation class AddSubjectServlet
 */
public class AddSubjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String subjectName = request.getParameter("subjectName");
		String subjectLife = request.getParameter("subjectLife");
		String createTim = request.getParameter("createTime");
		Date createTime;
		try {
			createTime = new SimpleDateFormat("yyyy-MM-dd").parse(createTim);
			String subjectTypeId = request.getParameter("subjectTypeId");
			new SubjectServiceImpl().addSubject(subjectName, Integer.parseInt(subjectLife), createTime, Integer.parseInt(subjectTypeId));
			response.sendRedirect("GetSubjectListServlet");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
