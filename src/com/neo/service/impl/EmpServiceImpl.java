package com.neo.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.neo.dao.EmpDao;
import com.neo.dao.imple.EmpDaoImpl;
import com.neo.dto.Page;
import com.neo.entity.Clase;
import com.neo.entity.Department;
import com.neo.entity.Employee;
import com.neo.entity.Role;
import com.neo.service.EmpService;
import com.neo.utils.JDBCUtils;

public class EmpServiceImpl implements EmpService{
	private EmpDao empDao = new EmpDaoImpl();
	public void addEmp(String empName, int deptId, int roleId, int gender, int managerId, String phone, String password,
			String email, Date hireTime) {
		Connection connection = JDBCUtils.getConnection();
		try {
			connection.setAutoCommit(false);
			String sql = "insert into employee (emp_name,dept_id,role_id,gender,manager_id,phone,password,email,hire_time)"
					+ "values(?,?,?,?,?,?,?,?,?)";
			empDao.addEmp(connection, sql, empName,deptId,roleId,gender,managerId,phone,password,email,hireTime);
			connection.commit();
		}catch (Exception e) {
			if(connection!=null)
				try {
					connection.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		}finally {
			JDBCUtils.close();
		}
		
	}

	public void deleteEmp(int empId) {
		Connection connection = JDBCUtils.getConnection();
		try {
			connection.setAutoCommit(false);
			String sql = "delete from employee where emp_id = ?";
			empDao.deleteEmp(connection, sql,empId);
			connection.commit();
		}catch (Exception e) {
			if(connection!=null)
				try {
					connection.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		}finally {
			JDBCUtils.close();
		}
		
	}

	public void updateEmp(int empId, String empName, int deptId, int roleId, int gender, int managerId, String phone,
			String password, String email, Date hireTime) {
		Connection connection = JDBCUtils.getConnection();
		try {
			connection.setAutoCommit(false);
			String sql = "update employee emp_name= ? ,dept_id=? , role_id=?,gender=?,manager_id=?,phone=?,password=?,email=?,hire_time=? where emp_id =?)"
					+ "values(?,?,?,?,?,?,?,?,?)";
			empDao.updateEmp(connection, sql, empName,deptId,roleId,gender,managerId,phone,password,email,hireTime,empId);
			connection.commit();
		}catch (Exception e) {
			if(connection!=null)
				try {
					connection.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		}finally {
			JDBCUtils.close();
		}
		
	}

	public Employee getEmp(int empId) {
		Connection connection = JDBCUtils.getConnection();
		try {
			connection.setAutoCommit(false);
			String sql = "select emp_id as empId,emp_name as empName,role_id as roleId,gender,manager_id as managerId,phone,password,email,hire_time as hireTime from employee where emp_id =? ";
			Employee emp = empDao.getEmp(connection, sql,Employee.class,empId);
			connection.commit();
			return emp;
		}catch (Exception e) {
			if(connection!=null)
				try {
					connection.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		}finally {
			JDBCUtils.close();
		}
		return null;
	}

	public List<Employee> getEmpList() {
		Connection connection = JDBCUtils.getConnection();
		try {
			connection.setAutoCommit(false);
			String sql = "select emp_id as empId,emp_name as empName,dept_id as deptId,role_id as roleId,gender,manager_id as managerId,phone,password,email,hire_time as hireTime from employee";
			List<Employee> empList = empDao.getEmpList(connection, sql,Employee.class);
			connection.commit();
			return empList;
		}catch (Exception e) {
			e.printStackTrace();
			if(connection!=null)
				try {
					connection.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		}finally {
			JDBCUtils.close();
		}
		return null;
	}

	public Page getEmpPage(Integer pageNo, Integer pageSize) {
		Page page = new Page();
        Connection connection = null;
        try {
            connection = JDBCUtils.getConnection();
            connection.setAutoCommit(false);
            String sql = "select emp_id as empId,emp_name as empName,dept_id as deptId,role_id as roleId,gender,manager_id as managerId,phone,password,email,hire_time as hireTime from employee  LIMIT ?,?";
            List<Employee> empList = empDao.getEmpList(connection, sql, Employee.class, (pageNo - 1) * pageSize,pageSize);
            for (Employee employee : empList) {
				int deptId = employee.getDeptId();
				Department dept = new DeptServiceImpl().getDept(deptId);
				employee.setDept(dept);
				int roleId = employee.getRoleId();
				Role role = new RoleServiceImpl().getRole(roleId);
				employee.setRole(role);
				
			}
            page.setPage(empList);
            page.setPageNo(pageNo);
            page.setPageSize(pageSize);
            Long count = empDao.getEmpCount(connection, "SELECT COUNT(*) AS count FROM employee");
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
