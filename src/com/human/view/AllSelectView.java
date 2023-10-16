package com.human.view;

import java.util.ArrayList;

import com.human.dto.AllDto;
import com.human.model.Model;

public class AllSelectView implements ViewInterface {
	@Override
	public void execute(Model model) {
		for(AllDto dto : (ArrayList<AllDto>)model.getAttribute("resultDtos")) {
			System.out.println(dto);
		}
	}
}
