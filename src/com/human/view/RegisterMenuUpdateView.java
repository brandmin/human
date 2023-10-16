package com.human.view;

import com.human.model.Model;
import com.human.util.UserInput;

public class RegisterMenuUpdateView implements ViewInterface {
	@Override
	public void execute(Model model) {
		String stu_id = UserInput.inputString("학번 입력, ");
		int sub_no = UserInput.inputInt("과목번호 입력>>");
		String grade = UserInput.inputString("변경할 학점 입력>>");
		model.setAttribute("stu_id", stu_id);
		model.setAttribute("sub_no", sub_no);
		model.setAttribute("grade", grade);
	}
}
