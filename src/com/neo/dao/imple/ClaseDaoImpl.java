package com.neo.dao.imple;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.neo.dao.BaseDao;
import com.neo.dao.ClaseDao;
import com.neo.entity.Clase;

public class ClaseDaoImpl extends BaseDao implements ClaseDao{
	public void addClase(Connection connection, String sql, Object... args) {
		update(connection, sql, args);
		
	}

	public void deleteClase(Connection connection, String sql, Object... args) {
		update(connection, sql, args);
		
	}

	public void updateClase(Connection connection, String sql, Object... args) {
		update(connection, sql, args);
	}

	public Clase getClase(Connection connection, String sql, Class<Clase> clazz, Object... args) {
		return queryOne(connection, sql, clazz, args);
	}

	public List<Clase> getClaseList(Connection connection, String sql, Class<Clase> clazz, Object... args) {
		return queryList(connection, sql, clazz, args);
	}
	public Long getClaseCount(Connection connection, String sql, Object... args) throws SQLException {
		return getCount(connection,sql,args);
	}
}
