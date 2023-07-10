package com.neo.servlet.clase;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neo.entity.Subject;
import com.neo.service.impl.SubjectServiceImpl;

/**
 * Servlet implementation class ToAddClassServlet
 */
public class ToAddClassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Subject> subjectList = new SubjectServiceImpl().getSubjectList();
		request.setAttribute("subjectList", subjectList);
		
		request.getRequestDispatcher("class_add.jsp").forward(request, response);
	}


}
