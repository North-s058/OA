package com.neo.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import com.neo.dao.BaseDao;
import com.neo.dao.imple.EmpDaoImpl;
import com.neo.dao.imple.SubjectDaoImpl;
import com.neo.dao.imple.SubjectTypeDaoImple;
import com.neo.entity.Department;
import com.neo.service.RoleService;
import com.neo.service.impl.EmpServiceImpl;
import com.neo.service.impl.RoleServiceImpl;
import com.neo.service.impl.SubjectServiceImpl;
import com.neo.utils.JDBCUtils;

public class test {
	private static Connection connection = JDBCUtils.getConnection();
	@Test
//	public void test01() throws SQLException {
//		Date date = new Date();
//		String sql = "insert into department (dept_name,create_time) values(?,?)";
//		PreparedStatement prepareStatement = connection.prepareStatement(sql);
//		prepareStatement.setObject(1, "销售部");
//		prepareStatement.setObject(2, date);
//		prepareStatement.executeUpdate();
//		
//	}
//	public void test02() throws SQLException {
//		Date date = new Date();
//		String sql = "insert into department (dept_name,create_time) values(?,?)";
//		BaseDao.update(connection, sql, "招采部",date);
//		
//	}
//	public void test03() {
//		String sql = "insert into subject (subject_name,subject_life,create_time,subject_type_id)"
//				+ "values(?,?,?,?)";
//		new SubjectDaoImpl().addSubject(connection, sql, "欧美小舞种",20,new Date(),10002);
//	}
	public void test04() {
		for(int i=0;i<30;i++) {
			String sql = "insert into student (student_name,class_id,emp_id,gender,phone,id_card,graduate_school,education_id,tuition,admission_time) values (?,?,?,?,?,?,?,?,?,?)";
			int num = i%5;
			String g = i % 2==0?"男"	:"女";
			long currentTimeMillis = System.currentTimeMillis();
			Date date = new Date(currentTimeMillis);
			BaseDao.update(connection, sql, "学生名"+i,10010+num,10003,g,123445+i,34563456+i,"千峰大纪元" + i,10000+i,1000+i,date);
		}
	}
}
