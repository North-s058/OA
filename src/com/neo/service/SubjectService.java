package com.neo.service;

import java.util.Date;
import java.util.List;

import com.neo.dto.Page;
import com.neo.entity.Subject;

public interface SubjectService {
	public void addSubject(String subjectName, int subjectLife, Date createTime,int subjectTypeId );
	public void deleteSubject(int SubjectId);
	public void updateSubject(int SubjectId,String SubjectName,int status);
	public Subject getSubject(Integer subjectId);
	public List<Subject> getSubjectList();
	Page getSubjectPage(int pageNo,int pageSize);
}
