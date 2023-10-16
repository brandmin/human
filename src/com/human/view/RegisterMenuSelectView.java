package com.human.view;

import java.util.ArrayList;

import com.human.dto.RegisterDto;
import com.human.model.Model;

public class RegisterMenuSelectView implements ViewInterface {
	@Override
	public void execute(Model model) {
		for(RegisterDto dto : (ArrayList<RegisterDto>)model.getAttribute("resultDtos")) {
			System.out.println(dto);
		}
	}
}
