package com.neo.dao;

import java.sql.Connection;
import java.util.List;

import com.neo.entity.Student;

public interface StudentDao {
	public void addStudent(Connection connection,String sql,Object...args);
	public void deleteStudent(Connection connection,String sql,Object...args);
	public void updateStudent(Connection connection,String sql,Object...args);
	public Student getStudent(Connection connection,String sql,Class<Student> clazz,Object...args);
	public List<Student> getStudentList(Connection connection,String sql,Class<Student> clazz,Object...args);
	public Long getStudentCount(Connection connection,String sql,Object...args);
}
