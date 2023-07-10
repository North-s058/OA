package com.neo.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.neo.dao.ClaseDao;
import com.neo.dao.imple.ClaseDaoImpl;
import com.neo.dto.Page;
import com.neo.entity.Clase;
import com.neo.entity.Subject;
import com.neo.service.ClaseService;
import com.neo.utils.JDBCUtils;

public class ClaseServiceImpl implements ClaseService{

	private ClaseDao claseDao = new ClaseDaoImpl();
	public void addClase(String className, int subjectId,int classCount,int classLife,String classAddress,Date createTime) {
		Connection connection = JDBCUtils.getConnection();
		String sql = "insert into Class (class_name,subject_id,class_count,class_life,class_address,create_time) values (?,?,?,?,?,?)";
		try {
			connection.setAutoCommit(false);
			claseDao.addClase(connection, sql, className,subjectId,classCount,classLife,classAddress,createTime);
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

	public void deleteClase(int ClaseId) {
		Connection connection = JDBCUtils.getConnection();
		String sql = "delete from class where class_id = ?";
		try {
			connection.setAutoCommit(false);
			claseDao.deleteClase(connection, sql, ClaseId);
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

	public void updateClase(Clase clase) {
		Connection connection = JDBCUtils.getConnection();
		String sql = "update Class set class_name = ?,subject_id = ?,class_count = ?,class_life =?,class_address =?,create_time = ? where class_id = ?";
		try {
			connection.setAutoCommit(false);
			claseDao.updateClase(connection, sql, clase.getClassName(),clase.getSubjectId(),clase.getClassCount(),clase.getClassLife(),clase.getClassAddress(),clase.getCreateTime(),clase.getClassId());
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

	public Clase getClase(int ClaseId) {
		Connection connection = JDBCUtils.getConnection();
		String sql = "select class_id as classId,class_name as className,subject_id as subjectId,class_count as classCount,class_life as classLife,class_address as classAddress,create_time as createTime from class where class_id = ?";
		try {
			connection.setAutoCommit(false);
			Clase clase = claseDao.getClase(connection, sql, Clase.class, ClaseId);
			connection.commit();
			return clase;
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

	public List<Clase> getClaseList() {
		Connection connection = JDBCUtils.getConnection();
		String sql = "select class_id as classId,class_name as className,subject_id as subjectId,class_count as classCount,class_life as classLife,class_address as classAddress,create_time as createTime from class";
		try {
			connection.setAutoCommit(false);
			List<Clase> claseList = claseDao.getClaseList(connection, sql, Clase.class);
			return claseList;
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
	public Page getClasePage(int pageNo, int pageSize) {
		Page page = new Page();
        Connection connection = null;
        try {
            connection = JDBCUtils.getConnection();
            connection.setAutoCommit(false);
            String sql = "select class_id as classId,class_name as className,subject_id as subjectId,class_count as classCount,class_life as classLife,class_address as classAddress,create_time as createTime from `class`  LIMIT ?,?";
            List<Clase> claseList = claseDao.getClaseList(connection, sql, Clase.class, (pageNo - 1) * pageSize,pageSize);
            for (Clase clase : claseList) {
            	Integer subjectId = clase.getSubjectId();
				Subject subject = new SubjectServiceImpl().getSubject(subjectId);
				clase.setSubject(subject);
			}
            page.setPage(claseList);
            page.setPageNo(pageNo);
            page.setPageSize(pageSize);
            Long count = claseDao.getClaseCount(connection, "SELECT COUNT(*) AS count FROM Class");
            page.setCount(count);
            int pageCount = (int) (count % pageSize == 0 ? count / pageSize : count / pageSize + 1);
            page.setPageCount(pageCount);
            page.setHasPre(pageNo > 1);
            page.setHasNext(pageNo < pageCount);


            connection.commit();
        } catch (Exception e) {
        	e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            JDBCUtils.close();
        }


        return page;
	}

	public Clase getClase(Integer ClaseId) {
		Connection connection = JDBCUtils.getConnection();
		String sql = "select class_id as classId,class_name as className,subject_id as subjectId,class_count as classCount,class_life as classLife,class_address as classAddress,create_time as createTime from class where class_id = ?";
		try {
			connection.setAutoCommit(false);
			Clase clase = claseDao.getClase(connection, sql, Clase.class, ClaseId);
			connection.commit();
			return clase;
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



	public Page getClasePage(Clase clase) {
		// TODO Auto-generated method stub
		return null;
	}



	




}
