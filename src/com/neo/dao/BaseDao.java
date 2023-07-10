package com.neo.dao;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BaseDao {
	public static void update(Connection connection, String sql, Object... args) {
		try {
			PreparedStatement pStatement = connection.prepareStatement(sql);
			for (int i = 0; i < args.length; i++) {
				pStatement.setObject(i + 1, args[i]);
			}
			pStatement.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static <T> T queryOne(Connection connection, String sql, Class<T> clazz, Object... args) {
		PreparedStatement statement;
		try {
			statement = connection.prepareStatement(sql);
			for (int i = 0; i < args.length; i++) {
				statement.setObject(i + 1, args[i]);
			}
			ResultSet rSet = statement.executeQuery();
			ResultSetMetaData metaData = rSet.getMetaData();
			int columnCount = metaData.getColumnCount();
			if (rSet.next()) {
				try {
					T t = clazz.newInstance();
					// 数据库从1开始
					for (int i = 1; i <= columnCount; i++) {
						String columnLabel = metaData.getColumnLabel(i);
						Object columnValue = rSet.getObject(columnLabel);
						try {
							Field field = clazz.getDeclaredField(columnLabel);
							field.setAccessible(true);
							field.set(t, columnValue);
						} catch (NoSuchFieldException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (SecurityException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					return t;

				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static <T> List<T> queryList(Connection connection, String sql, Class<T> clazz, Object... args) {
		List<T> list = new ArrayList();
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			for (int i = 0; i < args.length; i++) {
				statement.setObject(i + 1, args[i]);
			}
			ResultSet rSet = statement.executeQuery();
			ResultSetMetaData metaData = rSet.getMetaData();
			int columnCount = metaData.getColumnCount();
			while (rSet.next()) {
				T t = clazz.newInstance();
				for (int i = 1; i <= columnCount; i++) {
					String columnLabel = metaData.getColumnLabel(i);
					Object columnValue = rSet.getObject(columnLabel);
					try {
						Field field = clazz.getDeclaredField(columnLabel);
						field.setAccessible(true);
						field.set(t, columnValue);
					} catch (NoSuchFieldException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SecurityException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				list.add(t);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return null;

	}
	public Long getCount(Connection connection, String sql, Object... args) throws SQLException {
        Long count = 0L;
        PreparedStatement statement = connection.prepareStatement(sql);
        if (args != null && args.length > 0) {
            for (int i = 0; i < args.length; i++) {
                statement.setObject(i + 1, args[i]);
            }
        }
        ResultSet rs = statement.executeQuery();
        if (rs.next()) {
            count = rs.getLong("count");
        }
        return count;
    }
}
