package com.neo.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.neo.entity.Subject;


public interface SubjectDao {
	public void addSubject(Connection connection,String sql,Object...args);
	public void deleteSubject(Connection connection,String sql,Object...args);
	public void updateSubject(Connection connection,String sql,Object...args);
	public Subject getSubject(Connection connection,String sql,Class<Subject> clazz,Object...args);
	public List<Subject> getSubjectList(Connection connection,String sql,Class<Subject> clazz,Object...args);
	Long getSubjectCount(Connection connection,String sql,Object...args) throws SQLException;
}
