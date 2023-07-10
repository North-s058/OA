package com.neo.servlet.subject;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.neo.dto.Page;
import com.neo.service.SubjectService;
import com.neo.service.impl.SubjectServiceImpl;

/**
 * Servlet implementation class SubjectPageJsonServlet
 */
public class SubjectPageJsonServlet extends HttpServlet {
	private static final long serialVersionUID = 4785007267389433397L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SubjectService SubjectService = new SubjectServiceImpl();
		String pageNo = request.getParameter("pageNumber");
        String pageSize = request.getParameter("pageSize");
        Page page = SubjectService.getSubjectPage(Integer.parseInt(pageNo), Integer.parseInt(pageSize));
        System.out.println(page);
        String json = JSON.toJSONStringWithDateFormat(page, "yyyy-MM-dd");
        response.getWriter().write(json);
	}


}
