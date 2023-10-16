package com.human.view;

import com.human.model.Model;
import com.human.util.UserInput;

public class RegisterMenu implements ViewInterface {
	@Override
	public void execute(Model model) {
		int input = UserInput.inputInt(" | 1. SELECTRE | 2. SELECTAll | 3. INSERT | 4. UPDATE | 5. EXIT | \n");
		model.setAttribute("input", input);
	}
}
