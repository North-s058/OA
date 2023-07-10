<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<aside class="lyear-layout-sidebar">
      
      <!-- logo -->
      <div id="logo" class="sidebar-header">
        <a href="index.html"><img src="images/logo-sidebar.png" title="LightYear" alt="LightYear" /></a>
      </div>
      <div class="lyear-layout-sidebar-scroll"> 
        
        <nav class="sidebar-main">
          <ul class="nav nav-drawer">
            <li class="nav-item active"> <a href="index.jsp"><i class="mdi mdi-home"></i> 办公首页</a> </li>
            <li class="nav-item nav-item-has-subnav">
              <a href="javascript:void(0)"><i class="mdi mdi-image-filter-vintage"></i> 角色管理</a>
              <ul class="nav nav-subnav">
                <li> <a href="GetRoleList">用户角色</a> </li>
                <li> <a href="role_add.jsp">添加角色</a> </li>
              </ul>
            </li>
        	<li class="nav-item nav-item-has-subnav">
        	  <a href="javascript:void(0)"><i class="mdi mdi-counter"></i> 部门管理</a>
        	  <ul class="nav nav-subnav">
        	    <li> <a href="GetDeptListServlet">部门列表</a> </li>
        	    <li> <a href="dept_add.jsp">新增部门</a> </li>
        	  </ul>
        	</li>
        	<li class="nav-item nav-item-has-subnav">
        	  <a href="javascript:void(0)"><i class="mdi mdi-shovel"></i> 学科管理</a>
        	  <ul class="nav nav-subnav">
        	    <li> <a href="GetSubjectListServlet">学科列表</a> </li>
        	    <li> <a href="ToAddSubjectServlet">学科新增</a> </li>
        	  </ul>
        	</li>
        	<li class="nav-item nav-item-has-subnav">
        	  <a href="javascript:void(0)"><i class="mdi mdi-face-profile"></i> 班级管理</a>
        	  <ul class="nav nav-subnav">
        	    <li> <a href="GetClaseListServlet">班级列表</a> </li>
        	    <li> <a href="ToAddClassServlet">班级新增</a> </li>
        	  </ul>
        	</li>
        	<li class="nav-item nav-item-has-subnav">
        	  <a href="javascript:void(0)"><i class="mdi mdi-account-settings"></i> 员工管理</a>
        	  <ul class="nav nav-subnav">
        	    <li> <a href="GetEmpListServlet">员工列表</a> </li>
        	    <li> <a href="ToAddEmpServlet">员工新增</a> </li>
        	  </ul>
        	</li>
        	<li class="nav-item nav-item-has-subnav">
        	  <a href="javascript:void(0)"><i class="mdi mdi-trophy-variant"></i> 学员管理</a>
        	  <ul class="nav nav-subnav">
        	    <li> <a href="GetStudentListServlet">学员列表</a> </li>
        	    <li> <a href="ToAddStudentServlet">学员新增</a> </li>
        	  </ul>
        	</li>
          </ul>
        </nav>
      </div>
      
    </aside>