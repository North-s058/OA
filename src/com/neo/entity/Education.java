package com.neo.entity;

public class Education {
	private Integer educationId;
	private String educationName;
	public Education() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Education [educationId=" + educationId + ", educationName=" + educationName + "]";
	}
	public Integer getEducationId() {
		return educationId;
	}
	public void setEducationId(Integer educationId) {
		this.educationId = educationId;
	}
	public String getEducationName() {
		return educationName;
	}
	public void setEducationName(String educationName) {
		this.educationName = educationName;
	}
	
}
