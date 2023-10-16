package com.human.dto;

import java.util.List;
import com.human.dto.*;
import java.util.Objects;

public class StudentsSubjectDto {
	private String stu_id;
	private String stu_name;
	private String phone_no;
	private List<RegisterDto> registers;
	
	public StudentsSubjectDto() {}

	public StudentsSubjectDto(String stu_id, String stu_name, String phone_no, List<RegisterDto> registers) {
		super();
		this.stu_id = stu_id;
		this.stu_name = stu_name;
		this.phone_no = phone_no;
		this.registers = registers;
	}

	@Override
	public int hashCode() {
		return Objects.hash(phone_no, registers, stu_id, stu_name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentsSubjectDto other = (StudentsSubjectDto) obj;
		return Objects.equals(phone_no, other.phone_no) && Objects.equals(registers, other.registers)
				&& Objects.equals(stu_id, other.stu_id) && Objects.equals(stu_name, other.stu_name);
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

	public List<RegisterDto> getRegisters() {
		return registers;
	}

	public void setRegisters(List<RegisterDto> registers) {
		this.registers = registers;
	}

	@Override
	public String toString() {
		return "StudentsSubjectDto [stu_id=" + stu_id + ", stu_name=" + stu_name + ", phone_no=" + phone_no
				+ ", registers=" + registers + "]";
	}
	
	public StudentsDto toStudentsDto() {
		return new StudentsDto(stu_id, stu_name, phone_no);
	}
}
