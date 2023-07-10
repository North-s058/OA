<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="zh">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />
<title>光年OA管理系统</title>
<link rel="icon" href="imgs/favicon.ico" type="image/ico">
<meta name="keywords" content="OA,光年OA管理系统">
<meta name="description" content="光年OA管理系统">
<meta name="author" content="yinqi">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/materialdesignicons.min.css" rel="stylesheet">
<link href="css/style.min.css" rel="stylesheet">
</head>
  
<body>
<div class="lyear-layout-web">
  <div class="lyear-layout-container">
    <!--左侧导航-->
    <jsp:include page="menu.jsp"></jsp:include>
    <!--End 左侧导航-->
    
    <!--头部信息-->
    <header class="lyear-layout-header">
      
      <nav class="navbar navbar-default">
        <div class="topbar">
          
          <div class="topbar-left">
            <div class="lyear-aside-toggler">
              <span class="lyear-toggler-bar"></span>
              <span class="lyear-toggler-bar"></span>
              <span class="lyear-toggler-bar"></span>
            </div>
            <span class="navbar-page-title"> 后台首页 </span>
          </div>
          
          <ul class="topbar-right">
            <li class="dropdown dropdown-profile">
              <a href="javascript:void(0)" data-toggle="dropdown">
                <img class="img-avatar img-avatar-48 m-r-10" src="images/users/avatar.jpg" alt="笔下光年" />
                <span>笔下光年 <span class="caret"></span></span>
              </a>
              <ul class="dropdown-menu dropdown-menu-right">
                <li> <a href="user_info.html"><i class="mdi mdi-account"></i> 个人信息</a> </li>
                <li> <a href="user_pwd.html"><i class="mdi mdi-lock-outline"></i> 修改密码</a> </li>
                <li class="divider"></li>
                <li> <a href="login.html"><i class="mdi mdi-logout-variant"></i> 退出登录</a> </li>
              </ul>
            </li>
          </ul>
        </div>
      </nav>
      
    </header>
    <!--End 头部信息-->
    
    <!--页面主要内容-->
    <main class="lyear-layout-content">
      
      <div class="container-fluid">
       
		<!-- 内容区 -->
		<div class="col-lg-12">
			<div class="card">
				<div class="card-header text-center">
					添加员工
				</div>
				<div class="card-body">
					<form class="form-horizontal" action="AddEmpServlet" method="post">
					  <div class="form-group">
						<label class="col-md-3 control-label" for="empName">员工姓名</label>
						<div class="col-md-7">
						  <input name="empName" class="form-control" type="text" id="empName" placeholder="员工姓名">
						</div>
					  </div>
					  <div class="form-group">
						  <label class="col-md-3 control-label" for="deptName">部门</label>
						  <div class="col-md-7">
							<select name="deptId" style="padding: 10px 0;" class="form-control" id="deptName" size="1">
							<c:forEach items="${deptList }" var="dept">
							<option value="${dept.deptId }">${dept.deptName }</option>
							</c:forEach>
							</select>
						  </div>
					  </div>
					  <div class="form-group">
						  <label class="col-md-3 control-label" for="roleName">角色</label>
						  <div class="col-md-7">
							<select name="roleId" style="padding: 10px 0;" class="form-control" id="roleName" size="1">
							  <c:forEach items="${roleList }" var="role">
							<option value="${role.roleId }">${role.roleName }</option>
							</c:forEach>
							</select>
						  </div>
					  </div>
					  <div class="form-group">
					  <label class="col-md-3 control-label">性别</label>
					  <div class="col-md-7">
						<label class="radio-inline" for="man">
						  <input type="radio" checked id="man" name="gender" value="1">
						  男
						</label>
						<label class="radio-inline" for="woman">
						  <input type="radio" id="woman" name="gender" value="0">
						  女
						</label>
					  </div>
					</div>
					<div class="form-group">
					  <label class="col-md-3 control-label" for="managerName">管理者</label>
					 
					  <div class="col-md-7">
						<select name="managerId" style="padding: 10px 0;" class="form-control" id="managerName" size="1">
						  <c:forEach items="${empList }" var="emp">
							<option value="${emp.empId }">${emp.empName }</option>
							</c:forEach>
						</select>
					  </div>
					</div>
					<div class="form-group">
						<label class="col-md-3 control-label" for="phone">手机</label>
						<div class="col-md-7">
						  <input name="phone" class="form-control" type="text" id="phone" placeholder="手机号">
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-3 control-label" for="password">密码</label>
						<div class="col-md-7">
						  <input name="password" class="form-control" type="password" id="password" placeholder="密码">
						</div>
					</div>
					  <div class="form-group">
						<label class="col-md-3 control-label" for="email">邮箱</label>
						<div class="col-md-7">
						  <input name="email" class="form-control" type="email" id="email" placeholder="邮箱">
						</div>
					  </div>
					  
					  <div class="form-group">
						<label class="col-md-3 control-label" for="hire">入职时间</label>
						<div class="col-md-7">
						  <input name="hireTime" class="form-control" type="date" id="hire">
						</div>
					  </div>
					  <div class="form-group">
						<div class="col-md-9 col-md-offset-3">
						  <button class="btn btn-primary" type="submit">添加员工</button>
						</div>
					  </div>
					</form>
				</div>
			</div>
		</div>
      </div>
      
    </main>
    <!--End 页面主要内容-->
  </div>
</div>

<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/perfect-scrollbar.min.js"></script>
<script type="text/javascript" src="js/main.min.js"></script>
</body>
</html>