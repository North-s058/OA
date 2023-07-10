package com.neo.dao;

import java.sql.Connection;
import java.util.List;

import com.neo.entity.Education;

public interface EducationDao {
	public Education getEducation(Connection connection,String sql,Class<Education> clazz,Object...args);
	public List<Education> getEducationList(Connection connection,String sql,Class<Education> clazz,Object...args);
}
