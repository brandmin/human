package com.human.view;

import com.human.dto.SubjectDto;
import com.human.model.Model;
import com.human.util.UserInput;

public class SubjectMenuInsertView implements ViewInterface {
	@Override
	public void execute(Model model) {
		SubjectDto dto = new SubjectDto();
		dto.setSub_no(UserInput.inputInt("생성할 과목번호 입력>>"));
		dto.setSub_name(UserInput.inputString("생성할 과목명 입력>>"));
		dto.setSub_cont(UserInput.inputString("학과기초/전공 둘중 하나를 입력해주세요>>"));
		model.setAttribute("dto", dto);
	}
}
