package com.human.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.human.dto.StudentsDto;
import com.human.util.DBConn;

public class StudentsDao {
	public ArrayList<StudentsDto> selectAll() {
		ArrayList<StudentsDto> resultDtos = new ArrayList<StudentsDto>();
		ResultSet rs = DBConn.statementQuery(String.format("select * from students order by stu_id"));
		try {
			while(rs.next()) {
				resultDtos.add(new StudentsDto(rs.getString(1), rs.getString(2), rs.getString(3)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultDtos;
	}
	
	public StudentsDto selectId(String stu_id) {
		StudentsDto studentsDto = new StudentsDto();
		ResultSet rs = DBConn.statementQuery(String.format("select * from students where stu_id = '%s'", stu_id));
	
		if(rs != null) {
			try {
				rs.next();
				studentsDto = new StudentsDto(rs.getString(1), rs.getString(2), rs.getString(3));
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return studentsDto;
	}
	
	public void insert(StudentsDto dto) {
		String sql = String.format("insert into students values('%s','%s','%s')", dto.getStu_id(), dto.getStu_name(), dto.getPhone_no());
		DBConn.statementUpdate(sql);
		System.out.println("[입력 완료]");
	}
	
	public void update(String stu_id, String phone_no) {
		DBConn.statementQuery(String.format("update students set phone_no = '%s' where stu_id = '%s'", phone_no, stu_id));
		System.out.println("[수정 완료]");
	}
	
	public void delete(String stu_id) {
		DBConn.statementUpdate(String.format("delete students where stu_id = '%s'", stu_id));
		System.out.println("[삭제 완료]");
	}
}
