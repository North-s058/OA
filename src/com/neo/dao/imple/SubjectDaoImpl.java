package com.neo.dao.imple;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.neo.dao.BaseDao;
import com.neo.dao.SubjectDao;
import com.neo.entity.Subject;

public class SubjectDaoImpl extends BaseDao implements SubjectDao{
	public void addSubject(Connection connection, String sql, Object... args) {
		update(connection, sql, args);
		
	}

	public void deleteSubject(Connection connection, String sql, Object... args) {
		update(connection, sql, args);
		
	}

	public void updateSubject(Connection connection, String sql, Object... args) {
		update(connection, sql, args);
	}

	public Subject getSubject(Connection connection, String sql, Class<Subject> clazz, Object... args) {
		return queryOne(connection, sql, clazz, args);
	}

	public List<Subject> getSubjectList(Connection connection, String sql, Class<Subject> clazz, Object... args) {
		return queryList(connection, sql, clazz, args);
	}
	public Long getSubjectCount(Connection connection, String sql, Object... args) throws SQLException {
		return getCount(connection,sql,args);
	}
}
