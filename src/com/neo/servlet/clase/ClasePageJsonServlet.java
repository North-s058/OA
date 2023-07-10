package com.neo.servlet.clase;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.neo.dto.Page;
import com.neo.service.ClaseService;
import com.neo.service.DepartmentService;
import com.neo.service.impl.ClaseServiceImpl;

/**
 * Servlet implementation class ClasePageJsonServlet
 */
public class ClasePageJsonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ClaseService claseService = new ClaseServiceImpl();
		String pageNo = request.getParameter("pageNumber");
        String pageSize = request.getParameter("pageSize");
        Page page = claseService.getClasePage(Integer.parseInt(pageNo), Integer.parseInt(pageSize));
        String json = JSON.toJSONStringWithDateFormat(page, "yyyy-MM-dd");
        response.getWriter().write(json);
	}


}
