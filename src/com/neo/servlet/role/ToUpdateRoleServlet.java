package com.neo.servlet.role;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neo.entity.Role;
import com.neo.service.impl.RoleServiceImpl;

/**
 * Servlet implementation class ToUpdateRoleServlet
 */
public class ToUpdateRoleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String roleId = request.getParameter("roleId");
		Role role = new RoleServiceImpl().getRole(Integer.parseInt(roleId));
		request.setAttribute("role", role);
		request.getRequestDispatcher("role_update.jsp").forward(request, response);
	}

	

}
