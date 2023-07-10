<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />
<title>光年OA管理系统</title>
<link rel="icon" href="imgs/favicon.ico" type="image/ico">
<meta name="keywords" content="OA,光年OA管理系统">
<meta name="description" content="光年OA管理系统">
<meta name="author" content="yinqi">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/materialdesignicons.min.css" rel="stylesheet">
<link href="css/style.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://unpkg.com/bootstrap-table@1.22.0/dist/bootstrap-table.min.css">
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
								<span class="lyear-toggler-bar"></span> <span
									class="lyear-toggler-bar"></span> <span
									class="lyear-toggler-bar"></span>
							</div>
							<span class="navbar-page-title"> 后台首页 </span>
						</div>

						<ul class="topbar-right">
							<li class="dropdown dropdown-profile"><a
								href="javascript:void(0)" data-toggle="dropdown"> <img
									class="img-avatar img-avatar-48 m-r-10"
									src="images/users/avatar.jpg" alt="笔下光年" /> <span>笔下光年
										<span class="caret"></span>
								</span>
							</a>
								<ul class="dropdown-menu dropdown-menu-right">
									<li><a href="user_info.html"><i
											class="mdi mdi-account"></i> 个人信息</a></li>
									<li><a href="user_pwd.html"><i
											class="mdi mdi-lock-outline"></i> 修改密码</a></li>
									<li class="divider"></li>
									<li><a href="login.html"><i
											class="mdi mdi-logout-variant"></i> 退出登录</a></li>
								</ul></li>
						</ul>
					</div>
				</nav>

			</header>
			<!--End 头部信息-->

			<!--页面主要内容-->
			<main class="lyear-layout-content">

			<div class="container-fluid">
				<!-- 内容区 -->
				<div class="row">
					<div class="col-lg-12">
						<div class="card">
							<div class="table-responsive">
								<table id="table">
									
								</table>
							</div>
						</div>
					</div>

				</div>
				<!-- 内容区结束 -->
				<div class="row">
					<div class="col-lg-4 text-left">
						<a class="btn btn-info" href="dept_add.html">添加部门</a>
					</div>
					<div class="col-lg-4 text-center">
						<nav>
							
						</nav>
					</div>
					<div class="col-lg-4 text-center">
						<a class="btn btn-info" href="#">导出Excel</a>
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
	<script src="https://unpkg.com/bootstrap-table@1.22.0/dist/bootstrap-table.min.js"></script>
<script type="text/javascript">
	let table = $("#table");
	table.bootstrapTable({
		//Json
		url:"DeptPageJsonServlet",
		pagination:"true",
		//从服务器端获取数据
		sidePagination:"server",
		//设置参数从limit,offsert 变成pageNo,pagesize
		queryParamsType:"",
		responseHandler:function(res){
			return{
				total:res.count,
				rows:res.page
			}
		},
		columns:[{
			title:"序号",
			field:"deptId"
		},{
			title:"名称",
			field:"deptName"
		},{
			title:"成立时间",
			field:"createTime"
		},{
			title:"操作",
			formatter:function(value,row,index,field){
				let update ='<a  type="button" href="ToUpdateDeptServlet?deptId='+ row.deptId +'" class="btn btn-info" style="margin-right:30px">修改</a>';
				let dele = '<a onclick="if(confirm(\'确认删除?\')){return true;}else{return false;}" type="button" href="DeleteDeptServlet?deptId='+ row.deptId +'" class="btn btn-danger">删除</a>';
				return update+dele;
			}
		}]
	})
	
</script>
</body>
</html>