package com.human.ex;

import java.util.ArrayList;

import com.human.dto.AllDto;
import com.human.dto.RegisterDto;
import com.human.model.Model;
import com.human.service.RegisterService;
import com.human.view.AllSelectView;
import com.human.view.RegisterMenu;
import com.human.view.RegisterMenuInsertView;
import com.human.view.RegisterMenuSelectView;
import com.human.view.RegisterMenuUpdateView;
import com.human.view.ViewInterface;

public class DBConnExRegister {
	static int menuState = 0;
	final static int DEFAULT = 0;
	final static int SELECTRE=1;
	final static int SELECTALL=2;
	final static int INSERT = 3;
	final static int UPDATE = 4;
	final static int EXIT = 5;
	
	public static void main(String[] args) {
		RegisterService service = new RegisterService();
		Model model = new Model();
		ViewInterface view = null;
		
		while(menuState != -1) {
			view = new RegisterMenu();
			view.execute(model);
			menuState = (int)model.getAttribute("input");
			switch(menuState) {
			case SELECTRE:
				model = new Model();
				ArrayList<RegisterDto> resultDtos = service.selectAll();
				model.setAttribute("resultDtos", resultDtos);
				view = new RegisterMenuSelectView();
				view.execute(model);
				menuState = DEFAULT;
				break;
			case SELECTALL:
				model = new Model();
				ArrayList<AllDto> allDtos = service.selectAllStudentsAndSubject();
				model.setAttribute("resultDtos", allDtos);
				view = new AllSelectView();
				view.execute(model);
				menuState = DEFAULT;
				break;
			case INSERT:
				model = new Model();
				view = new RegisterMenuInsertView();
				view.execute(model);
				service.insert((RegisterDto)model.getAttribute("dto"));
				menuState = DEFAULT;
				break;
			case UPDATE:
				model = new Model();
				view = new RegisterMenuUpdateView();
				view.execute(model);
				service.update((String)model.getAttribute("grade"), (int)model.getAttribute("sub_no"), (String)model.getAttribute("stu_id"));
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
