package com.neo.dao.imple;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.neo.dao.BaseDao;
import com.neo.dao.RoleDao;
import com.neo.entity.Role;

public class RoleDaoImpl extends BaseDao implements RoleDao{

	public void addRole(Connection connection, String sql, Object... args) {
		update(connection, sql, args);
		
	}

	public void deleteRole(Connection connection, String sql, Object... args) {
		update(connection, sql, args);
		
	}

	public void updateRole(Connection connection, String sql, Object... args) {
		update(connection, sql, args);
	}

	public Role getRole(Connection connection, String sql, Class<Role> clazz, Object... args) {
		return queryOne(connection, sql, clazz, args);
	}

	public List<Role> getRoleList(Connection connection, String sql, Class<Role> clazz, Object... args) {
		return queryList(connection, sql, clazz, args);
	}
	public Long getRoleCount(Connection connection, String sql, Object... args) throws SQLException {
		return getCount(connection,sql,args);
	}

	

}
