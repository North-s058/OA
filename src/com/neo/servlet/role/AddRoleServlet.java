package com.neo.servlet.role;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neo.service.RoleService;
import com.neo.service.impl.RoleServiceImpl;

/**
 * Servlet implementation class AddRoleServlet
 */
public class AddRoleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String roleName = request.getParameter("roleName");
		String status = request.getParameter("status");
		RoleService roleService = new RoleServiceImpl();
		roleService.addRole(roleName, Integer.parseInt(status));
		response.sendRedirect("GetRoleList");	
	}

}
