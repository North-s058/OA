package com.neo.servlet.student;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neo.entity.Student;
import com.neo.service.impl.StudentServiceImpl;

/**
 * Servlet implementation class addStudentServlet
 */
public class addStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String studentName = request.getParameter("studentName");
		String gender = request.getParameter("gender");
		String phone = request.getParameter("phone");
		String idCard = request.getParameter("idCard");
		String greaduateSchool = request.getParameter("greaduateSchool");
		String admissionTime = request.getParameter("admissionTime");
		String classId = request.getParameter("classId");
		String empId = request.getParameter("empId");
		String educationId = request.getParameter("educationId");
		Student student = new Student();
		student.setEducationId(Integer.parseInt(educationId));
		student.setEmpId(Integer.parseInt(empId));
		student.setClassId(Integer.parseInt(classId));
		student.setStudentName(studentName);
		student.setGender(gender);
		student.setPhone(phone);
		student.setIdCard(idCard);
		student.setGraduateSchool(greaduateSchool);
		try {
			student.setAdmissionTime(new SimpleDateFormat("yyyy-MM-dd").parse(admissionTime));
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		new StudentServiceImpl().addStudent(student);
		response.sendRedirect("GetStudentListServlet");
	}

}
