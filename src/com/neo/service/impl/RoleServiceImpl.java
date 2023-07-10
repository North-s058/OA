package com.neo.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.neo.dao.BaseDao;
import com.neo.dao.RoleDao;
import com.neo.dao.imple.RoleDaoImpl;
import com.neo.dto.Page;
import com.neo.entity.Department;
import com.neo.entity.Employee;
import com.neo.entity.Role;
import com.neo.service.RoleService;
import com.neo.utils.JDBCUtils;

public class RoleServiceImpl implements RoleService{
	private RoleDao roleDao = new RoleDaoImpl();
	public void addRole(String roleName, int status) {
		Connection connection = JDBCUtils.getConnection();
		String sql = "insert into role (role_name,status) values (?,?)";
		try {
			connection.setAutoCommit(false);
			roleDao.addRole(connection, sql, roleName,status);
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

	public void deleteRole(int roleId) {
		Connection connection = JDBCUtils.getConnection();
		String sql = "delete from role where role_id = ?";
		try {
			connection.setAutoCommit(false);
			roleDao.deleteRole(connection, sql, roleId);
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

	public void updateRole(int roleId, String roleName, int status) {
		Connection connection = JDBCUtils.getConnection();
		String sql = "update role set role_name =? , status = ? where role_id = ?";
		try {
			connection.setAutoCommit(false);
			roleDao.updateRole(connection, sql, roleName,status,roleId);
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

	public Role getRole(int roleId) {
		Connection connection = JDBCUtils.getConnection();
		String sql = "select role_id as roleId,role_name as roleName,status from role where role_id = ?";
		try {
			connection.setAutoCommit(false);
			Role role = roleDao.getRole(connection, sql, Role.class, roleId);
			connection.commit();
			return role;
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

	public List<Role> getRoleList() {
		Connection connection = JDBCUtils.getConnection();
		String sql = "select role_id as roleId,role_name as roleName,status from role";
		try {
			connection.setAutoCommit(false);
			List<Role> roleList = roleDao.getRoleList(connection, sql, Role.class);
			return roleList;
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
	public Page getRolePage(Integer pageNo, Integer pageSize) {
		Page page = new Page();
        Connection connection = null;
        try {
            connection = JDBCUtils.getConnection();
            connection.setAutoCommit(false);
            String sql = "select role_id as roleId,role_name as roleName,status from role LIMIT ?,?";
            List<Role> roleList = roleDao.getRoleList(connection, sql, Role.class, (pageNo - 1) * pageSize,pageSize);
            page.setPage(roleList);
            page.setPageNo(pageNo);
            page.setPageSize(pageSize);
            Long count = roleDao.getRoleCount(connection, "SELECT COUNT(*) AS count FROM role");
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
