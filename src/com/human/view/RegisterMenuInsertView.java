package com.human.view;

import com.human.dto.RegisterDto;
import com.human.model.Model;
import com.human.util.UserInput;

public class RegisterMenuInsertView implements ViewInterface {
	@Override
	public void execute(Model model) {
		RegisterDto dto = new RegisterDto();
		dto.setStu_id(UserInput.inputString("생성할 학번 입력>>"));
		dto.setSub_no(UserInput.inputInt("생성할 과목번호 입력>>"));
		dto.setGrade(UserInput.inputString("생성할 학점 입력>>"));
		model.setAttribute("dto", dto);
	}

}
