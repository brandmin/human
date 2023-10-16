package com.human.service;

import java.util.ArrayList;

import com.human.dao.RegisterDao;
import com.human.dao.StudentsDao;
import com.human.dto.StudentsDto;

public class StudentsService {
	private StudentsDao dao = new StudentsDao();
	private RegisterDao rDao = new RegisterDao();
	public void insert(StudentsDto dto) {
		dao.insert(dto);
	}
	
	public ArrayList<StudentsDto> selectAll() {
		return dao.selectAll();
	}
	
	public StudentsDto selectId(String stu_id) {
		return dao.selectId(stu_id);
	}
	
	public void update(String stu_id, String phone_no) {
		dao.update(stu_id, phone_no);
	}
	
	public void delete(String stu_id) {
		rDao.delete(stu_id);
		dao.delete(stu_id);
	}
}
