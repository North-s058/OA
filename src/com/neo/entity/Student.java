package com.neo.entity;

import java.util.Date;

public class Student {
		private Integer studentId;
		private String studentName;
		private Integer classId;
		private Integer empId;
		private String gender;
		private String phone;
		private String idCard;
		private String graduateSchool;
		@Override
		public String toString() {
			return "Student [studentId=" + studentId + ", studentName=" + studentName + ", classId=" + classId
					+ ", empId=" + empId + ", gender=" + gender + ", phone=" + phone + ", idCard=" + idCard
					+ ", graduateSchool=" + graduateSchool + ", educationId=" + educationId + ", tuition=" + tuition
					+ ", admissionTime=" + admissionTime + ", education=" + education + ", clase=" + clase
					+ ", employee=" + employee + "]";
		}
		private Integer educationId;
		private Double tuition;
		private Date admissionTime;
		private Education education;
		public Integer getStudentId() {
			return studentId;
		}
		public void setStudentId(Integer studentId) {
			this.studentId = studentId;
		}
		public String getStudentName() {
			return studentName;
		}
		public void setStudentName(String studentName) {
			this.studentName = studentName;
		}
		public Integer getClassId() {
			return classId;
		}
		public void setClassId(Integer classId) {
			this.classId = classId;
		}
		public Integer getEmpId() {
			return empId;
		}
		public void setEmpId(Integer empId) {
			this.empId = empId;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		public String getIdCard() {
			return idCard;
		}
		public void setIdCard(String idCard) {
			this.idCard = idCard;
		}
		public String getGraduateSchool() {
			return graduateSchool;
		}
		public void setGraduateSchool(String graduateSchool) {
			this.graduateSchool = graduateSchool;
		}
		public Integer getEducationId() {
			return educationId;
		}
		public void setEducationId(Integer educationId) {
			this.educationId = educationId;
		}
		public Double getTuition() {
			return tuition;
		}
		public void setTuition(Double tuition) {
			this.tuition = tuition;
		}
		public Date getAdmissionTime() {
			return admissionTime;
		}
		public void setAdmissionTime(Date admissionTime) {
			this.admissionTime = admissionTime;
		}
		public Education getEducation() {
			return education;
		}
		public void setEducation(Education education) {
			this.education = education;
		}
		public Clase getClase() {
			return clase;
		}
		public void setClase(Clase clase) {
			this.clase = clase;
		}
		public Employee getEmployee() {
			return employee;
		}
		public void setEmployee(Employee employee) {
			this.employee = employee;
		}
		private Clase clase;
		private Employee employee;
}
