package com.human.view;

import com.human.model.Model;
import com.human.util.UserInput;

public class StudentsSubjectMenuDeleteSubView implements ViewInterface {
	@Override
	public void execute(Model model) {
		int sub_no = UserInput.inputInt("삭제할 과목번호 입력>>");
		String stu_id = UserInput.inputString("삭제할 학번 입력>>");
		model.setAttribute("sub_no", sub_no);
		model.setAttribute("stu_id", stu_id);
	}
}
