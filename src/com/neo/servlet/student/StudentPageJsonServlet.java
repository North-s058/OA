package com.neo.servlet.student;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.neo.dto.Page;
import com.neo.service.EmpService;
import com.neo.service.StudentService;
import com.neo.service.impl.EmpServiceImpl;
import com.neo.service.impl.StudentServiceImpl;

/**
 * Servlet implementation class StudentPageJsonServlet
 */
public class StudentPageJsonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentService studentService = new StudentServiceImpl();
		String pageNo = request.getParameter("pageNumber");
        String pageSize = request.getParameter("pageSize");
        Page page = studentService.getStudentPage(Integer.parseInt(pageNo), Integer.parseInt(pageSize));
        String json = JSON.toJSONStringWithDateFormat(page, "yyyy-MM-dd");
        response.getWriter().write(json);
	}


}
