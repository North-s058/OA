package com.neo.servlet.dept;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.neo.dto.Page;
import com.neo.service.DepartmentService;
import com.neo.service.RoleService;
import com.neo.service.impl.DeptServiceImpl;
import com.neo.service.impl.RoleServiceImpl;

/**
 * Servlet implementation class RolePageJsonServlet
 */
public class DeptPageJsonServlet extends HttpServlet {
	private static final long serialVersionUID = 4785007267389433397L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DepartmentService deptService = new DeptServiceImpl();
		String pageNo = request.getParameter("pageNumber");
        String pageSize = request.getParameter("pageSize");
        Page page = deptService.getDeptPage(Integer.parseInt(pageNo), Integer.parseInt(pageSize));
        String json = JSON.toJSONStringWithDateFormat(page, "yyyy-MM-dd");
        response.getWriter().write(json);
	}


}
