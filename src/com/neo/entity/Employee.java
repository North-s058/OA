package com.neo.entity;

import java.util.Date;

public class Employee {
	private int empId;
	private String empName;
	private int deptId;
	private int roleId;
	private Integer managerId;
	private int gender;
	private String phone;
	private String password;
	private String email;
	private Date hireTime;
	private Department dept;
	private Role role;
	public Department getDept() {
		return dept;
	}
	public void setDept(Department dept) {
		this.dept = dept;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public Integer getManagerId() {
		return managerId;
	}
	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getHireTime() {
		return hireTime;
	}
	public void setHireTime(Date hireTime) {
		this.hireTime = hireTime;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", deptId=" + deptId + ", roleId=" + roleId
				+ ", managerId=" + managerId + ", gender=" + gender + ", phone=" + phone + ", password=" + password
				+ ", email=" + email + ", hireTime=" + hireTime + ", dept=" + dept + ", role=" + role + "]";
	}
	
}
