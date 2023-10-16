package com.human.view;

import java.util.ArrayList;

import com.human.dto.StudentsDto;
import com.human.model.Model;

public class StudentsMenuSelectView implements ViewInterface {
	@Override
	public void execute(Model model) {
		for(StudentsDto dto : (ArrayList<StudentsDto>)model.getAttribute("resultDtos")) {
			System.out.println(dto);
		}
	}
}
