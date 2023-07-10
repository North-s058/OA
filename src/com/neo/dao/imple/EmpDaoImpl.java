package com.neo.dao.imple;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.neo.dao.BaseDao;
import com.neo.dao.EmpDao;
import com.neo.entity.Employee;

public class EmpDaoImpl extends BaseDao implements EmpDao{
	public void addEmp(Connection connection, String sql, Object... args) {
		update(connection, sql, args);
		
	}

	public void deleteEmp(Connection connection, String sql, Object... args) {
		update(connection, sql, args);
		
	}

	public void updateEmp(Connection connection, String sql, Object... args) {
		update(connection, sql, args);
	}

	public Employee getEmp(Connection connection, String sql, Class<Employee> clazz, Object... args) {
		return queryOne(connection, sql, clazz, args);
	}

	public List<Employee> getEmpList(Connection connection, String sql, Class<Employee> clazz, Object... args) {
		return queryList(connection, sql, clazz, args);
	}

	public Long getEmpCount(Connection connection, String sql, Object... args) throws SQLException {
		return getCount(connection,sql,args);
	}
}
