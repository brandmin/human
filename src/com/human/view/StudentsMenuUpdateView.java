package com.human.view;

import com.human.model.Model;
import com.human.util.UserInput;

public class StudentsMenuUpdateView implements ViewInterface {
	@Override
	public void execute(Model model) {
		String stu_id = UserInput.inputString("학번 입력>>");
		String phone_no = UserInput.inputString("변경할 전화번호 입력>>");
		model.setAttribute("stu_id", stu_id);
		model.setAttribute("phone_no", phone_no);
	}
}
