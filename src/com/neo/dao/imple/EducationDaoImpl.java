package com.neo.dao.imple;

import java.sql.Connection;
import java.util.List;

import com.neo.dao.BaseDao;
import com.neo.dao.EducationDao;
import com.neo.entity.Education;

public class EducationDaoImpl extends BaseDao implements EducationDao{

	public Education getEducation(Connection connection, String sql, Class<Education> clazz, Object... args) {
		
		return queryOne(connection, sql, clazz, args); 
	}

	public List<Education> getEducationList(Connection connection, String sql, Class<Education> clazz, Object... args) {
		
		return queryList(connection, sql, clazz, args);
	}
	

}
