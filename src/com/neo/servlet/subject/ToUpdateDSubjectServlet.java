package com.neo.servlet.subject;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neo.entity.Subject;
import com.neo.entity.SubjectType;
import com.neo.service.impl.SubjectServiceImpl;
import com.neo.service.impl.SubjectTypeServiceImpl;

/**
 * Servlet implementation class ToUpdateDSubjectServlet
 */
public class ToUpdateDSubjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String subjectId = request.getParameter("subjectId");
		Subject subject = new SubjectServiceImpl().getSubject(Integer.parseInt(subjectId));
		request.setAttribute("subject", subject);
		List<SubjectType> subjectTypeList = new SubjectTypeServiceImpl().getSubjectTypeList();
		request.setAttribute("subjectTypeList", subjectTypeList);
		
		request.getRequestDispatcher("subject_update.jsp").forward(request, response);
	}


}
