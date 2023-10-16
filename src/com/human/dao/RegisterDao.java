package com.human.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.human.dto.AllDto;
import com.human.dto.RegisterDto;
import com.human.util.DBConn;

public class RegisterDao {
	public ArrayList<AllDto> selectAllStudentsAndSubject() {
		ArrayList<AllDto> resultDtos = new ArrayList<AllDto>();
		ResultSet rs = DBConn.statementQuery(String.format("select students.stu_id, students.stu_name,"
				+ " subject.sub_no, subject.sub_name, register.grade from students inner join register on students.stu_id = register.stu_id"
				+ " left join subject on subject.sub_no = register.sub_no"));
		try {
			while(rs.next()) {
				resultDtos.add(new AllDto(rs.getString("stu_id"), rs.getString("stu_name"), rs.getInt("sub_no"), rs.getString("sub_name"), rs.getString("grade")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultDtos;
	}
	
	public ArrayList<RegisterDto> selectAll() {
		ArrayList<RegisterDto> resultDtos = new ArrayList<RegisterDto>();
		ResultSet rs = DBConn.statementQuery(String.format("select * from register"));
		try {
			while(rs.next()) {
				resultDtos.add(new RegisterDto(rs.getString(1), rs.getInt(2), rs.getString(3)));
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return resultDtos;
	}
	
	public ArrayList<RegisterDto> selectId(String stu_id) {
		ArrayList<RegisterDto> resultDtos = new ArrayList<RegisterDto>();
		ResultSet rs = DBConn.statementQuery(String.format("select * from register where stu_id = '%s'", stu_id));
		if(rs != null) {
			try {
				while(rs.next()) {
				resultDtos.add(new RegisterDto(rs.getString(1), rs.getInt(2), rs.getString(3)));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return resultDtos;
	}
	
	public void insert(RegisterDto dto) {
		String sql = String.format("insert into register values('%s',%d,'%s')", dto.getStu_id(), dto.getSub_no(), dto.getGrade());
		DBConn.statementUpdate(sql);
		System.out.println("[입력 완료]");
	}
	
	public void update(int sub_no, String stu_id, String grade) {
		DBConn.statementUpdate(String.format("update register set grade = '%s' where stu_id = '%s' and sub_no = %d", grade, stu_id, sub_no));
		System.out.println("[수정 완료]");
	}
	
	public void delete(String stu_id) {
		DBConn.statementUpdate(String.format("delete register where stu_id = '%s'", stu_id));
	}
	
	public void delete(int sub_no) {
		DBConn.statementUpdate(String.format("delete register where sub_no = %d", sub_no));
	}
	
	public void delete(int sub_no, String stu_id) {
		DBConn.statementUpdate(String.format("delete register where sub_no = %d and stu_id = '%s'", sub_no, stu_id));
	}
}
