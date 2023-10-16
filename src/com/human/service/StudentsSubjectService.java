package com.human.service;
import java.util.ArrayList;
import com.human.dao.*;
import com.human.dto.*;

public class StudentsSubjectService {
	public StudentsDao s = new StudentsDao();
	public RegisterDao r = new RegisterDao();
	public SubjectDao sub = new SubjectDao();
	
	
	public void insertDB(StudentsSubjectDto dto) {
		s.insert(dto.toStudentsDto());
		String stu_id = dto.getStu_id();
		for(RegisterDto rDto : dto.getRegisters()) {
			rDto.setStu_id(stu_id);
			r.insert(rDto);
		}
	}
	public ArrayList<StudentsSubjectDto> selectAll() {
		ArrayList<StudentsSubjectDto> ssDto = new ArrayList<StudentsSubjectDto>();
		ArrayList<StudentsDto> sDto = new ArrayList<StudentsDto>();
		sDto = s.selectAll();
		
		for(StudentsDto dto : sDto) {
			ArrayList<RegisterDto> regi = r.selectId(dto.getStu_id());
					
			ssDto.add(new StudentsSubjectDto(
					dto.getStu_id(),
					dto.getStu_name(),
					dto.getPhone_no(),
					regi
					));
		}
		return ssDto;
	}
	
	public void update(String stu_id, int sub_no, String grade) {
		r.update(sub_no, stu_id, grade);
	}
	
	public void deleteSubject(int sub_no, String stu_id) {
		r.delete(sub_no, stu_id);
	}
	
	public void deleteStudents(String stu_id) {
		r.delete(stu_id);
		s.delete(stu_id);
	}
}
