package com.human.view;

import java.util.ArrayList;

import com.human.dto.SubjectDto;
import com.human.model.Model;

public class SubjectMenuSelectView implements ViewInterface {
	@Override
	public void execute(Model model) {
		for(SubjectDto dto : (ArrayList<SubjectDto>)model.getAttribute("resultDtos")) {
			System.out.println(dto);
		}
	}
}
