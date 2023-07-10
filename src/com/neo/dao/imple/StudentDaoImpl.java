package com.neo.dao.imple;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.neo.dao.BaseDao;
import com.neo.dao.StudentDao;
import com.neo.entity.Student;

public class StudentDaoImpl extends BaseDao implements StudentDao{
	public void addStudent(Connection connection, String sql, Object... args) {
		update(connection, sql, args);
		
	}

	public void deleteStudent(Connection connection, String sql, Object... args) {
		update(connection, sql, args);
		
	}

	public void updateStudent(Connection connection, String sql, Object... args) {
		update(connection, sql, args);
		
	}

	public Student getStudent(Connection connection, String sql,Class<Student> clazz, Object... args) {
		return queryOne(connection, sql, clazz, args);
	}

	public List<Student> getStudentList(Connection connection, String sql, Class<Student> clazz,Object... args) {
		return queryList(connection, sql, clazz, args);
	}

	public Long getStudentCount(Connection connection, String sql, Object... args) {
		try {
			return getCount(connection, sql, args);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
