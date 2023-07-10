package com.neo.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.neo.dao.DepartmentDao;
import com.neo.dao.imple.DepartmentDaoImpl;
import com.neo.dto.Page;
import com.neo.entity.Department;
import com.neo.entity.Role;
import com.neo.service.DepartmentService;
import com.neo.utils.JDBCUtils;

public class DeptServiceImpl implements DepartmentService{
	private DepartmentDao deptDao = new DepartmentDaoImpl();
	public void addDept(String deptName,Date createTime) {
		Connection connection = JDBCUtils.getConnection();
		try {
			connection.setAutoCommit(false);
			String sql = "insert into department (dept_name,create_time) values(?,?)";
			deptDao.addDept(connection, sql, deptName,createTime);
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCUtils.close();
		}
	}

	public void deleteDept(int deptId) {
		Connection connection = JDBCUtils.getConnection();
		try {
			connection.setAutoCommit(false);
			String sql = "delete from department where dept_id = ?";
			deptDao.deleteDept(connection, sql, deptId);
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCUtils.close();
		}
		
	}

	public void updateDept(String deptName, Date createTime, int deptId) {
		Connection connection = JDBCUtils.getConnection();
		try {
			connection.setAutoCommit(false);
			String sql = "update department set dept_name = ?,create_time = ? where dept_id = ?";
			deptDao.updateDept(connection, sql, deptName,createTime,deptId);
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCUtils.close();
		}
		
	}

	public Department getDept(int deptId) {
		Connection connection = JDBCUtils.getConnection();
		try {
			connection.setAutoCommit(false);
			String sql = "select dept_id as deptId,dept_name as deptName,create_time as createTime from department where dept_id = ?";
			Department dept = deptDao.getDept(connection, sql, Department.class, deptId);
			connection.commit();
			return dept;
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

	public List<Department> getDeptList() {
		Connection connection = JDBCUtils.getConnection();
		try {
			connection.setAutoCommit(false);
			String sql = "select dept_id as deptId ,dept_name as deptName,create_time as createTime from department";
			List<Department> deptList = deptDao.getDeptList(connection, sql, Department.class);
			connection.commit();
			return deptList;
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

	public Page getDeptPage(Integer pageNo, Integer pageSize) {
		Page page = new Page();
        Connection connection = null;
        try {
            connection = JDBCUtils.getConnection();
            connection.setAutoCommit(false);
            String sql = "select dept_id as deptId,dept_name as deptName,create_time as createTime from department LIMIT ?,?";
            List<Department> deptList = deptDao.getDeptList(connection, sql, Department.class, (pageNo - 1) * pageSize,pageSize);
            page.setPage(deptList);
            page.setPageNo(pageNo);
            page.setPageSize(pageSize);
            Long count = deptDao.getDeptCount(connection, "SELECT COUNT(*) AS count FROM department");
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
