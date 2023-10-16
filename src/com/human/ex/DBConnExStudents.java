package com.human.ex;

import java.util.ArrayList;

import com.human.dto.StudentsDto;
import com.human.model.Model;
import com.human.service.StudentsService;
import com.human.view.StudentsMenu;
import com.human.view.StudentsMenuDeleteView;
import com.human.view.StudentsMenuInsertView;
import com.human.view.StudentsMenuSelectView;
import com.human.view.StudentsMenuUpdateView;
import com.human.view.ViewInterface;

public class DBConnExStudents {
	static int menuState = 0;
	final static int DEFAULT = 0;
	final static int SELECT = 1;
	final static int INSERT = 2;
	final static int UPDATE = 3;
	final static int DELETE = 4;
	final static int EXIT = 5;

	public static void main(String[] args) {
		StudentsService service = new StudentsService();
		Model model = new Model();
		ViewInterface view = null;
		
		while(menuState != -1) {
			view = new StudentsMenu();
			view.execute(model);
			menuState = (int)model.getAttribute("input");
			switch(menuState) {
			case SELECT:
				model = new Model();
				ArrayList<StudentsDto> resultDtos = service.selectAll();
				model.setAttribute("resultDtos", resultDtos);
				view = new StudentsMenuSelectView();
				view.execute(model);
				menuState = DEFAULT;
				break;
			case INSERT:
				model = new Model();
				view = new StudentsMenuInsertView();
				view.execute(model);
				service.insert((StudentsDto)model.getAttribute("dto"));
				menuState = DEFAULT;
				break;
			case UPDATE:
				model = new Model();
				view = new StudentsMenuUpdateView();
				view.execute(model);
				service.update((String)model.getAttribute("stu_id"), (String)model.getAttribute("phone_no"));
				menuState = DEFAULT;
				break;
			case DELETE:
				model = new Model();
				view = new StudentsMenuDeleteView();
				view.execute(model);
				service.delete((String)model.getAttribute("stu_id"));
				menuState = DEFAULT;
				break;
			case EXIT:
				System.out.println("프로그램 종료");
				menuState = -1;
				break;
			default:
				System.out.println("잘못된 입력");
				menuState = DEFAULT;
				break;
			}
				

		}
	}
}
