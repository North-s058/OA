-- 创建角色表
CREATE TABLE role(
    role_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT "角色主键",
    role_name VARCHAR(100) unique NOT NULL COMMENT "角色名称",
    status INT NOT NULL DEFAULT '0' COMMENT "状态: 有效/无效 0:无效 1:有效"
)ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=UTF8 COMMENT="角色表";

-- 部门表
CREATE TABLE department(
    dept_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT "部门主键",
    dept_name VARCHAR(100) NOT NULL COMMENT "部门名称",
    create_time DATE NOT NULL COMMENT "部门创建时间"
)ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=UTF8 COMMENT="部门表";

-- 员工表
CREATE TABLE employee(
    emp_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT "员工主键",
    emp_name VARCHAR(100) NOT NULL COMMENT "员工名",
    dept_id INT COMMENT "部门ID，关联department表的主键",
		role_id INT  NOT NULL COMMENT "角色ID关联角色表主键",
		manager_id INT DEFAULT NULL COMMENT "管理者ID,关联员工表主键",
    gender INT DEFAULT "1" COMMENT "性别 1:男 0:女",
    phone VARCHAR(50) NOT NULL COMMENT "手机号",
		`password` VARCHAR(255) NOT NULL COMMENT "员工密码",
    email VARCHAR(255) NOT NULL COMMENT "邮箱",
    hire_time DATE NOT NULL COMMENT "入职时间"
)ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=UTF8 COMMENT="员工表";


-- 将员工表的部门ID和部门表的主键进行关联
ALTER TABLE employee ADD FOREIGN KEY (`dept_id`) REFERENCES department(`dept_id`);
ALTER TABLE employee ADD FOREIGN KEY (`role_id`) REFERENCES role(`role_id`);
ALTER TABLE employee ADD FOREIGN KEY (`manager_id`) REFERENCES employee(`emp_id`);


-- 任务类型表 work_type
CREATE TABLE work_type(
    work_type_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT "任务类型主键",
    work_type_name VARCHAR(100) NOT NULL COMMENT "任务类型名称"
)ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=UTF8 COMMENT="任务类型表";

-- 考勤表 attendance
CREATE TABLE attendance(
    attendance_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT "考勤表主键",
    emp_id INT NOT NULL COMMENT "员工ID,关联员工表的主键",
    work_type_id INT NOT NULL COMMENT "任务类型ID,关联任务类型主键",
    start_time DATE NOT NULL COMMENT "起始时间",
    end_time DATE NOT NULL COMMENT "结束时间",
    days INT NOT NULL DEFAULT 1 COMMENT "请假天数",
	approver_id INT NOT NULL COMMENT "审批人ID,关联员工表主键",
    `status` VARCHAR(20) NOT NULL COMMENT "任务状态 0:待审批 1: 审批通过 2: 审批未通过",
	reason VARCHAR(255) COMMENT "请假原因"
)ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=UTF8 COMMENT="考勤表";

-- 添加外键关联
ALTER TABLE attendance ADD FOREIGN KEY (`emp_id`) REFERENCES employee(`emp_id`);
ALTER TABLE attendance ADD FOREIGN KEY (`work_type_id`) REFERENCES work_type(`work_type_id`);

-- 学科类型表
CREATE TABLE subject_type(
    subject_type_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT "学科类型主键",
    subject_type_name VARCHAR(100) NOT NULL COMMENT "学科名称"
)ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=UTF8 COMMENT="学科类型表";

-- 学科表
CREATE TABLE subject(
    subject_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT "学科主键",
    subject_name VARCHAR(100) NOT NULL COMMENT "学科名称",
    subject_life INT DEFAULT 0 COMMENT "学科周期",
    create_time DATE NOT NULL COMMENT "学科创建时间",
    subject_type_id INT NOT NULL COMMENT "学科类型ID，关联学科表主键"
)ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=UTF8 COMMENT="学科表";

-- 外键关联
ALTER TABLE subject ADD FOREIGN KEY (`subject_type_id`) REFERENCES subject_type(`subject_type_id`);

-- 班级表
CREATE TABLE `class`(
    class_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT "班级主键",
    class_name VARCHAR(100) NOT NULL COMMENT "班级名称",
    subject_id INT NOT NULL COMMENT "学科ID，关联学科表主键",
    class_count INT DEFAULT  0 COMMENT "班级人数",
    class_life INT DEFAULT 0 COMMENT "班级周期",
    class_address VARCHAR(255) NOT NULL COMMENT "班级地址",
    create_time DATE NOT NULL COMMENT "班级创建时间"
)ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=UTF8 COMMENT="班级表";

-- 外键关联
ALTER TABLE `class` ADD FOREIGN KEY (`subject_id`) REFERENCES subject(`subject_id`);

-- 学历表education
CREATE TABLE education(
    education_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT "学历主键",
    education_name VARCHAR(100) NOT NULL COMMENT "学历名称"
)ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=UTF8 COMMENT="学历表";

-- 学员表 student
CREATE TABLE `student`(
    student_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT "学员主键",
    student_name VARCHAR(100) NOT NULL COMMENT "学员名称",
    class_id INT NOT NULL COMMENT "班级ID关联班级表的主键",
	emp_id INT NOT NULL COMMENT "员工ID关联员工表主键",
    gender VARCHAR(10) NOT NULL COMMENT "性别 男:女",
    phone VARCHAR(50) NOT NULL COMMENT "手机号",
    id_card VARCHAR(50)  COMMENT "身份证号",
    graduate_school VARCHAR (100) DEFAULT NULL COMMENT "毕业院校",
    education_id INT NOT NULL COMMENT "学历ID,关联学历表主键",
	tuition double(10,2) DEFAULT "0.00" COMMENT "学费",
    admission_time DATE NOT NULL COMMENT "入学时间"
)ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=UTF8 COMMENT="学员表";


-- 外键
ALTER TABLE `student` ADD FOREIGN KEY (`education_id`) REFERENCES education(`education_id`);
ALTER TABLE `student` ADD FOREIGN KEY (`class_id`) REFERENCES class(`class_id`);
ALTER TABLE `student` ADD FOREIGN KEY (`emp_id`) REFERENCES employee(`emp_id`);