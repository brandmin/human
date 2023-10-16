package com.human.service;

import java.util.ArrayList;

import com.human.dao.RegisterDao;
import com.human.dao.StudentsDao;
import com.human.dao.SubjectDao;
import com.human.dto.AllDto;
import com.human.dto.RegisterDto;

public class RegisterService {
	public StudentsDao s = new StudentsDao();
	public SubjectDao sub = new SubjectDao();
	public RegisterDao r = new RegisterDao();
	
	public void insert(RegisterDto dto) {
		r.insert(dto);
	}
	
	public void update(String grade,int sub_no, String stu_id) {
		r.update(sub_no, stu_id, grade);
	}
	
	public ArrayList<AllDto> selectAllStudentsAndSubject() {
		return r.selectAllStudentsAndSubject();
	}
	
	public ArrayList<RegisterDto> selectAll() {
		return r.selectAll();
	}
	
	public ArrayList<RegisterDto> selectId(String stu_id) {
		return r.selectId(stu_id);
	}
}
