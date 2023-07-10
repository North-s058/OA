<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="zh">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />
<title>光年OA管理系统</title>
<link rel="icon" href="imgs/favicon.ico" type="image/ico">
<meta name="keywords" content="ukoko.cn">
<meta name="description" content="解决中小企业...">
<meta name="author" content="夜泊">
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
					修改学生
				</div>
				<div class="card-body">
					<form class="form-horizontal" action="UpdateStudentServlet" method="post">
				   <input type="hidden" name="studentId" value="${student.studentId }">
					  <div class="form-group">
						<label class="col-md-3 control-label" for="gn_name">姓名</label>
						<div class="col-md-7">
						  <input name="studentName" value="${student.studentName }"class="form-control" type="text" id="gn_name" placeholder="学员姓名">
						</div>
					  </div>
					  <div class="form-group">
						  <label class="col-md-3 control-label" for="gn_class">班级</label>
						  <div class="col-md-7">
							<select name="classId" style="padding: 10px 0;" class="form-control" id="gn_class" size="1">
							  <c:forEach items="${claseList}" var="clase">
							  	<option  <c:if test="${student.classId eq clase.classId }">selected</c:if> value="${clase.classId }">${clase.className }</option>
							  </c:forEach>							 
							</select>
						  </div>
					  </div>
					  <div class="form-group">
					  <label class="col-md-3 control-label">性别</label>
					  <div class="col-md-7">
						<label class="radio-inline" for="man">
						  <input type="radio" <c:if test="${student.gender eq '男'}">selected</c:if> checked="checked" id="man"  name="gender" value="男">
						  男
						</label>
						<label class="radio-inline" for="woman">
						  <input <c:if test="${student.gender eq '男'}">selected</c:if> type="radio" name="gender" id="woman" value="女">
						  女
						</label>
					  </div>
					</div>
					  <div class="form-group">
						<label class="col-md-3 control-label" for="phone">手机</label>
						<div class="col-md-7">
						  <input name="phone" value="${student.phone }" class="form-control" type="text" id="phone" placeholder="手机号">
						</div>
					  </div>
					  <div class="form-group">
						<label class="col-md-3 control-label" for="idcard">身份证</label>
						<div class="col-md-7">
						  <input name="idCard" value="${student.idCard }" class="form-control" type="text" id="idcard" placeholder="身份证">
						</div>
					  </div>
					  <div class="form-group">
						<label class="col-md-3 control-label" for="graduate_school">毕业学校</label>
						<div class="col-md-7">
						  <input name="greaduateSchool" value="${student.graduateSchool}" class="form-control" type="text" id="graduate_school" placeholder="毕业学校">
						</div>
					  </div>
					  <div class="form-group">
						  <label class="col-md-3 control-label" for="education">学历</label>
						  <div class="col-md-7">
							<select name="educationId" style="padding: 10px 0;" class="form-control" id="education" size="1">
							<c:forEach items="${educationList }" var="education">
							<option  <c:if  test="${student.educationId eq education.educationId }">selected</c:if>  value="${education.educationId }">${education.educationName}</option>
							</c:forEach>
							  
							  
							</select>
						  </div>
					  </div>
					  <div class="form-group">
						<label class="col-md-3 control-label" for="example-hf-hire">入学日期</label>
						<div class="col-md-7">
						  <input name="admissionTime" value="student.admissionTime" class="form-control" type="date" id="example-hf-hire">
						</div>
					  </div>
					  <div class="form-group">
						  <label class="col-md-3 control-label" for="example-manager">招生老师</label>
						  <div class="col-md-7">
							<select name="empId" style="padding: 10px 0;" class="form-control" id="example-manager" size="1">
							  <c:forEach items="${empList }" var="emp">
							<option  <c:if test="${student.empId eq emp.empId }">selected</c:if> value="${emp.empId }">${emp.empName}</option>
							</c:forEach>
							</select>
						  </div>
					  </div>
					  <div class="form-group">
						<div class="col-md-9 col-md-offset-3">
						  <button class="btn btn-primary" type="submit">确认修改</button>
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