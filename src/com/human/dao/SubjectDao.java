package com.human.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.human.dto.SubjectDto;
import com.human.util.DBConn;

public class SubjectDao {
	public ArrayList<SubjectDto> selectAll() {
		ArrayList<SubjectDto> resultDtos = new ArrayList<SubjectDto>();
		ResultSet rs = DBConn.statementQuery(String.format("select * from subject"));
		try {
			while(rs.next()) {
				resultDtos.add(new SubjectDto(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultDtos;
	}
	
	public ArrayList<SubjectDto> selectNo(int sub_no) {
		ArrayList<SubjectDto> resultDtos = new ArrayList<SubjectDto>();
		ResultSet rs = DBConn.statementQuery(String.format("select * from subject where sub_no = %d", sub_no));
		if(rs != null) {
			try {
				while(rs.next()) {
					resultDtos.add(new SubjectDto(rs.getInt(1), rs.getString(2), rs.getString(3)));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return resultDtos;
	}
	
	public SubjectDto selectName(String sub_name) {
		SubjectDto resultDtos = new SubjectDto();
		ResultSet rs = DBConn.statementQuery(String.format("select * from subject where sub_name = '%s'", sub_name));
		if(rs != null) {
			try {
				while(rs.next()) {
					resultDtos = new SubjectDto(rs.getInt(1), rs.getString(2), rs.getString(3));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return resultDtos;
	}
	
	public void insert(SubjectDto dto) {
		String sql = String.format("insert into subject values(%d, '%s', '%s')", dto.getSub_no(), dto.getSub_name(), dto.getSub_cont());
		DBConn.statementUpdate(sql);
		System.out.println("[입력 완료]");
	}
	
	public void update(int sub_no, String sub_cont) {
		DBConn.statementUpdate(String.format("update subject set sub_cont = '%s' where sub_no = %d", sub_cont, sub_no));
		System.out.println("[수정 완료]");
	}
	
	public void delete(int sub_no) {
		DBConn.statementUpdate(String.format("delete subject where sub_no = %d", sub_no));
		System.out.println("[삭제 완료]");
	}
}
