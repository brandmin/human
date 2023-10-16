package com.human.view;

import com.human.dto.StudentsDto;
import com.human.model.Model;
import com.human.util.UserInput;

public class StudentsMenuInsertView implements ViewInterface {
	@Override
	public void execute(Model model) {
		StudentsDto dto = new StudentsDto();
		dto.setStu_id(UserInput.inputString("생성할 학번 입력>>"));
		dto.setStu_name(UserInput.inputString("생성할 이름 입력>>"));
		dto.setPhone_no(UserInput.inputString("생성할 전화번호 입력>>"));
		model.setAttribute("dto", dto);
	}
}
