package com.neo.service;

import java.util.Date;
import java.util.List;

import com.neo.dto.Page;
import com.neo.entity.Employee;

public interface EmpService {
	public void addEmp(String empName,int deptId,int roleId,int gender,int managerId,String phone,String password,String email,Date hireTime);
	public void deleteEmp(int empId);
	public void updateEmp(int empId,String empName,int deptId,int roleId,int gender,int managerId,String phone,String password,String email,Date hireTime);
	public Employee getEmp(int empId);
	public List<Employee> getEmpList();
	Page getEmpPage(Integer pageNo,Integer pageSize);
}
