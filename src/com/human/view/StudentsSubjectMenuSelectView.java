package com.human.view;

import java.util.ArrayList;

import com.human.dto.StudentsSubjectDto;
import com.human.model.Model;

public class StudentsSubjectMenuSelectView implements ViewInterface {
	@Override
	public void execute(Model model) {
		for(StudentsSubjectDto dto : (ArrayList<StudentsSubjectDto>)model.getAttribute("resultDtos")) {
			System.out.println(dto);
		}
	}
}
