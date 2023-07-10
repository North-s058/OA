package com.neo.service;

import java.util.List;

import com.neo.dto.Page;
import com.neo.entity.Role;

public interface RoleService {
	public void addRole(String roleName,int status);
	public void deleteRole(int roleId);
	public void updateRole(int roleId,String roleName,int status);
	public Role getRole(int roleId);
	public List<Role> getRoleList();
	//��ҳ����
	//ҳ����ҳ����
	Page getRolePage(Integer pageNo,Integer pageSize);
}
