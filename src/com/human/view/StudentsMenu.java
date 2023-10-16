package com.human.view;

import com.human.model.Model;
import com.human.util.UserInput;

public class StudentsMenu implements ViewInterface {
	@Override
	public void execute(Model model) {
		int input = UserInput.inputInt(" | 1. SELECT | 2. INSERT | 3. UPDATE | 4. DELETE | 5. EXIT |\n");
		model.setAttribute("input", input);
	}
}
