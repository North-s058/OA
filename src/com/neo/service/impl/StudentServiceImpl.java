package com.neo.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.neo.dao.StudentDao;
import com.neo.dao.imple.StudentDaoImpl;
import com.neo.dto.Page;
import com.neo.entity.Clase;
import com.neo.entity.Education;
import com.neo.entity.Employee;
import com.neo.entity.Student;
import com.neo.entity.Subject;
import com.neo.service.StudentService;
import com.neo.utils.JDBCUtils;

public class StudentServiceImpl implements StudentService{
	private StudentDao studentDao = new StudentDaoImpl();

	public void addStudent(Student student) {
		Connection connection = JDBCUtils.getConnection();
		try {
			connection.setAutoCommit(false);
			String sql = "insert into student (student_name,class_Id,gender,phone,id_card,graduate_school,education_id,admission_time,emp_id) values(?,?,?,?,?,?,?,?,?)";
			studentDao.addStudent(connection, sql, student.getStudentName(),student.getClassId(),student.getGender(),student.getPhone(),student.getIdCard(),student.getGraduateSchool(),student.getEducationId(),student.getAdmissionTime(),student.getEmpId());
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

	public void deleteStudent(Integer studentId) {
		Connection connection = JDBCUtils.getConnection();
		try {
			connection.setAutoCommit(false);
			String sql = "delete from student where student_id = ?";
			studentDao.deleteStudent(connection, sql, studentId);
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

	public void updateStudent(Student student) {
		Connection connection = JDBCUtils.getConnection();
		try {
			connection.setAutoCommit(false);
			String sql = "update student set class_id = ?,emp_id = ?,student_name = ?,gender=?,phone=?,id_card = ?,graduate_school = ?,education_id = ?,admission_time=? where student_id = ?";
			studentDao.updateStudent(connection, sql, student.getClassId(),student.getEmpId(),student.getStudentName(),student.getGender(),student.getPhone(),student.getIdCard(),student.getGraduateSchool(),student.getEducationId(),student.getAdmissionTime(),student.getStudentId());
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

	public Student getStudent(Integer studentId) {
		Connection connection = JDBCUtils.getConnection();
		try {
			connection.setAutoCommit(false);
			String sql = "select student_id as studentId,student_name as studentName,class_id as classId,emp_id as empId,gender,phone,id_card as idCard,graduate_school as graduateSchool,education_id as educationId,tuition,admission_time as admissionTime from student where student_id = ?";
			Student student = studentDao.getStudent(connection, sql, Student.class, studentId);
			connection.commit();
			return student;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			if(connection!=null) {
				try {
					connection.close();
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

	public List<Student> getStudentList() {
		// TODO Auto-generated method stub
		return null;
	}

	public Page getStudentPage(Integer pageNo, Integer pageSize) {
		Page page = new Page();
        Connection connection = null;
        try {
            connection = JDBCUtils.getConnection();
            connection.setAutoCommit(false);
            String sql = "select student_id as studentId,student_name as studentName,class_id as classId,emp_id as empId,gender,phone,id_card as idCard,graduate_school as graduateSchool,education_id as educationId,tuition,admission_time as admissionTime from student  LIMIT ?,?";
            List<Student> studentList = studentDao.getStudentList(connection, sql, Student.class, (pageNo - 1) * pageSize,pageSize);
            for (Student student : studentList) {
            	Integer empId = student.getEmpId();
            	Employee emp = new EmpServiceImpl().getEmp(empId);
            	student.setEmployee(emp);
				Integer claseId = student.getClassId();
				Clase clase = new ClaseServiceImpl().getClase(claseId);
				student.setClase(clase);
				Integer educationId = student.getEducationId();
				Education education = new EducationServiceImpl().getEducation(educationId);
				student.setEducation(education);
			}
            page.setPage(studentList);
            page.setPageNo(pageNo);
            page.setPageSize(pageSize);
            Long count = studentDao.getStudentCount(connection, "SELECT COUNT(*) AS count FROM Student");
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
	
}
