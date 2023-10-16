package com.human.dto;

import java.util.Objects;

public class RegisterDto {
	private String stu_id;
	private int sub_no;
	private String grade;
	
	public RegisterDto() {}

	public RegisterDto(String stu_id, int sub_no, String grade) {
		super();
		this.stu_id = stu_id;
		this.sub_no = sub_no;
		this.grade = grade;
	}

	@Override
	public int hashCode() {
		return Objects.hash(grade, stu_id, sub_no);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RegisterDto other = (RegisterDto) obj;
		return Objects.equals(grade, other.grade) && Objects.equals(stu_id, other.stu_id) && sub_no == other.sub_no;
	}

	public String getStu_id() {
		return stu_id;
	}

	public void setStu_id(String stu_id) {
		this.stu_id = stu_id;
	}

	public int getSub_no() {
		return sub_no;
	}

	public void setSub_no(int sub_no) {
		this.sub_no = sub_no;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "RegisterDto [stu_id=" + stu_id + ", sub_no=" + sub_no + ", grade=" + grade + "]";
	}
	
	
}
