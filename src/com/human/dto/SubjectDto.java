package com.human.dto;

import java.util.Objects;

public class SubjectDto {
	private int sub_no;
	private String sub_name;
	private String sub_cont;
	
	public SubjectDto() {}

	public SubjectDto(int sub_no, String sub_name, String sub_cont) {
		super();
		this.sub_no = sub_no;
		this.sub_name = sub_name;
		this.sub_cont = sub_cont;
	}

	@Override
	public int hashCode() {
		return Objects.hash(sub_cont, sub_name, sub_no);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SubjectDto other = (SubjectDto) obj;
		return Objects.equals(sub_cont, other.sub_cont) && Objects.equals(sub_name, other.sub_name)
				&& sub_no == other.sub_no;
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

	public String getSub_cont() {
		return sub_cont;
	}

	public void setSub_cont(String sub_cont) {
		this.sub_cont = sub_cont;
	}

	@Override
	public String toString() {
		return "SubjectDto [sub_no=" + sub_no + ", sub_name=" + sub_name + ", sub_cont=" + sub_cont + "]";
	}
	
	
}
