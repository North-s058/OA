package com.neo.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.neo.dao.BaseDao;
import com.neo.dao.SubjectTypeDao;
import com.neo.dao.imple.SubjectTypeDaoImple;
import com.neo.dto.Page;
import com.neo.entity.Department;
import com.neo.entity.Employee;
import com.neo.entity.SubjectType;
import com.neo.service.SubjectTypeService;
import com.neo.utils.JDBCUtils;

public class SubjectTypeServiceImpl implements SubjectTypeService{
	private SubjectTypeDao SubjectTypeDao = new SubjectTypeDaoImple();
	public void addSubjectType(String SubjectTypeName, int status) {
		Connection connection = JDBCUtils.getConnection();
		String sql = "insert into SubjectType (SubjectType_name,status) values (?,?)";
		try {
			connection.setAutoCommit(false);
			SubjectTypeDao.addSubjectType(connection, sql, SubjectTypeName,status);
			connection.commit();
		} catch (SQLException e) {
			if(connection!=null) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			e.printStackTrace();
		}finally {
			JDBCUtils.close();
		}
	}

	public void deleteSubjectType(int SubjectTypeId) {
		Connection connection = JDBCUtils.getConnection();
		String sql = "delete from SubjectType where SubjectType_id = ?";
		try {
			connection.setAutoCommit(false);
			SubjectTypeDao.deleteSubjectType(connection, sql, SubjectTypeId);
			connection.commit();
		} catch (SQLException e) {
			if(connection!=null) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			e.printStackTrace();
		}finally {
			JDBCUtils.close();
		}
		
	}

	public void updateSubjectType(int SubjectTypeId, String SubjectTypeName, int status) {
		Connection connection = JDBCUtils.getConnection();
		String sql = "update SubjectType set SubjectType_name =? , status = ? where SubjectType_id = ?";
		try {
			connection.setAutoCommit(false);
			SubjectTypeDao.updateSubjectType(connection, sql, SubjectTypeName,status,SubjectTypeId);
			connection.commit();
		} catch (SQLException e) {
			if(connection!=null) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			e.printStackTrace();
		}finally {
			JDBCUtils.close();
		}
		
	}

	public SubjectType getSubjectType(int SubjectTypeId) {
		Connection connection = JDBCUtils.getConnection();
		String sql = "select subject_type_id as subjectTypeId,subject_type_name as subjectTypeName from subject_type where subject_type_id = ?";
		try {
			connection.setAutoCommit(false);
			SubjectType SubjectType = SubjectTypeDao.getSubjectType(connection, sql, SubjectType.class, SubjectTypeId);
			connection.commit();
			return SubjectType;
		} catch (SQLException e) {
			if(connection!=null) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			e.printStackTrace();
		}finally {
			JDBCUtils.close();
		}
		return null;
	}

	public List<SubjectType> getSubjectTypeList() {
		Connection connection = JDBCUtils.getConnection();
		String sql = "select subject_type_id as subjectTypeId,subject_type_name as subjectTypeName from subject_type";
		try {
			connection.setAutoCommit(false);
			List<SubjectType> SubjectTypeList = SubjectTypeDao.getSubjectTypeList(connection, sql, SubjectType.class);
			return SubjectTypeList;
		} catch (SQLException e) {
			if(connection!=null) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			e.printStackTrace();
		}finally {
			JDBCUtils.close();
		}
		return null;
	}
	public Page getSubjectTypePage(Integer pageNo, Integer pageSize) {
		Page page = new Page();
        Connection connection = null;
        try {
            connection = JDBCUtils.getConnection();
            connection.setAutoCommit(false);
            String sql = "select SubjectType_id as SubjectTypeId,SubjectType_name as SubjectTypeName,status from SubjectType LIMIT ?,?";
            List<SubjectType> SubjectTypeList = SubjectTypeDao.getSubjectTypeList(connection, sql, SubjectType.class, (pageNo - 1) * pageSize,pageSize);
            page.setPage(SubjectTypeList);
            page.setPageNo(pageNo);
            page.setPageSize(pageSize);
            Long count = SubjectTypeDao.getSubjectTypeCount(connection, "SELECT COUNT(*) AS count FROM SubjectType");
            page.setCount(count);
            int pageCount = (int) (count % pageSize == 0 ? count / pageSize : count / pageSize + 1);
            page.setPageCount(pageCount);
            page.setHasPre(pageNo > 1);
            page.setHasNext(pageNo < pageCount);


            connection.commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils.close();
        }


        return page;
	}

}
