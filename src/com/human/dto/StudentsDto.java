package com.human.dto;

import java.util.Objects;

public class StudentsDto {
	private String stu_id;
	private String stu_name;
	private String phone_no;
	
	public StudentsDto() {}

	public StudentsDto(String stu_id, String stu_name, String phone_no) {
		super();
		this.stu_id = stu_id;
		this.stu_name = stu_name;
		this.phone_no = phone_no;
	}

	@Override
	public int hashCode() {
		return Objects.hash(phone_no, stu_id, stu_name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentsDto other = (StudentsDto) obj;
		return Objects.equals(phone_no, other.phone_no) && Objects.equals(stu_id, other.stu_id)
				&& Objects.equals(stu_name, other.stu_name);
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

	public String getPhone_no() {
		return phone_no;
	}

	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}

	@Override
	public String toString() {
		return "StudentsDto [stu_id=" + stu_id + ", stu_name=" + stu_name + ", phone_no=" + phone_no + "]";
	}
	
	
}
