package com.neo.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.neo.dao.BaseDao;
import com.neo.dao.SubjectDao;
import com.neo.dao.imple.SubjectDaoImpl;
import com.neo.dto.Page;
import com.neo.entity.Department;
import com.neo.entity.Employee;
import com.neo.entity.Subject;
import com.neo.entity.SubjectType;
import com.neo.service.SubjectService;
import com.neo.utils.JDBCUtils;

public class SubjectServiceImpl implements SubjectService{
	private SubjectDao SubjectDao = new SubjectDaoImpl();
	public void addSubject(String subjectName, int subjectLife, Date createTime,int subjectTypeId ) {
		Connection connection = JDBCUtils.getConnection();
		String sql = "insert into Subject (subject_name,subject_life,create_time,subject_type_id) values (?,?,?,?)";
		try {
			connection.setAutoCommit(false);
			SubjectDao.addSubject(connection, sql, subjectName,subjectLife,createTime,subjectTypeId);
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

	public void deleteSubject(int subjectId) {
		Connection connection = JDBCUtils.getConnection();
		String sql = "delete from Subject where Subject_id = ?";
		try {
			connection.setAutoCommit(false);
			SubjectDao.deleteSubject(connection, sql, subjectId);
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

	public void updateSubject(int subjectId, String subjectName, Date createTime, int subjectLife) {
		Connection connection = JDBCUtils.getConnection();
		String sql = "update Subject set subject_name =? , subject_life = ?,create_time = ? where subject_id = ?";
		try {
			connection.setAutoCommit(false);
			SubjectDao.updateSubject(connection, sql, subjectName,subjectLife,createTime,subjectId);
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

	public Subject getSubject(Integer subjectId) {
		Connection connection = JDBCUtils.getConnection();
		String sql = "select subject_id as subjectId,subject_name as subjectName,create_time as createTime,subject_life as subjectLife, subject_type_id as subjectTypeId from subject where subject_id = ?";
		try {
			connection.setAutoCommit(false);
			System.out.println(subjectId);
			Subject subject = SubjectDao.getSubject(connection, sql, Subject.class, subjectId);
			System.out.println(subject);
			connection.commit();
			return subject;
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

	public List<Subject> getSubjectList() {
		Connection connection = JDBCUtils.getConnection();
		String sql = "select subject_id as subjectId,subject_name as subjectName,subject_life as subjectLife,subject_type_id as subjectTypeId,create_time as createTime from Subject";
		try {
			connection.setAutoCommit(false);
			List<Subject> SubjectList = SubjectDao.getSubjectList(connection, sql, Subject.class);
			return SubjectList;
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
	public Page getSubjectPage(int pageNo, int pageSize) {
		Page page = new Page();
        Connection connection = null;
        try {
            connection = JDBCUtils.getConnection();
            connection.setAutoCommit(false);
            String sql = "select subject_id as subjectId,subject_name as subjectName,subject_life as subjectLife,subject_type_id as subjectTypeId,create_time as createTime from Subject LIMIT ?,?";
            List<Subject> subjectList = SubjectDao.getSubjectList(connection, sql, Subject.class, (pageNo - 1) * pageSize,pageSize);
            for (Subject subject : subjectList) {
				int subjectTypeId = subject.getSubjectTypeId();
				SubjectType subjectType = new SubjectTypeServiceImpl().getSubjectType(subjectTypeId);
				subject.setSubjectType(subjectType);
			}
            page.setPage(subjectList);
            page.setPageNo(pageNo);
            page.setPageSize(pageSize);
            Long count = SubjectDao.getSubjectCount(connection, "SELECT COUNT(*) AS count FROM Subject");
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

	public void updateSubject(int SubjectId, String SubjectName, int status) {
		// TODO Auto-generated method stub
		
	}



	

}
