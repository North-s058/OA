package com.neo.servlet.student;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neo.entity.Clase;
import com.neo.entity.Education;
import com.neo.entity.Employee;
import com.neo.entity.Student;
import com.neo.service.impl.ClaseServiceImpl;
import com.neo.service.impl.EducationServiceImpl;
import com.neo.service.impl.EmpServiceImpl;
import com.neo.service.impl.StudentServiceImpl;

/**
 * Servlet implementation class ToAddStudentServlet
 */
public class ToAddStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Clase> claseList = new ClaseServiceImpl().getClaseList();
		request.setAttribute("claseList", claseList);
		List<Education> educationList = new EducationServiceImpl().getEducationList();
		request.setAttribute("educationList", educationList);
		List<Employee> empList = new EmpServiceImpl().getEmpList();
		request.setAttribute("empList", empList);
		request.getRequestDispatcher("student_add.jsp").forward(request, response);
	}


}
