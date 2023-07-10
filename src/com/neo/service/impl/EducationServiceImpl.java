package com.neo.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.neo.dao.imple.EducationDaoImpl;
import com.neo.entity.Education;
import com.neo.service.EducationService;
import com.neo.utils.JDBCUtils;

public class EducationServiceImpl implements EducationService{

	public Education getEducation(Integer educationId) {
		Connection connection = JDBCUtils.getConnection();
		try {
			connection.setAutoCommit(false);
			String sql = "select education_id as educationId,education_name as educationName from education where education_id = ?";
			Education education = new EducationDaoImpl().getEducation(connection, sql, Education.class, educationId);
			connection.commit();
			return education;
		} catch (SQLException e) {
			if(connection!=null) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCUtils.close();
		}
		return null;
		
		
	}

	public List<Education> getEducationList() {
		Connection connection = JDBCUtils.getConnection();
		try {
			connection.setAutoCommit(false);
			String sql = "select education_id as educationId,education_name as educationName from education ";
			List<Education> educationList = new EducationDaoImpl().getEducationList(connection, sql, Education.class);
			connection.commit();
			return educationList;
		} catch (SQLException e) {
			if(connection!=null) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCUtils.close();
		}
		return null;
	}

}
