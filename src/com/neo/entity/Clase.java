package com.neo.entity;

import java.util.Date;

public class Clase {
	private Integer classId;
	private String className;
	private Integer subjectId;
	private Integer classCount;
	private Integer classLife;
	private String classAddress;
	private Date createTime;
	private Subject subject;
	
	public Clase() {
	}
	public Subject getSubject() {
		return subject;
	}

	public Clase(Integer classId, String className, Integer subjectId, Integer classCount, Integer classLife,
			String classAddress, Date createTime, Subject subject) {
		super();
		this.classId = classId;
		this.className = className;
		this.subjectId = subjectId;
		this.classCount = classCount;
		this.classLife = classLife;
		this.classAddress = classAddress;
		this.createTime = createTime;
		this.subject = subject;
	}
	@Override
	public String toString() {
		return "Clase [classId=" + classId + ", className=" + className + ", subjectId=" + subjectId + ", classCount="
				+ classCount + ", classLife=" + classLife + ", classAddress=" + classAddress + ", createTime="
				+ createTime + ", subject=" + subject + "]";
	}
	public Integer getClassId() {
		return classId;
	}
	public void setClassId(Integer classId) {
		this.classId = classId;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public Integer getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
	}
	public Integer getClassCount() {
		return classCount;
	}
	public void setClassCount(Integer classCount) {
		this.classCount = classCount;
	}
	public Integer getClassLife() {
		return classLife;
	}
	public void setClassLife(Integer classLife) {
		this.classLife = classLife;
	}
	public String getClassAddress() {
		return classAddress;
	}
	public void setClassAddress(String classAddress) {
		this.classAddress = classAddress;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	
	
}
