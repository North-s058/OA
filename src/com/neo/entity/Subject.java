package com.neo.entity;

import java.util.Date;

public class Subject {
	private int subjectId;
	private String subjectName;
	private int subjectLife;
	private Date createTime;
	private int subjectTypeId;
	private SubjectType subjectType;
	public SubjectType getSubjectType() {
		return subjectType;
	}
	public void setSubjectType(SubjectType subjectType) {
		this.subjectType = subjectType;
	}
	public Subject() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Subject(int subjectId, String subjectName, int subjectLife, Date createTime, int subjectTypeId) {
		super();
		this.subjectId = subjectId;
		this.subjectName = subjectName;
		this.subjectLife = subjectLife;
		this.createTime = createTime;
		this.subjectTypeId = subjectTypeId;
	}
	@Override
	public String toString() {
		return "Subject [subjectId=" + subjectId + ", subjectName=" + subjectName + ", subjectLife=" + subjectLife
				+ ", createTime=" + createTime + ", subjectTypeId=" + subjectTypeId + ", subjectType=" + subjectType
				+ "]";
	}
	public int getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public int getSubjectLife() {
		return subjectLife;
	}
	public void setSubjectLife(int subjectLife) {
		this.subjectLife = subjectLife;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public int getSubjectTypeId() {
		return subjectTypeId;
	}
	public void setSubjectTypeId(int subjectTypeId) {
		this.subjectTypeId = subjectTypeId;
	}
	
}
