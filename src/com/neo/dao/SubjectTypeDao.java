package com.neo.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.neo.entity.SubjectType;

public interface SubjectTypeDao {
	public void addSubjectType(Connection connection,String sql,Object...args);
	public void deleteSubjectType(Connection connection,String sql,Object...args);
	public void updateSubjectType(Connection connection,String sql,Object...args);
	public SubjectType getSubjectType(Connection connection,String sql,Class<SubjectType> clazz,Object...args);
	public List<SubjectType> getSubjectTypeList(Connection connection,String sql,Class<SubjectType> clazz,Object...args);
	Long getSubjectTypeCount(Connection connection,String sql,Object...args) throws SQLException;
}
