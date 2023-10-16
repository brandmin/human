package com.human.ex;

import java.util.ArrayList;

import com.human.dto.StudentsSubjectDto;
import com.human.model.Model;
import com.human.service.StudentsSubjectService;
import com.human.view.StudentsSubjectMenu;
import com.human.view.StudentsSubjectMenuDeleteSubView;
import com.human.view.StudentsSubjectMenuDeleteView;
import com.human.view.StudentsSubjectMenuInsertView;
import com.human.view.StudentsSubjectMenuSelectView;
import com.human.view.StudentsSubjectMenuUpdateView;
import com.human.view.ViewInterface;

public class DBConnExStudentsSubjects {
	static int menuState = 0;
	final static int DEFAULT = 0;
	final static int SELECT = 1;
	final static int INSERT = 2;
	final static int UPDATE = 3;
	final static int DELETEST = 4;
	final static int DELETESUB = 5;
	final static int EXIT = 6;
	
	public static void main(String[] args) {
		StudentsSubjectService service = new StudentsSubjectService();
		Model model = new Model();
		ViewInterface view = null;
		
		while(menuState != -1) {
			view = new StudentsSubjectMenu();
			view.execute(model);
			menuState = (int)model.getAttribute("input");
			switch(menuState) {
			case SELECT:
				model = new Model();
				ArrayList<StudentsSubjectDto> resultDtos = service.selectAll();
				model.setAttribute("resultDtos", resultDtos);
				view = new StudentsSubjectMenuSelectView();
				view.execute(model);
				menuState = DEFAULT;
				break;
			case INSERT:
				model = new Model();
				view = new StudentsSubjectMenuInsertView();
				view.execute(model);
				service.insertDB((StudentsSubjectDto)model.getAttribute("dto"));
				menuState = DEFAULT;
				break;
			case UPDATE:
				model = new Model();
				view = new StudentsSubjectMenuUpdateView();
				view.execute(model);
				service.update((String)model.getAttribute("stu_id"), (int)model.getAttribute("sub_no"), (String)model.getAttribute("grade"));
				menuState = DEFAULT;
				break;
			case DELETEST:
				model = new Model();
				view = new StudentsSubjectMenuDeleteView();
				view.execute(model);
				service.deleteStudents((String)model.getAttribute("stu_id"));
				menuState = DEFAULT;
				break;
			case DELETESUB:
				model = new Model();
				view = new StudentsSubjectMenuDeleteSubView();
				view.execute(model);
				service.deleteSubject((int)model.getAttribute("sub_no"), (String)model.getAttribute("stu_id"));
				menuState = DEFAULT;
				break;
			case EXIT:
				System.out.println("프로그램 종료");
				menuState = -1;
				break;
			case DEFAULT:
				System.out.println("잘못된 입력");
				menuState = DEFAULT;
				break;
			}
		}
	}

}
