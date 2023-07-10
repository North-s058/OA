package com.neo.dao.imple;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.neo.dao.BaseDao;
import com.neo.dao.DepartmentDao;
import com.neo.entity.Department;

public class DepartmentDaoImpl extends BaseDao implements DepartmentDao{

	public void addDept(Connection connection, String sql, Object... args) {
		update(connection, sql, args);
		
	}

	public void deleteDept(Connection connection, String sql, Object... args) {
		update(connection, sql, args);
		
	}

	public void updateDept(Connection connection, String sql, Object... args) {
		update(connection, sql, args);
		
	}

	public Department getDept(Connection connection, String sql, Class<Department> clazz, Object... args) {
		return queryOne(connection, sql, clazz, args);
	}

	public List<Department> getDeptList(Connection connection, String sql, Class<Department> clazz, Object... args) {
		return queryList(connection, sql, clazz, args);
	}

	public Long getDeptCount(Connection connection, String sql, Object... args) throws SQLException {
		return getCount(connection, sql, args);
		
	}

}
