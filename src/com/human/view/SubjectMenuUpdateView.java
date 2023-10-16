package com.human.view;

import com.human.model.Model;
import com.human.util.UserInput;

public class SubjectMenuUpdateView implements ViewInterface {
	@Override
	public void execute(Model model) {
		int sub_no = UserInput.inputInt("과목번호 입력>>");
		String sub_cont = UserInput.inputString("수정할 내용 입력>>");
		model.setAttribute("sub_no", sub_no);
		model.setAttribute("sub_cont", sub_cont);
	}
}
