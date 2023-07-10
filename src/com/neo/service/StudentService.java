package com.neo.service;

import java.util.List;

import com.neo.dao.StudentDao;
import com.neo.dao.imple.StudentDaoImpl;
import com.neo.dto.Page;
import com.neo.entity.Student;

public interface StudentService {
	public void addStudent(Student student);
	public void deleteStudent(Integer studentId);
	public void updateStudent(Student student);
	public Student getStudent(Integer studentId);
	public List<Student> getStudentList();
	public Page getStudentPage(Integer pageNo,Integer pageSize);
	
}
