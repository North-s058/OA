package com.neo.service;

import java.util.Date;
import java.util.List;

import com.neo.dto.Page;
import com.neo.entity.Clase;

public interface ClaseService {
	public void addClase(String className, int subjectId,int classCount,int classLife,String classAddress,Date createTime);
	public void deleteClase(int ClaseId);
	public void updateClase(Clase clase);
	public Clase getClase(Integer ClaseId);
	public List<Clase> getClaseList();
	//分页函数
	//页数和页容量
	Page getClasePage(int pageNo,int pageSize);
}
