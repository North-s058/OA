package com.neo.servlet.clase;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neo.service.impl.ClaseServiceImpl;

/**
 * Servlet implementation class DeleteClassServlet
 */
public class DeleteClassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String classId = request.getParameter("classId");
		new ClaseServiceImpl().deleteClase(Integer.parseInt(classId));
		response.sendRedirect("GetClaseListServlet");
	}


}
