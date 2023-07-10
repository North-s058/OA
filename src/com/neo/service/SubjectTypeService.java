package com.neo.service;

import java.util.List;

import com.neo.dto.Page;
import com.neo.entity.SubjectType;

public interface SubjectTypeService {
	public void addSubjectType(String SubjectTypeName,int status);
	public void deleteSubjectType(int SubjectTypeId);
	public void updateSubjectType(int SubjectTypeId,String SubjectTypeName,int status);
	public SubjectType getSubjectType(int SubjectTypeId);
	public List<SubjectType> getSubjectTypeList();
	Page getSubjectTypePage(Integer pageNo,Integer pageSize);
}
