package com.neo.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.neo.entity.Clase;

public interface ClaseDao {
	public void addClase(Connection connection, String sql, Object... args);

	public void deleteClase(Connection connection, String sql, Object... args);

	public void updateClase(Connection connection, String sql, Object... args);

	public Clase getClase(Connection connection, String sql, Class<Clase> clazz, Object... args);

	public List<Clase> getClaseList(Connection connection, String sql, Class<Clase> clazz, Object... args);

	Long getClaseCount(Connection connection, String sql, Object... args) throws SQLException;
}
