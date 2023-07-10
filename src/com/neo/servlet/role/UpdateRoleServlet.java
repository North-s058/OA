package com.neo.servlet.role;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neo.service.impl.RoleServiceImpl;

/**
 * Servlet implementation class UpdateRoleServlet
 */
public class UpdateRoleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String roleId = request.getParameter("roleId");
		String roleName = request.getParameter("roleName");
		String status = request.getParameter("status");
		new RoleServiceImpl().updateRole(Integer.parseInt(roleId), roleName, Integer.parseInt(status));
		response.sendRedirect("GetRoleList");
	}

}
