package com.human.view;

import java.util.ArrayList;
import java.util.List;

import com.human.dto.RegisterDto;
import com.human.dto.StudentsSubjectDto;
import com.human.model.Model;
import com.human.util.UserInput;

public class StudentsSubjectMenuInsertView implements ViewInterface {
	@Override
	public void execute(Model model) {
		StudentsSubjectDto dto = new StudentsSubjectDto();
		dto.setStu_id(UserInput.inputString("생성할 학번 입력>>"));
		dto.setStu_name(UserInput.inputString("생성할 이름 입력>>"));
		dto.setPhone_no(UserInput.inputString("생성할 전화번호 입력>>"));
		
		ArrayList<RegisterDto> rDto = new ArrayList();
		String inputString = "";
		while(!inputString.equals("EXIT")) {
			rDto.add(new RegisterDto(null, UserInput.inputInt("과목 번호"), UserInput.inputString("학점")));
			inputString = UserInput.inputString("과목 입력 종료시 EXIT, 그렇지 않으면 ADD>>");
		}
		model.setAttribute("dto", dto);
		model.setAttribute("rDto", rDto);
		dto.setRegisters(rDto);
		System.out.println(dto.getRegisters());
	}
}
