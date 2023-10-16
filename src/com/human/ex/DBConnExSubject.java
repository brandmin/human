package com.human.ex;

import java.util.ArrayList;

import com.human.dto.SubjectDto;
import com.human.model.Model;
import com.human.service.SubjectService;
import com.human.view.SubjectMenu;
import com.human.view.SubjectMenuDeleteView;
import com.human.view.SubjectMenuInsertView;
import com.human.view.SubjectMenuSelectView;
import com.human.view.SubjectMenuUpdateView;
import com.human.view.ViewInterface;

public class DBConnExSubject {
	static int menuState = 0;
	final static int DEFAULT = 0;
	final static int SELECT = 1;
	final static int INSERT = 2;
	final static int UPDATE = 3;
	final static int DELETE = 4;
	final static int EXIT = 5;
	
	public static void main(String[] args) {
		SubjectService service = new SubjectService();
		Model model = new Model();
		ViewInterface view = null;
		
		while(menuState != -1) {
			view = new SubjectMenu();
			view.execute(model);
			menuState = (int)model.getAttribute("input");
			switch(menuState) {
			case SELECT:
				model = new Model();
				ArrayList<SubjectDto> resultDtos = service.selectAll();
				model.setAttribute("resultDtos", resultDtos);
				view = new SubjectMenuSelectView();
				view.execute(model);
				menuState = DEFAULT;
				break;
			case INSERT:
				model = new Model();
				view = new SubjectMenuInsertView();
				view.execute(model);
				service.insert((SubjectDto)model.getAttribute("dto"));
				menuState = DEFAULT;
				break;
			case UPDATE:
				model = new Model();
				view = new SubjectMenuUpdateView();
				view.execute(model);
				service.update((int)model.getAttribute("sub_no"), (String)model.getAttribute("sub_cont"));
				menuState = DEFAULT;
				break;
			case DELETE:
				model = new Model();
				view = new SubjectMenuDeleteView();
				view.execute(model);
				service.delete((int)model.getAttribute("sub_no"));
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
