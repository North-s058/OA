package com.neo.servlet.role;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neo.entity.Role;
import com.neo.service.RoleService;
import com.neo.service.impl.RoleServiceImpl;

/**
 * Servlet implementation class GetRoleList
 */
public class GetRoleList extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		RoleService roleService = new RoleServiceImpl();
//		List<Role> roleList = roleService.getRoleList();
//		request.setAttribute("roleList", roleList);
		request.getRequestDispatcher("role_list.jsp").forward(request, response);
	}


}
