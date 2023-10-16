package com.human.view;

import com.human.model.Model;
import com.human.util.UserInput;

public class StudentsSubjectMenuDeleteView implements ViewInterface {
	@Override
	public void execute(Model model) {
		String stu_id = UserInput.inputString("삭제할 학번 입력>>");
		model.setAttribute("stu_id", stu_id);
	}

}
