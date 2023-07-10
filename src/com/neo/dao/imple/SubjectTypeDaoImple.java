package com.neo.dao.imple;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.neo.dao.BaseDao;
import com.neo.dao.SubjectTypeDao;
import com.neo.entity.SubjectType;

public class SubjectTypeDaoImple extends BaseDao implements SubjectTypeDao{
	public void addSubjectType(Connection connection, String sql, Object... args) {
		update(connection, sql, args);
		
	}

	public void deleteSubjectType(Connection connection, String sql, Object... args) {
		update(connection, sql, args);
		
	}

	public void updateSubjectType(Connection connection, String sql, Object... args) {
		update(connection, sql, args);
	}

	public SubjectType getSubjectType(Connection connection, String sql, Class<SubjectType> clazz, Object... args) {
		return queryOne(connection, sql, clazz, args);
	}

	public List<SubjectType> getSubjectTypeList(Connection connection, String sql, Class<SubjectType> clazz, Object... args) {
		return queryList(connection, sql, clazz, args);
	}
	public Long getSubjectTypeCount(Connection connection, String sql, Object... args) throws SQLException {
		return getCount(connection,sql,args);
	}
}
