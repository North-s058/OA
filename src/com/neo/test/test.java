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
//		prepareStatement.setObject(1, "���۲�");
//		prepareStatement.setObject(2, date);
//		prepareStatement.executeUpdate();
//		
//	}
//	public void test02() throws SQLException {
//		Date date = new Date();
//		String sql = "insert into department (dept_name,create_time) values(?,?)";
//		BaseDao.update(connection, sql, "�вɲ�",date);
//		
//	}
//	public void test03() {
//		String sql = "insert into subject (subject_name,subject_life,create_time,subject_type_id)"
//				+ "values(?,?,?,?)";
//		new SubjectDaoImpl().addSubject(connection, sql, "ŷ��С����",20,new Date(),10002);
//	}
	public void test04() {
		for(int i=0;i<30;i++) {
			String sql = "insert into student (student_name,class_id,emp_id,gender,phone,id_card,graduate_school,education_id,tuition,admission_time) values (?,?,?,?,?,?,?,?,?,?)";
			int num = i%5;
			String g = i % 2==0?"��"	:"Ů";
			long currentTimeMillis = System.currentTimeMillis();
			Date date = new Date(currentTimeMillis);
			BaseDao.update(connection, sql, "ѧ����"+i,10010+num,10003,g,123445+i,34563456+i,"ǧ����Ԫ" + i,10000+i,1000+i,date);
		}
	}
}
