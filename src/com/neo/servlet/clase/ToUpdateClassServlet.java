package com.neo.servlet.clase;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neo.entity.Clase;
import com.neo.entity.Subject;
import com.neo.service.impl.ClaseServiceImpl;
import com.neo.service.impl.SubjectServiceImpl;

/**
 * Servlet implementation class ToUpdateClassServlet
 */
public class ToUpdateClassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String classId = request.getParameter("classId");
		Clase clase = new ClaseServiceImpl().getClase(Integer.parseInt(classId));
		request.setAttribute("clase", clase);
		System.out.println(clase);
		List<Subject> subjectList = new SubjectServiceImpl().getSubjectList();
		request.setAttribute("subjectList", subjectList);
		System.out.println(subjectList);
		request.getRequestDispatcher("class_update.jsp").forward(request, response);
	}


}
