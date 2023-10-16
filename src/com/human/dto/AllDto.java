package com.human.dto;

import java.util.Objects;

public class AllDto {
	private String stu_id;
	private String stu_name;
	private int sub_no;
	private String sub_name;
	private String grade;
	
	public AllDto() {}

	public AllDto(String stu_id, String stu_name, int sub_no, String sub_name, String grade) {
		super();
		this.stu_id = stu_id;
		this.stu_name = stu_name;
		this.sub_no = sub_no;
		this.sub_name = sub_name;
		this.grade = grade;
	}

	@Override
	public int hashCode() {
		return Objects.hash(grade, stu_id, stu_name, sub_name, sub_no);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AllDto other = (AllDto) obj;
		return Objects.equals(grade, other.grade) && Objects.equals(stu_id, other.stu_id)
				&& Objects.equals(stu_name, other.stu_name) && Objects.equals(sub_name, other.sub_name)
				&& sub_no == other.sub_no;
	}

	public String getStu_id() {
		return stu_id;
	}

	public void setStu_id(String stu_id) {
		this.stu_id = stu_id;
	}

	public String getStu_name() {
		return stu_name;
	}

	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}

	public int getSub_no() {
		return sub_no;
	}

	public void setSub_no(int sub_no) {
		this.sub_no = sub_no;
	}

	public String getSub_name() {
		return sub_name;
	}

	public void setSub_name(String sub_name) {
		this.sub_name = sub_name;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "AllDto [stu_id=" + stu_id + ", stu_name=" + stu_name + ", sub_no=" + sub_no + ", sub_name=" + sub_name
				+ ", grade=" + grade + "]";
	}
	
	
}
