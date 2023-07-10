package com.neo.service;

import java.util.List;

import com.neo.entity.Education;

public interface EducationService {
	public Education getEducation(Integer educationId);
	public List<Education> getEducationList();
}
