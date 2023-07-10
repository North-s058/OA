package com.neo.servlet.subject;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neo.entity.Subject;
import com.neo.service.impl.SubjectServiceImpl;

/**
 * Servlet implementation class GetSubjectListServlet
 */
public class GetSubjectListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		List<Subject> subjectList = new SubjectServiceImpl().getSubjectList();
//		request.setAttribute("subjectList", subjectList);
//		System.out.println(subjectList);
		request.getRequestDispatcher("subject_list.jsp").forward(request, response);
	}


}
