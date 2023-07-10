package com.neo.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.neo.entity.Department;

public interface DepartmentDao {
	public void addDept(Connection connection,String sql,Object...args);
	public void deleteDept(Connection connection,String sql,Object...args);
	public void updateDept(Connection connection,String sql,Object...args);
	public Department getDept(Connection connection,String sql,Class<Department> clazz,Object...args);
	public List<Department> getDeptList(Connection connection,String sql,Class<Department> clazz,Object...args);
	Long getDeptCount(Connection connection,String sql,Object...args) throws SQLException;
}
