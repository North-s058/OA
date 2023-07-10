package com.neo.servlet.role;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neo.service.impl.RoleServiceImpl;

/**
 * Servlet implementation class DeleteRoleServlet
 */
public class DeleteRoleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String roleId = request.getParameter("roleId");
		new RoleServiceImpl().deleteRole(Integer.parseInt(roleId));
		response.sendRedirect("GetRoleList");
	}


}
