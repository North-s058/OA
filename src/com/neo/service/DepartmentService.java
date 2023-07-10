package com.neo.service;

import java.util.Date;
import java.util.List;

import com.neo.dto.Page;
import com.neo.entity.Department;

public interface DepartmentService {
	public void addDept(String deptName,Date createTime);
	public void deleteDept(int deptId);
	public void updateDept(String deptName,Date createTime,int deptId);
	public Department getDept(int deptId);
	public List<Department> getDeptList();
	Page getDeptPage(Integer pageNo,Integer pageSize);
}
