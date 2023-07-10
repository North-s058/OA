package com.neo.entity;

public class SubjectType {
	private int subjectTypeId;
	private String subjectTypeName;
	public SubjectType() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SubjectType(int subjectTypeId, String subjectTypeName) {
		super();
		this.subjectTypeId = subjectTypeId;
		this.subjectTypeName = subjectTypeName;
	}
	@Override
	public String toString() {
		return "SubjectType [subjectTypeId=" + subjectTypeId + ", subjectTypeName=" + subjectTypeName + "]";
	}
	public int getSubjectTypeId() {
		return subjectTypeId;
	}
	public void setSubjectTypeId(int subjectTypeId) {
		this.subjectTypeId = subjectTypeId;
	}
	public String getSubjectTypeName() {
		return subjectTypeName;
	}
	public void setSubjectTypeName(String subjectTypeName) {
		this.subjectTypeName = subjectTypeName;
	}
	
}
