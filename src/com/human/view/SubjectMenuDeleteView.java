package com.human.view;

import com.human.model.Model;
import com.human.util.UserInput;

public class SubjectMenuDeleteView implements ViewInterface {
	@Override
	public void execute(Model model) {
		int sub_no = UserInput.inputInt("삭제할 과목번호 입력>>");
		model.setAttribute("sub_no", sub_no);
	}
}
