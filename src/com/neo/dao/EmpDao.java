package com.neo.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.neo.entity.Employee;
import com.neo.entity.Role;

public interface EmpDao {
	public void addEmp(Connection connection,String sql,Object...args);
	public void deleteEmp(Connection connection,String sql,Object...args);
	public void updateEmp(Connection connection,String sql,Object...args);
	public Employee getEmp(Connection connection,String sql,Class<Employee> clazz,Object...args);
	public List<Employee> getEmpList(Connection connection,String sql,Class<Employee> clazz,Object...args);
	Long getEmpCount(Connection connection, String sql, Object... args) throws SQLException;
}
