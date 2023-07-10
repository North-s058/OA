package com.neo.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.neo.entity.Role;

public interface RoleDao {
	public void addRole(Connection connection,String sql,Object...args);
	public void deleteRole(Connection connection,String sql,Object...args);
	public void updateRole(Connection connection,String sql,Object...args);
	public Role getRole(Connection connection,String sql,Class<Role> clazz,Object...args);
	public List<Role> getRoleList(Connection connection,String sql,Class<Role> clazz,Object...args);
	Long getRoleCount(Connection connection,String sql,Object...args) throws SQLException;
}
