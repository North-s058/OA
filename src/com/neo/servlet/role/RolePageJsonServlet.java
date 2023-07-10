package com.neo.servlet.role;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.neo.dto.Page;
import com.neo.service.RoleService;
import com.neo.service.impl.RoleServiceImpl;

/**
 * Servlet implementation class RolePageJsonServlet
 */
public class RolePageJsonServlet extends HttpServlet {
	private static final long serialVersionUID = 4785007267389433397L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RoleService roleService = new RoleServiceImpl();
		String pageNo = request.getParameter("pageNumber");
        String pageSize = request.getParameter("pageSize");
        Page page = roleService.getRolePage(Integer.parseInt(pageNo), Integer.parseInt(pageSize));
        String json = JSON.toJSONString(page);
        response.getWriter().write(json);
	}


}
