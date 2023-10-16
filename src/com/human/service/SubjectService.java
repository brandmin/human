package com.human.service;

import java.util.ArrayList;

import com.human.dao.RegisterDao;
import com.human.dao.SubjectDao;
import com.human.dto.SubjectDto;

public class SubjectService {
	private SubjectDao dao = new SubjectDao();
	private RegisterDao rDao = new RegisterDao();
	public void insert(SubjectDto dto) {
		dao.insert(dto);
	}
	
	public ArrayList<SubjectDto> selectAll() {
		return dao.selectAll();
	}
	
	public SubjectDto selectName(String sub_name) {
		return dao.selectName(sub_name);
	}
	
	public ArrayList<SubjectDto> selectNo(int sub_no) {
		return dao.selectNo(sub_no);
	}
	
	public void update(int sub_no, String sub_cont) {
		dao.update(sub_no, sub_cont);
	}
	
	public void delete(int sub_no) {
		rDao.delete(sub_no);
		dao.delete(sub_no);
	}
}
