package com.neo.servlet.subject;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neo.service.impl.SubjectServiceImpl;

/**
 * Servlet implementation class DeleteSubjectServlet
 */
public class DeleteSubjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String subjectId = request.getParameter("subjectId");
		new SubjectServiceImpl().deleteSubject(Integer.parseInt(subjectId));
		response.sendRedirect("GetSubjectListServlet");
	}


}
